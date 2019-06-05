public class PostExceptionTask implements Runnable {

    private String url;

    public PostExceptionTask(String url) {
        this.url = url;
    }

    public void run() {
        while (true) {
            long startTime = System.currentTimeMillis();
            String responseMsg = HttpRequestUtils.sendGet(url, "");
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间： " + (endTime - startTime) + "ms，返回结果：" + responseMsg);
        }
    }
}
