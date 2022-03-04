package com.mh.utils;

import java.io.FileNotFoundException;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/16 - 15:06
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        Scanner scanner = new Scanner(System.in);
//        String fileLost = scanner.nextLine();
//        String sourceFile = scanner.nextLine();
//        String filename = scanner.nextLine();

        FileTools fileTools = new FileTools();
        System.out.println(fileTools.toString());
//        File file = new File("F:\\test_app\\软件工程课堂演讲评分表格.pdf");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        boolean flag = fileTools.fileUpload("","test.pdf",fileInputStream);
//        System.out.println(flag ? "success" : "error");

        fileTools.downloadFile("/软件工程.pdf", "F:\\test_app");

//        fileTools.downloadFile("/test.pdf", "F:\\test_app");


    }
}
