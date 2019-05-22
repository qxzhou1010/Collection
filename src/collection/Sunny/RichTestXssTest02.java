package collection.Sunny;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.CleanResults;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RichTestXssTest02 {


    public static void main(String[] args) {

        AntiSamy as = new AntiSamy();
        int attack = 0; //检测到攻击数量
        int non_attack = 0; //非攻击数量




        FileReader fr = null;
        BufferedReader br = null;
        String temp = "";
        String[] arrs = null;
        List<String> list = new ArrayList<>();
        // AntiSamy as = new AntiSamy();
        try {
            Policy policy = Policy.getInstance("D:\\antisamy-sample-configs-1.4.4\\antisamy.xml");
            fr = new FileReader("D:\\Users\\xiaopangtou\\OneDrive\\javaDell\\src\\test.txt");
            br = new BufferedReader(fr);

            while ((temp = br.readLine()) != null){
                arrs = temp.split(",");
//                System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
//                System.out.println(temp);
                list.add(temp);
                CleanResults cr  = as.scan(temp, policy);
                if (cr.getCleanHTML().equals(temp)){
                    attack++;
                }else {
                    non_attack++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
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


        System.out.println("attack"+ attack);
        System.out.println("non-attack"+non_attack);
    }



}
