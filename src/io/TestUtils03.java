package io;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

public class TestUtils03 {

    public static void main(String[] args) throws Exception {
        String content = IOUtils.toString(new FileInputStream("D:\\a.txt"), "utf-8");
        System.out.println(content);
    }
}
