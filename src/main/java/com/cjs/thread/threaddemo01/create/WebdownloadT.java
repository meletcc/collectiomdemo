package com.cjs.thread.threaddemo01.create;

public class WebdownloadT extends Thread {

    private String url;
    private String path;

    public WebdownloadT(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        WebDownloadUtil.download(url, path);
    }

    public static void main(String[] args) {
        WebdownloadT t = new WebdownloadT("", "");
        WebdownloadT t1 = new WebdownloadT("", "");
        WebdownloadT t2 = new WebdownloadT("", "");
        // 开启三个线程
        t.start();
        t1.start();
        t2.start();
    }

}
