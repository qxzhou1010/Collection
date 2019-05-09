package collection.Sunny;


import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
//import org.apache.batik.cs
import org.apache.batik.css.parser.ParseException;

public class AntiSamyApplication {
    public static void main(String[] args)
    {
        AntiSamy as = new AntiSamy();
        try{
//            Policy policy = Policy.getInstance("\\antisamy\\antisamy-tinymce-1.4.4.xml");
            Policy policy = Policy.getInstance("D:\\antisamy.xml");
            CleanResults cr = as.scan("<div>wwwww<script>alert£¨1£©</script></div>", policy);
            System.out.print(cr.getCleanHTML());
        }
        catch(Exception ex) {
//            ex.printStackTrace();
        }
    }

}
