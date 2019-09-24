package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.LunBo;
import com.jk.service.ConsumerBookService;
import com.jk.util.ParameUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/20 15:13
 * @Description :   客户端控制层
 * @Package :   com.jk.controller
 */
@Controller
@RequestMapping("consumerBook")
public class ConsumerBookController {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ConsumerBookService consumerBookService;

    @RequestMapping("toIndex1")
    public String toIndex(Model model){
        HashMap<String,Object> hashMap =consumerBookService.queryBookAll();

        List<Book> bookList =(List<Book>) hashMap.get ("book");
        List<Book> bookList2=(List<Book>) hashMap.get ("b");
        model.addAttribute ("book",bookList);
        model.addAttribute ("b",bookList2);
        return "Index";
    }





    @RequestMapping("queryBookByType")
    @ResponseBody
    public List<Book> queryBookByType(Integer typeId){

        return consumerBookService.queryBookByType(typeId);
    }

    @RequestMapping("index")
    public ModelAndView queryBook(ParameUtil parm,Model model,String key,Integer bookTypeId){
        ModelAndView mv =new  ModelAndView();

        Map<String, Object> map = new HashMap<>();
        //创建一个查询组件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (key!=null && !"".equals(key)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("copy", key));
        }
        if (parm.getTypename()!=null && !"".equals(parm.getTypename())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("bookName",parm.getTypename()));}

        if(parm.getTypeId ()!=null&&!"".equals (parm.getTypeId ())){
            boolQueryBuilder.filter (QueryBuilders.termQuery ("bookTypeId",parm.getTypeId()));
        }
        if(parm.getTypePid ()!=null&&!"".equals(parm.getTypePid ())){
            boolQueryBuilder.filter (QueryBuilders.termQuery ("bookTypePid",parm.getTypePid()));
        }
        //System.out.println (parm.getTypePid ());
        //获取高亮组件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("bookName");//设置高亮字段
        highlightBuilder.preTags("");//设置前缀
        highlightBuilder.postTags("");//设置后缀
        //设置查询策略
        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch("bookindex")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setTypes("book")//设置表名
                .setExplain(true)//设置是否对相关度排序
                .highlighter(highlightBuilder)//设置高亮策略
                .setFrom (0)
                .setSize (100)
                .setQuery(boolQueryBuilder);//设置查询策略

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
            b.setHits ((Integer) hit.getSourceAsMap().get("hits"));
            b.setBookStar ((Integer)hit.getSourceAsMap().get("bookStar"));
            b.setBookImg1 (hit.getSourceAsMap().get("bookImg1").toString ());
            b.setBookImg2 (hit.getSourceAsMap().get("bookImg2").toString ());
            b.setBookImg3 (hit.getSourceAsMap().get("bookImg3").toString ());
            b.setTypeName (hit.getSourceAsMap().get("typeName").toString ());
            b.setBuyCount ((Integer)hit.getSourceAsMap().get("buyCount"));
            if(b.getBuyCount ()==null){
                b.setBuyCount (0);
            }
            book.add(b);
        }
        if(bookTypeId==null){
            bookTypeId=23;
        }
        HashMap<String,Object> query=consumerBookService.queryAll(bookTypeId);
        mv.addObject ("imgs",query.get ("img"));
        mv.addObject ("blist",query.get ("blist"));
        mv.addObject ("bk",query.get ("bk1"));
        mv.addObject ("bk2",query.get ("bk2"));
        mv.addObject ("bk3",query.get ("bk3"));
        mv.addObject ("bk4",query.get ("bk4"));
        mv.addObject ("kj",query.get ("kj"));
        mv.addObject ("bookChird",query.get ("bookChird"));
        mv.addObject ("book",book);

        mv.setViewName ("index");
        return mv;
    }






}
