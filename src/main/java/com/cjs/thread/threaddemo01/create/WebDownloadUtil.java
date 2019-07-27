package com.cjs.thread.threaddemo01.create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从网络下载资源到本地工具类
 */
public class WebDownloadUtil {

    public static void download(String url, String path) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("不合法的url路径");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
