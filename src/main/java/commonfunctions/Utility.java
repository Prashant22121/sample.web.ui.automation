package commonfunctions;


/**
 * This is Utility class for reading data from properties file
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {


    public static String readPropertyFile(String fileName, String key) throws IOException,Exception {

        FileInputStream fileInput = null;
        Properties prop = null;
        try {
            fileInput = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fileInput);
        } catch (FileNotFoundException fnex) {
            fnex.printStackTrace();
        } finally {
           if(fileInput!=null)
               fileInput.close();
        }
        if(prop==null)
        {
            throw new Exception("Properties file is empty");
        }
        return prop.getProperty(key);
    }
}
