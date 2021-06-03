package edu.escuelaing.arsw.loccount.app;
import java.io.*;

/**
 * This program count line in source code files.
 *
 * Usage:
 * To count physical lines:
 *      $java countLinesApp phy [source file]
 * To count lines of code (LOC)
 *      $java countLinesApp loc [source file]
 *
 */
public class CountLinesApp
{
    /**
     * recursiveDirectoryContents.
     *
     * take the directory and type of count, then seacrh recursively the file for count.
     *
     */
    public static void recursiveDirectoryContents(File dir, String type) throws Exception {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    recursiveDirectoryContents(file, type);
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                    resoleveTypeOfCount(file, type);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * resoleveTypeOfCount.
     *
     * take the directory and type of count, then depending on the type of counting, choose the method to count the lines of code.
     *
     */
    public static void resoleveTypeOfCount(File dir, String type) throws Exception {

        FileInputStream fis = new FileInputStream(dir);
        byte[] byteArray = new byte[(int)dir.length()];
        fis.read(byteArray);
        String data = new String(byteArray);
        String[] stringArray = data.split("\n");

        if (type == "phy") {
            System.out.println("Number of lines in the file are ::"+stringArray.length);
        } else if (type == "loc") {

            BufferedReader f = new BufferedReader(new FileReader(dir));
            LineNumberReader l = new LineNumberReader(f);
            String str;
            int numberline = 0;
            int count = 0;
            while ((str = l.readLine()) != null) {
                numberline++;
                if (str.startsWith("/*")) {
                    while ((str = l.readLine()) != null) {
                        count++;
                        if (str.endsWith("*/")) {
                            count++;
                            break;
                        }
                    }
                }
                else if(str.startsWith("//")){
                    count++;
                }
            }
            System.out.println("Number of lines in the file are ::"+(stringArray.length - count ));
        }
    }

    public static void main(String args[]){

        String typeOfCount = args[0];
        String fileName = args[1];
        File file = new File(fileName);

        try {
            recursiveDirectoryContents(file, typeOfCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}