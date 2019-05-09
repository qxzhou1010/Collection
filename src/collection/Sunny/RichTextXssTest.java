package collection.Sunny;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;

public class RichTextXssTest {
    public static void main(String[] args) {

        AntiSamy as = new AntiSamy();
        try{
            //Policy policy = Policy.getInstance("antisamy-slashdot.xml");
            Policy policy = Policy.getInstance("D:\\antisamy-sample-configs-1.4.4\\antisamy-slashdot.xml");

            CleanResults cr = as.scan("<img src=http://www.qq.com/a.jpg />", policy);
            System.out.print(cr.getCleanHTML() + "1\r\n");


            cr = as.scan("<sCript src=http://www.qq.com/a.js />", policy);
            System.out.print(cr.getCleanHTML() + "2\r\n");

            cr = as.scan("<img src=http://www.qq.com/a.jpg onclick=alert(1) />", policy);
            System.out.print(cr.getCleanHTML() + "3\r\n");

            cr = as.scan("onfinish=javascript:a=alert;a(1)%3E%3C!¡ª", policy);
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




        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }




}
