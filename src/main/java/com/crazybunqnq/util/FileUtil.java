package com.crazybunqnq.util;

import lombok.extern.log4j.Log4j;

import java.io.*;

/**
 * @version 2017/10/18.
 * @auther CrazyBunQnQ
 */
@Log4j
public class FileUtil {
    private static final String tmp = "/Users/baojunjie/Desktop/test/tmp.txt";

    private FileUtil() {
    }

    /**
     * 将文件转换成字符串数据放入文本
     *
     * @param path
     * @param name
     *
     * @throws IOException
     */
    public static void file2Text(String path, String name) throws IOException {
        File inFile = new File(path + File.separator + name);
        File writeTxt = new File(tmp);
        if (!inFile.exists()) {
            System.out.println("文件不存在");
            return;
        }
        if (!inFile.isFile()) {
            System.out.println("不是一个文件");
            return;
        }
        if (writeTxt.exists()) {
            writeTxt.delete();
        }
        writeTxt.createNewFile();
        BufferedWriter textWriter = new BufferedWriter(new FileWriter(writeTxt));

        FileInputStream fis = new FileInputStream(inFile);
        int len;
        byte[] bys = new byte[1024];
        while ((len = fis.read(bys, 0, bys.length)) != -1) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < len; i++) {
                if (i != 0)
                    sb.append(",");
                int b = bys[i];
                sb.append(String.valueOf(b));
            }
            textWriter.write(sb.toString() + "\r\n");
            System.out.println(sb.toString());
        }
        fis.close();
        textWriter.close();
    }

    /**
     * 将字符串文本重的数据转换成文件
     *
     * @param path
     * @param name
     *
     * @throws IOException
     */
    public static void text2File(String path, String name) throws IOException {
        File outFile = new File(path + File.separator + name);
        File writeTxt = new File(tmp);
        if (outFile.exists()) {
            outFile.delete();
        }
        if (!writeTxt.exists() || !writeTxt.isFile()) {
            System.out.println("文件不存在");
            return;
        }
        BufferedReader textReader = new BufferedReader(new FileReader(writeTxt));

        FileOutputStream fos = new FileOutputStream(outFile);
        String line = textReader.readLine();
        while (line != null) {
            String[] arr = line.split(",");
            int len = arr.length;
            byte[] bys = new byte[1024];
            for (int i = 0; i < len; i++) {
                bys[i] = (byte) Integer.parseInt(arr[i]);
            }
            fos.write(bys, 0, len);
            line = textReader.readLine();
        }
        fos.close();
        textReader.close();
    }
}
