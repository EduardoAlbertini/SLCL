package br.com.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PDFManager {
    private static PDFManager pdfManager;

    private PDFManager() {
    }

    public static PDFManager getPDFManager() {
        if (pdfManager == null) {
            pdfManager = new PDFManager();
        }
        return pdfManager;
    }
    
    public  boolean gravarPDF(File arquivo,String diretorio,String titulo) {
        OutputStream out;
        try {
            out = new FileOutputStream(diretorio+"/"+titulo+".pdf");
            out.write(fileToByte(arquivo));
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private  byte[] fileToByte(File arquivo) throws Exception {  
        FileInputStream fis = new FileInputStream(arquivo);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        byte[] buffer = new byte[8192];  
        int bytesRead = 0;  
        while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {  
            baos.write(buffer, 0, bytesRead);  
        }  
        return baos.toByteArray();  
    } 
}