package com.mh.servlet;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/17 - 15:49
 * @ Description: com.mh.servlet
 * @ Version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseDemo01 extends HttpServlet {

    private static final long serialVersionUID = 4312868947607181532L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outputChineseByPrintWriter(response);//使用PrintWriter流输出中文
    }

    /**
     * 使用PrintWriter流输出中文
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputChineseByPrintWriter(HttpServletResponse response) throws IOException{
        String data = "中国";

        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        //response.setHeader("content-type", "text/html;charset=UTF-8");

        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        /**
         * PrintWriter out = response.getWriter();这句代码必须放在response.setCharacterEncoding("UTF-8");之后
         * 否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码
         */
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        /**
         * 多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为
         * out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * 等同于response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);//使用PrintWriter流向客户端输出字符
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}