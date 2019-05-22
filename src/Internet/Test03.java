package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL���ʹ��
 */
public class Test03 {
    public static void main(String[] args) throws MalformedURLException {
//        test01();
        basicSpider();

    }

    public static void test01() throws MalformedURLException {
        URL url = new URL("http://www.google.cn:80/webhp#aa?canhu=33");
        System.out.println("��ȡ���url������Э���Ĭ�϶˿�:" + url.getDefaultPort());
        System.out.println("getFile:" + url.getFile());//�˿ںź��������
        System.out.println("��ȡ������:" + url.getHost());//
        System.out.println("��ȡ·��:" + url.getPath()); //�˿ںź󣬲���ǰ������
        //
        System.out.println("�˿�:" + url.getPort());
        System.out.println("Э��:" + url.getProtocol());
        System.out.println("��������:" + url.getQuery());
        System.out.println("ê�㣺" + url.getRef());

        URL url1 = new URL("http://www.abc.com/aa/");
        URL url2 = new URL(url,"2.html");//���·������url����
        System.out.println(url2.toString());//

    }

    /**
     * һ���򵥵���������
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
            //�����ķ�ʽ�������������ص����ػ���
            //Ȼ��������ݷ�������������
            while ((temp = br.readLine()) != null){
                sb.append(temp);
                // \r�س� \n����
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
