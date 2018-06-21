package common;

import com.java.dataservice.FileHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FileHelperTest {

    @Test
    public void testListOfFilesReturnedInTheList() {

        FileHelper fileHelper = new FileHelper();

        String directoryName = "C:\\Users\\Muneer\\Downloads";
        List<File> resultList = fileHelper.getFiles(directoryName);

        // verify that list contains files
        assertNotNull("No files found in the directory", resultList);

        fileHelper.getFileInfo(resultList);
    }
}
