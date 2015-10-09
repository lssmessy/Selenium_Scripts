import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static void main(String argv[]) {

    try {
    	
//    	String file_path=System.getProperty("user.dir");
//	File fXmlFile = new File(file_path+"\\raw\\staff.xml");
//	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	Document doc = dBuilder.parse(fXmlFile);
//			
//	//optional, but recommended
//	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
//	doc.getDocumentElement().normalize();
//
//	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//			
//	NodeList nList = doc.getElementsByTagName("staff");
//			
//	System.out.println("----------------------------");
//
//	for (int temp = 0; temp < nList.getLength(); temp++) {
//
//		Node nNode = nList.item(temp);
//				
//		System.out.println("\nCurrent Element :" + nNode.getNodeName());
//				
//		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//			Element eElement = (Element) nNode;
//
//			System.out.println("Staff id : " + eElement.getAttribute("id"));
//			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//
//		}
//	}
    	String file_path=System.getProperty("user.dir");
    	File android_file = new File(file_path+"\\raw\\ThinnerCleanse_Android.xml");
    	DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
    	Document doc1 = dBuilder1.parse(android_file);
    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    doc1.getDocumentElement().normalize();
    System.out.println("----------------------------");
    System.out.println("Root element Android :" + doc1.getDocumentElement().getNodeName());

    NodeList nList_android=doc1.getElementsByTagName("item");

    System.out.println(nList_android.getLength());
    	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}