package com.jk.util;

import com.alibaba.dubbo.common.logger.*;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/21 17:17
 * @description：阿里OSS工具类
 * @package ：com.jk.util
 * @version: 1.0.0
 */
public class AlYunOssUtil {

    public static final Logger logger = LoggerFactory.getLogger(AlYunOssUtil.class);


    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    // accessKey
    private String accessKeyId = "LTAIB5IFr7msJrOL";
    private String accessKeySecret = "WeLzRSUN8kSfYFpMixyM3iX2uVIJRd";
    // 空间
    private String bucketName = "zsg0604";
    // 文件存储目录
    private String filedir = "zsg0604/";



    private OSSClient ossClient;

    public AlYunOssUtil() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 初始化
     */
    public void init() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }


    public void uploadImg2Oss(String url) throws IOException {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            this.uploadFile2OSS(fin, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            throw new IOException("图片上传失败");
        }
    }

    public String uploadImg2Oss(MultipartFile file) throws IOException {
        if (file.getSize() > 10 * 1024 * 1024) {
            throw new IOException("上传图片大小不能超过10M！");
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2OSS(inputStream, name);
            return name;
        } catch (Exception e) {
            throw new IOException("图片上传失败");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        System.out.println(fileUrl);
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return this.getUrl(this.filedir + split[split.length - 1]);
        }
        return "" ;
    }

    /**
     * 上传到OSS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2OSS(InputStream instream, String fileName) {

        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (instream !=null ) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10

        Date expiration = new Date(System.currentTimeMillis() + 36001 * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            System.out.println(url);
            return url.toString();
        }
        return  "";
    }}
