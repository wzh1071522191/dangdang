package com.jk.controller;

import com.jk.ftp.FtpFileUtil;
import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.repository.BookRepository;
import com.jk.service.BookService;
import com.jk.util.AlYunOssUtil;
import com.jk.util.ParameUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 14:10
 * @Description :   商品书籍控制层
 * @Package :   com.jk.controller
 */
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @RequestMapping("toBook")
    public String toBook(){

        return "zsg/book";
    }
    @RequestMapping("queryBook")
    @ResponseBody
    public HashMap<String,Object> queryBook1(@RequestBody ParameUtil parameUtil){
        return bookService.queryBook(parameUtil);
    }

    @RequestMapping("toAddPage")
    public String toAddPage(){
        return "zsg/addBook";
    }

    @RequestMapping("queryBookType")
    @ResponseBody
    public List<BookType> queryBookType(Integer pid){
        List<BookType> list =bookService.queryBookType(pid);
        return list;
    }

    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("upLoadFile")
    @ResponseBody
    public String uploadImg(MultipartFile imgName)throws IOException {
        if (imgName == null || imgName.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        AlYunOssUtil ossClient=new AlYunOssUtil();
        String name = ossClient.uploadImg2Oss(imgName);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        System.out.println(split[0]);
        return split[0];
    }

    @RequestMapping("delBook")
    @ResponseBody
    public void delBook(Integer id){
        bookService.delBook(id);
        bookRepository.deleteById (id);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Book book){
        Book book1=bookService.updateStatus(book);
        bookRepository.deleteById (book.getBookId ());
        if(book.getBookStatus ()==2){
            bookRepository.save (book1);
        }
        return null;
    }

    @RequestMapping("toUpdatePage")
    @ResponseBody
    public ModelAndView toUpdatePage(Integer id){
        ModelAndView mv = new ModelAndView();
        Book book =bookService.queryBookById(id);
        mv.addObject ("b",book);
        mv.setViewName ("zsg/updateBook");
        return mv;
    }

    @RequestMapping("addBook")
    @ResponseBody
    public String addBook(Book book){
        Integer id=book.getBookId ();
        Book b = bookService.addBook (book);
        if(id==null){

            bookRepository.save (b);
        }else {
            bookRepository.deleteById (book.getBookId ());
            bookRepository.save (b);
        }
        return "1";
    }

    @RequestMapping("queryBook1")
    @ResponseBody
    public Map queryBook(@RequestBody ParameUtil parm){
        //System.out.println (parm.getTypename ());
        if (parm.getPageSize() == null)
            parm.setPageSize(1);
        if (parm.getPageNumber() == null)
            parm.setPageNumber(1);
        Map<String, Object> map = new HashMap<>();
        //创建一个查询组件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
       /* if (key!=null && !"".equals(key)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("copy", key));
        }*/
        if (parm.getTypename()!=null && !"".equals(parm.getTypename())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("booknNme",parm.getTypename()));}

        //区间查询
       /* if (store.ge()!=null && !"".equals(book.getMinprice()) && book.getMaxprice()!=null && !"".equals(book.getMaxprice())) {

            boolQueryBuilder.filter(QueryBuilders.rangeQuery("bookprice").from(book.getMinprice()).to(book.getMaxprice()));
        }else {
            if (book.getMinprice() != null && !"".equals(book.getMinprice())) {
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("bookprice").gte(book.getMinprice()));
            }
            if (book.getMaxprice()!=null && !"".equals(book.getMaxprice())) {
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("bookprice").lte(book.getMaxprice()));
            }
        }*/

        //获取高亮组件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("bookName");//设置高亮字段
        highlightBuilder.preTags("<span style='color:red;'>");//设置前缀
        highlightBuilder.postTags("</span>");//设置后缀
        //设置查询策略
        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch("bookindex")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setTypes("book")//设置表名
                .setExplain(true)//设置是否对相关度排序
                .highlighter(highlightBuilder)//设置高亮策略
                .setQuery(boolQueryBuilder)//设置查询策略
                // .addSort("bookprice", SortOrder.DESC)//设置排序策略，这里是对价格进行倒序排序
                .setFrom((parm.getPageNumber() - 1) *parm.getPageSize())//设置分页起始条数
                .setSize(parm.getPageSize());//设置每页条数


        //获取响应体
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();

        //获取总条数
        long totalHits = hits.totalHits;
        //获取数据存放的组件
        SearchHit[] hits1 = hits.getHits();
        //放入查询的数据
        List<Book> book = new ArrayList<> ();
        DateTimeFormatter defaultDatePrinter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        for (SearchHit hit:hits1){
            Book b = new Book();
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("bookName");
            //处理高亮字段
            if (title==null){//如果是空就用普通字段代替
                b.setBookName (hit.getSourceAsMap().get("bookName").toString());
            }else{//如果非空就用高亮字段替换掉查询出的字段
                b.setBookName(title.fragments()[0].toString());
            }
            //依次将查询出的其它字段放入对象中
            b.setBookAuthor (hit.getSourceAsMap().get("bookAuthor").toString());
            b.setBookId ((Integer)hit.getSourceAsMap().get("bookId"));
            b.setBookPrice ((Double) hit.getSourceAsMap().get("bookPrice"));
            b.setPress (hit.getSourceAsMap().get("press").toString ());
            b.setBookContent (hit.getSourceAsMap().get("bookContent").toString ());
            b.setBookStatus ((Integer)hit.getSourceAsMap().get("bookStatus"));
            b.setBookCount ((Integer)hit.getSourceAsMap().get("bookCount"));
            b.setBookStar ((Integer)hit.getSourceAsMap().get("bookStar"));
            b.setBookImg1 (hit.getSourceAsMap().get("bookImg1").toString ());
            b.setBookImg2 (hit.getSourceAsMap().get("bookImg2").toString ());
            b.setBookImg3 (hit.getSourceAsMap().get("bookImg3").toString ());
            b.setTypeName (hit.getSourceAsMap().get("typeName").toString ());

           // System.out.println (hit.getSourceAsMap().get("bookdate"));
            book.add(b);
        }
        map.put("total",totalHits);
        map.put("rows",book);
        return map;
    }

    //ftp上传文件(图片)
    @RequestMapping("upLoadFileFtp")
    @ResponseBody
    public String upLoadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        String fileName = file.getOriginalFilename();
        InputStream inputStream=file.getInputStream();
        String filePath=null;
        Boolean flag= FtpFileUtil.uploadFile(fileName,inputStream);
        if(flag==true){
            System.out.println("ftp上传成功！");
            filePath=fileName;
            System.out.println (filePath);
        }
        return  filePath;  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片

    }


}
