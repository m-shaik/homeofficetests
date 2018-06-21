package com.java.dataservice;

import java.io.File;
import java.util.List;

public interface FileOperations {

    public List<File> getFiles(String directory);

    public void getFileInfo(List<File> files);
}
