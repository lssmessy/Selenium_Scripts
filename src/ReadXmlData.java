

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import com.sun.jna.StringArray;

	public class ReadXmlData {
	public String value;

	public String data(String node) {
	try {
		String file_path=System.getProperty("user.dir");
	File file = new File(file_path+"\\raw\\bookstore.xml"); // XML file path
	FileInputStream fileInput = new FileInputStream(file);
	Properties properties = new Properties();
	properties.loadFromXML(fileInput);
	fileInput.close();
	Enumeration enuKeys = properties.keys();
	while (enuKeys.hasMoreElements()) {
	if (((String) enuKeys.nextElement()).contains(node)) {
	value = properties.getProperty(node);
	}
	}
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	return value;
	}
	public static void main(String a[]){
		ReadXmlData dt=new ReadXmlData();
		String s=dt.data("bookstore");
		System.out.println(s);
	}
}

