package io;
import java.io.File;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;


public class TestUtils01 {
    /**
     * ��ȡ�ļ����ݣ����������̨
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String content = FileUtils.readFileToString(new File("D:\\c.txt"), "gbk");
        System.out.println(content);

    }

}
