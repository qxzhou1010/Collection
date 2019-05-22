package collection.Sunny;

 import org.owasp.validator.html.AntiSamy;
 import org.owasp.validator.html.CleanResults;
 import org.owasp.validator.html.Policy;

import java.io.*;
 import java.sql.SQLOutput;
 import java.util.ArrayList;
import java.util.List;

public class RichTextXssTest {
    public static void main(String[] args) {

        //检测文件地址
//        String src = "D:\\Users\\xiaopangtou\\OneDrive\\javaDell\\src\\test.txt";
        String src = "D:\\sunny\\t5.txt";
        //读取文件内容
        List<String> list = readTxt(src);

//        System.out.println(list.size());
        AntiSamy as = new AntiSamy();

        int attack = 0; //检测到攻击数量
        int non_attack = 0; //非攻击数量

        try {
            //读取策略文件
            Policy policy = Policy.getInstance("D:\\sunny\\antisamy-anythinggoes.xml");
//            CleanResults cr = null;
            //读取list文件对每一行的结果进行检测，

            for (int i=0; i<1000; i++){
                CleanResults cr = as.scan(list.get(i), policy);
//                CleanResults cr = as.scan(a, policy);

//                System.out.println(i+list.get(i));
                //判断检测结果是否和原输入字符串是否相等，若相等，attack+1
                if (cr.getCleanHTML().equals(list.get(i))){
                    attack++;
                }else {
                    non_attack++;
                }
                //输出检测结果
//                System.out.println(i + ":" + cr.getCleanHTML()  + "\r\n");

            }


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("attack nums:" + attack + "rate:" + attack/list.size());
        System.out.println("non-attack nums:" + non_attack + "rate:" + non_attack/list.size());





//        CleanResults cr = as.scan("<div>wwwww<script>alert（1）</script></div>", policy);





            /*
            cr = as.scan("<sCript src=http://www.qq.com/a.js />", policy);
            System.out.print(cr.getCleanHTML() + "2\r\n");

            i de
           cr = as.scan("onfinish=javascript:a=alert;a(1)%3E%3C!—", policy);
            System.out.print(cr.getCleanHTML() + "4\r\n");


            cr = as.scan("<img src=\"javascript:alert('XSS')\">", policy);
            System.out.print(cr.getCleanHTML() + "5\r\n");

            cr = as.scan("<IMG src=JaVaScRiPt:alert('XSS')>", policy);
            System.out.print(cr.getCleanHTML() + "6\r\n");

            cr = as.scan("<IMG src=&#x6A&#x61&#x76&#x61&#x73&#x63&#x72&#x69&#x70&#x74&#x3A&#x61&#x6C&#x65&#x72&#x74&#x28&#x27&#x58&#x53&#x53&#x27&#x29>", policy);
            System.out.print(cr.getCleanHTML() + "7\r\n");

            cr = as.scan("<STYLE TYPE=\"text/javascript\">alert('XSS');</STYLE>", policy);
            System.out.print(cr.getCleanHTML() + "8\r\n");

            cr = as.scan("<A href=http://www.gohttp://www.google.com/ogle.com/>link</A>", policy);
            System.out.print(cr.getCleanHTML() + "9\r\n");

            cr = as.scan("<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;url=javascript:alert('XSS');\">", policy);
            System.out.print(cr.getCleanHTML() + "10\r\n");
            */


            }

    /**
     * 按行读取txt文件,结果保存到list里面
     * @param src
     * @return
     */
    static List readTxt(String src){

        FileReader fr = null;
        BufferedReader br = null;
        String temp = "";
        String[] arrs = null;
        List<String> list = new ArrayList<>();
        // AntiSamy as = new AntiSamy();
        try {
            fr = new FileReader(src);
            br = new BufferedReader(fr);

            while ((temp = br.readLine()) != null){
                arrs = temp.split(",");
//                System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
//                System.out.println(temp);
                list.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fr != null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return list;

    }




    }

