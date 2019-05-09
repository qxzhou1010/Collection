package io;
import java.io.File;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;


public class TestUtils01 {
    /**
     * 读取文件内容，输出到控制台
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String content = FileUtils.readFileToString(new File("D:\\c.txt"), "gbk");
        System.out.println(content);

    }

}
