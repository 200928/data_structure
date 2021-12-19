package com.mh.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/16 - 15:01
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class FileTool_ {

    /**
     * FTP IP
     */
    private String ftpHost = "121.4.26.166";
    /**
     * FTP用户名
     */
    private String ftpUserName = "ftp";
    /**
     * FTP密码
     */
    private String ftpPassword = "include";
    /**
     * FTP 端口 默认21
     */
    private int ftpPort = 21;

    public static final String CHARSET_GBK = "GBK";

    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String CHARSET_ISO = "iso-8859-1";

    public static final String basePath = "pub/";

    /**
     * 获取FTPClient
     *
     * @return
     */
    public FTPClient getFTPClient() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            // 连接FTP服务器
            ftpClient.connect(ftpHost, ftpPort);
            // 登陆FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /**
     * 下载文件
     *
     * @param filename  ftp文件名
     * @param localPath 本地文件路径
     */
    public boolean downloadFile(String filename, String localPath) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(ftpHost, ftpPort);
            ftp.login(ftpUserName, ftpPassword);
            //设置文件编码格式
            ftp.setControlEncoding("UTF-8");
            //ftp通信有两种模式
            //PORT(主动模式)客户端开通一个新端口(>1024)并通过这个端口发送命令或传输数据,期间服务端只使用他开通的一个端口，例如21
            //PASV(被动模式)客户端向服务端发送一个PASV命令，服务端开启一个新端口(>1024),并使用这个端口与客户端的21端口传输数据
            //由于客户端不可控，防火墙等原因，所以需要由服务端开启端口，需要设置被动模式
            ftp.enterLocalPassiveMode();
            //设置传输方式为流方式
            ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            //获取状态码，判断是否连接成功
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                throw new RuntimeException("FTP服务器拒绝连接");
            }

            int index = filename.lastIndexOf("/");
            //获取文件的路径
            String path = filename.substring(0, index);
            //获取文件名
            String name = filename.substring(index + 1);
            //判断是否存在目录
            if (!ftp.changeWorkingDirectory(basePath + path)) {
                throw new RuntimeException("文件路径不存在：" + basePath + path);
            }
            //获取该目录所有文件
            FTPFile[] files = ftp.listFiles();
            for (FTPFile file : files) {
                //判断是否有目标文件
                //System.out.println("文件名"+file.getName()+"---"+name);
                if (file.getName().equals(name)) {
                    //System.out.println("找到文件");
                    //如果找到，将目标文件复制到本地
                    File localFile = new File(localPath + "/" + file.getName());
                    OutputStream out = new FileOutputStream(localFile);
                    ftp.retrieveFile(file.getName(), out);
                    out.close();
                }
            }
            ftp.logout();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 上传文件
     *
     * @param ftpPath  ftp文件存放物理路径
     * @param fileName 上传到服务器的文件名
     * @param input    文件输入流，即从本地服务器读取文件的IO输入流
     */
    public void uploadFile(String ftpPath, String fileName, InputStream input) {
        FTPClient ftp = null;
        try {
            ftp = getFTPClient();
            ftp.changeWorkingDirectory(ftpPath);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            fileName = new String(fileName.getBytes(CHARSET_UTF8), CHARSET_ISO);
            ftp.storeFile(fileName, input);
            input.close();
            ftp.logout();
            System.out.println("upload succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }
}