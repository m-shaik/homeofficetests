package com.java.dataservice;

import com.java.dataservice.DataReader;

import java.util.HashMap;
import java.util.List;

public class ReadData {

    public static List<HashMap<String,String>> dataMapList;

    public static List<HashMap<String,String>> getDataFromExcel(String filepath, String sheetName)
    {
        dataMapList = DataReader.data(filepath,sheetName);
        return dataMapList;
    }
}
