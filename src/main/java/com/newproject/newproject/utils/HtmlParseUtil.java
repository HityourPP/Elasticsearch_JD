package com.newproject.newproject.utils;

import com.newproject.newproject.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
@Component
//该类用于解析网页
public class HtmlParseUtil {
    //public  static void main(String[] args) throws IOException {
//        //获取请求  https://search.jd.com/Search?keyword=Java
//        //前提，需要联网
//        String url = "https://search.jd.com/Search?keyword=Java";
//        //解析网页,JSoup返回Document就是浏览器中的Document对象
//        Document document = Jsoup.parse(new URL(url), 30000);
//        //在JS中可以使用的方法在这里也能用
//        Element element = document.getElementById("J_goodsList");
//        //System.out.println(element.html());//测试输出
//        //获取所有的li元素
//        Elements elements = element.getElementsByTag("li");
//        //获取元素中的内容,这里的el就是对应的li标签元素
//        for(Element el:elements){
//            //关于图片特别多的网站，图片都是延迟加载的！
//            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
//            String price = el.getElementsByClass("p-price").eq(0).text();
//            String title = el.getElementsByClass("p-name").eq(0).text();
//            System.out.println("===============");
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(title);
//        }
    //}
    public  static  void main(String[] args) throws IOException {
        //调用下面的类
        new HtmlParseUtil().parseJD("华为").forEach(System.out::println);
    }
    public List<Content> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword="+keywords;
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Content> goodsList = new ArrayList<>();

        for(Element el:elements){
            if(!el.attr("class").equalsIgnoreCase("ps-item")){
                String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String price = el.getElementsByClass("p-price").eq(0).text();
                String title = el.getElementsByClass("p-name").eq(0).text();
                //设置数据
                Content content = new Content();
                content.setTitle(title);
                content.setPrice(price);
                content.setImg(img);
                goodsList.add(content);//放入到数组中
            }
        }
        return goodsList;//返回数据数组
    }
}
