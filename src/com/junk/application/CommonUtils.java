/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junk.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 * @author Elmer
 */
public class CommonUtils {
    public static String IV = "dencrypttpyrcned";
    public static String KEY = "dencrypttpyrcned";
    public static File dbFile = new File("db.dat");
    public static void createDBFile() throws IOException {
        if (!dbFile.exists()) {
            new PrintWriter(new BufferedWriter(new FileWriter(dbFile)));
        }
    }
    public static void saveData(HashMap<String,DencFile> data ,DencFile... newEncryptedFiles) throws Exception{
        for (DencFile dencFile : newEncryptedFiles) {
            data.put(dencFile.getTempFileName(), dencFile);
        }
        String text = mapToString(data);
        String encryptedText = AESEncryption.encrypt(text, IV, KEY);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(dbFile)));
        writer.print(encryptedText);
        writer.close();
    }
    public static String mapToString(HashMap<String,DencFile> map) {
        String map2String = "";
        int counter = 0;
        for (DencFile dencfile : map.values()) {
            if ( (map.size() - 1) == counter) {
                map2String += dencfile.toString();
            } else {
                map2String += dencfile.toString() + "\n";
            }
            counter++;
        }
        return map2String;
    }
    
    public static HashMap<String,DencFile> readData() throws Exception{
        HashMap<String,DencFile> data = new HashMap<>();
        String decryptedData = AESEncryption.decrypt(new String(Files.readAllBytes(Paths.get(dbFile.getCanonicalPath()))), IV, KEY);
        if (!decryptedData.equals("")) {
            String [] row = decryptedData.split("\n");
            for (String string : row) {
                System.out.println(string);
                String [] dataArr = string.split(":");
                String originalFileName = dataArr[0];
                String fileSize = dataArr[1];
                String password = dataArr[2];
                String encryptedFileName = dataArr[3];
                DencFile df = new DencFile(originalFileName, fileSize, password, encryptedFileName);
                data.put(encryptedFileName, df);
            }
        }
        return data;
    }
    public static double getFileSize(long fileSize) {
        double kb = (fileSize / 1024);
        double mb = (kb / 1024);
        return mb;
    }
}
