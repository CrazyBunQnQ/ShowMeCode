package com.crazybunqnq.util;

import lombok.extern.log4j.Log4j;

import java.io.*;

/**
 * @version 2017/10/18.
 * @auther CrazyBunQnQ
 */
@Log4j
public class FileUtil {

    private FileUtil() {
    }

    /**
     * 将文件转换成字符串数据放入文本
     *
     * @param path    文件路径
     * @param txtPath txt 文本路径
     *
     * @throws IOException
     */
    public static void file2Text(String path, String txtPath) throws IOException {
        long start = System.currentTimeMillis();
        File inFile = new File(path);
        File writeTxt = new File(txtPath);
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
        byte[] bys = new byte[2048];
        while ((len = fis.read(bys, 0, bys.length)) != -1) {
            String str = bytes2HexString(len, bys);
            textWriter.write(str);
//            System.out.println(sb.toString());
//            System.out.println("bytes length: " + len);
        }
        fis.close();
        textWriter.close();
        System.out.println("cost time: " + ((System.currentTimeMillis() - start) / 1000) + "s");
    }

    /**
     * 将文件转换成字符串数据放入文本
     *
     * @param path
     * @param txtPath
     * @param size    限制单个 txt 文件行数
     *
     * @throws IOException
     */
    public static void file2Text(String path, String txtPath, int size) throws IOException {
        int m = 0;//记录当前 size
        int n = 1;//记录文件名
        boolean end = false;
        String nameTmp;
        String curTxtPath = "";
        File inFile = new File(path);
        if (!inFile.exists()) {
            System.out.println("文件不存在");
            return;
        }
        if (!inFile.isFile()) {
            System.out.println("不是一个文件");
            return;
        }
        FileInputStream fis = new FileInputStream(inFile);
        String directory = txtPath.substring(0, txtPath.lastIndexOf(File.separator));
        String name = txtPath.substring(txtPath.lastIndexOf(File.separator) + 1, txtPath.lastIndexOf("."));
        System.out.println("目录：" + directory + ", 名称：" + name);
        int len;//字节数组长度
        File writeTxt = null;
        BufferedWriter textWriter = null;

        while (!end) {
            nameTmp = curTxtPath;
            curTxtPath = directory + File.separator + name + n + ".txt";
            if (nameTmp != curTxtPath) {
                writeTxt = new File(curTxtPath);
                if (writeTxt.exists()) {
                    writeTxt.delete();
                }
                writeTxt.createNewFile();
                System.out.println("创建新文件：" + curTxtPath);
                textWriter = new BufferedWriter(new FileWriter(writeTxt));
            }

            byte[] bys = new byte[2048];
            while ((len = fis.read(bys, 0, bys.length)) != -1) {
                String str = bytes2HexString(len, bys);
                textWriter.write(str);
                m++;
                if (m > size) {
                    m = 0;
                    break;
                }
            }
            end = len == -1;
            textWriter.close();
            n++;
        }
        fis.close();
    }


    /**
     * 将字符串文本中的数据转换成文件
     *
     * @param path
     *
     * @throws IOException
     */
    public static void text2File(String path, String txtPath) throws IOException {
        File outFile = new File(path);
        File writeTxt = new File(txtPath);
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
            System.out.println("read line length: " + line.length());
            byte[] bys = hexString2Bytes(line);
            fos.write(bys, 0, bys.length);
            fos.flush();
            line = textReader.readLine();
        }
        fos.close();
        textReader.close();
    }

    /**
     * 将字节数组中前 len 个字节转换成 16 进制字符串
     *
     * @param len
     * @param bytes
     *
     * @return
     */
    public static String bytes2HexString(int len, byte[] bytes) {
        final String HEX = "0123456789abcdef";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt((bytes[i] >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt(bytes[i] & 0x0f));
        }

        return sb.toString();
    }

    /**
     * 将字节数组中前 len 个字节转换成字符串
     *
     * @param len
     * @param bys
     *
     * @return
     */
    @Deprecated
    private static String bytes2String(int len, byte[] bys) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (i != 0)
                sb.append(",");
            int b = bys[i];
            sb.append(String.valueOf(b));
        }
        return sb.toString();
    }

    /**
     * 将 16 进制字符串转化为字节数组
     *
     * @param s
     *
     * @return
     */
    public static byte[] hexString2Bytes(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return b;
    }

    /**
     * 合并 txt
     *
     * @param path
     */
    public static void mergeTxt(String path) throws IOException {
        File newFile = new File(path);
        if (newFile.exists()) {
            newFile.delete();
        }
        newFile.createNewFile();
        FileWriter fw = new FileWriter(newFile, true);
        PrintWriter pw = new PrintWriter(fw);
        String dic = path.substring(0, path.lastIndexOf(File.separator) + 1);
        String name = path.substring(path.lastIndexOf(File.separator) + 1, path.lastIndexOf("."));
        System.out.println("dic: " + dic + "  name:" + name);
        int n = 1;
        String newPath = dic + name + n + ".txt";
        File file = new File(newPath);
        while (file.exists()) {
            BufferedReader textReader = new BufferedReader(new FileReader(file));
            String str = textReader.readLine();
            while (str != null) {
                pw.println(str);
                str = textReader.readLine();
            }
            textReader.close();
            n++;
            newPath = dic + name + n + ".txt";
            file = new File(newPath);
        }
        pw.flush();
        fw.flush();
        pw.close();
        fw.close();
    }
}
