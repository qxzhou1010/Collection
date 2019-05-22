package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL类的使用
 */
public class Test03 {
    public static void main(String[] args) throws MalformedURLException {
//        test01();
        basicSpider();

    }

    public static void test01() throws MalformedURLException {
        URL url = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
        System.out.println("获取与此url关联的协议的默认端口:" + url.getDefaultPort());
        System.out.println("getFile:" + url.getFile());//端口号后面的内容
        System.out.println("获取主机名:" + url.getHost());//
        System.out.println("获取路径:" + url.getPath()); //端口号后，参数前的内容
        //
        System.out.println("端口:" + url.getPort());
        System.out.println("协议:" + url.getProtocol());
        System.out.println("参数部分:" + url.getQuery());
        System.out.println("锚点：" + url.getRef());

        URL url1 = new URL("http://www.abc.com/aa/");
        URL url2 = new URL(url,"2.html");//相对路径构建url对象
        System.out.println(url2.toString());//

    }

    /**
     * 一个简单的网络爬虫
     */
    static void basicSpider(){
        URL url = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        try {
            url = new URL("http://www.baidu.com");
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            //这样的方式将网络内容下载到本地机器
            //然后进行数据分析，建立索引
            while ((temp = br.readLine()) != null){
                sb.append(temp);
                // \r回车 \n换行
                sb.append("\r\n");
            }


        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


        System.out.println(sb);
   }

}
