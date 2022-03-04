package com.mh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/11/28 - 16:17
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class PhotoDownload {
    public static void main(String[] args) throws MalformedURLException, IOException {
        Scanner scanner = new Scanner(System.in);
        // 获取 URL
//        String url = "https://www.jianshu.com/p/4315b1f8c9cb";
        System.out.print("请输入URL：");
        String url = scanner.nextLine();

        // 获取 URL 的源代码
        Document document = Jsoup.parse(new URL(url), 1000000);

        // 获取元素 id 为 post 的源代码
        System.out.print("请输入元素ID：");
        String id = scanner.nextLine();
//        Element element = document.getElementById("__next");
        Element element = document.getElementById(id);

        // 获取 img 标签
        Elements imgs = element.getElementsByTag("img");
        System.out.println(imgs);

        // 获取 img 标签里面为 data-lazy-src 属性的内容
        int count = 0;
        System.out.print("请输入img里面链接的参数：");
        String img_title = scanner.nextLine();

        System.out.print("请输入前缀：");
        String https = scanner.nextLine();

        for (Element img : imgs) {
//            String src = img.attr("data-original-src");
            String src = img.attr(img_title);
            System.out.println("src:" + https + src);
//            URL imgUrl = new URL("https:" + src);
            URL imgUrl = new URL(https + src);
            URLConnection urlConnection = imgUrl.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            OutputStream outputStream = new FileOutputStream("F:\\imgs\\" + count++ + ".jpg");
            int tmp = 0;
            while ((tmp = inputStream.read()) != -1) {
                outputStream.write(tmp);
            }
            System.out.println(count + ".jpg 下载完毕！");
            inputStream.close();
            outputStream.close();
        }
        // System.out.println(imgs);
    }
}
