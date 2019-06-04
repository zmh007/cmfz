package com.baizhi;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class TestFile {
    @Test
    public void Test1()throws Exception{

        File file = new File("D:\\testFile/abc.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        Reader reader = new FileReader(file);
        char[] ch=new char[1024];
        int count;
        while((count=reader.read(ch))!=-1){
            System.out.println(ch);
        }
        reader.close();

    }


}
