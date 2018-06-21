package com.java.dataservice;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper implements FileOperations {

    public List<File> getFiles(String d){

        File directory = new File(d);
        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            // find and add all the files within subdirectory
            if (file.isDirectory()) {
                resultList.addAll(getFiles(file.getAbsolutePath()));
            }
        }
        // return all the files as List
        return resultList;
    }

    public void getFileInfo(List<File> files){
        String [] SupportedFileTypes = {"xls", "csv"};
        List<File> unSupportedList = new ArrayList<File>();

        for (File file : files) {
            // Check if file type is supported or not, print info if supported file type found
            if(FilenameUtils.isExtension(file.getName(), SupportedFileTypes)){
                System.out.println("Supported File Type Found " + file.getName());
                printFileInformation(file);
            }
            else
            {
                // Add to the list,so we can have a list of unsupported files found in the directory
                unSupportedList.add(file);
            }

        };
        // Print unsupported files information
        if(!unSupportedList.isEmpty()){
            System.out.println("***************************** ");
            System.out.println("   UnSupported Files Information ");
            for (File file : unSupportedList){
                printFileInformation(file);
            }

        }

    }

    public  void printFileInformation(File file){

        System.out.println("File Name: " + file.getName());
        System.out.println("File Size: " + file.length());

        String fileExtention= FilenameUtils.getExtension(file.getAbsolutePath());
        System.out.println("File Extension: " + fileExtention);
        String mimeType = getFileMimeType(file.getAbsolutePath());
        System.out.println("File MIME Type : " + mimeType);
        System.out.println("*******************************");

    }

    public  String getFileMimeType(String filePath){
        Path source = Paths.get(filePath);
        String mType = "";
        try {
            mType =  Files.probeContentType(source);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mType;
    }
}

