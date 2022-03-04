package com.mh.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/16 - 13:59
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class FileToolUp {
    /**
     * Description: 向FTP服务器上传文件
     *
     * @param url      FTP服务器hostname
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path     FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     * @Version 1.0
     */
    public static boolean uploadFile(String url,        // FTP服务器hostname
                                     int port,          // FTP服务器端口
                                     String username,   // FTP登录账号
                                     String password,   // FTP登录密码
                                     String path,       // FTP服务器保存目录
                                     String filename,   // 上传到 FTP 服务器上的文件名
                                     InputStream input  // 输入流
    ) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(url, port);// 连接 FTP服务器
            // 如果采用默认端口，可以使用 ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(path);
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * 将本地文件上传到 FTP服务器上 *
     */
    public static void upLoadFromProduction(String url,         // FTP服务器 hostname
                                            int port,           // FTP服务器端口
                                            String username,    // FTP登录账号
                                            String password,    // FTP登录密码
                                            String path,        // FTP服务器保存目录
                                            String filename,    // 上传到FTP服务器上的文件名
                                            String orginfilename // 输入流文件名
    ) {
        try {
            FileInputStream in = new FileInputStream(new File(orginfilename));
            System.out.println("开始上传......");
            boolean flag = uploadFile(url, port, username, password, path, filename, in);
            System.out.println("上传结果:" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void upLoadFromProduction(String filename, String sourceFile) {
        upLoadFromProduction("121.4.26.166", 21, "ftp", "include", "pub", filename, sourceFile);
    }

    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        String sourceFile = scanner.nextLine();

        upLoadFromProduction(filename, sourceFile);
    }
}
