import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ReadXMLFile_Two {

  public static void main(String argv[]) {

    try {
    	
    	String file_path=System.getProperty("user.dir");
	File fXmlFile = new File(file_path+"\\raw\\THINNERCLEANSE.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("options");
	int l=nList.getLength();
	System.out.println(l);
	
	System.out.println("----------------------------");
//	System.out.println(nList.item(0).getAttributes().getNamedItem("title"));
//	System.out.println(nList.item(0).getAttributes().getNamedItem("id"));
	NodeList nL=doc.getElementsByTagName("fields");
	System.out.println("fields length: "+nL.getLength());
	System.out.println("----------------------------");
	NodeList nList1=doc.getElementsByTagName("field");
	System.out.println(nList1.getLength());
	
	ArrayList<String> foods=new ArrayList<String>();
	String f_item="";
	int count=0;
	for (int i = 0; i < nList1.getLength(); i++) {
		//System.out.println(nList1.item(i).getAttributes().getNamedItem("id")+"\n");
		f_item=nList1.item(i).getAttributes().getNamedItem("title").getNodeValue();
		foods.add(f_item);
		//System.out.println(i+":"+f_item+"\n");
		f_item="";
		count++;
	}
	System.out.println(count+" items added for THINNERCLEANSE");
//	String find="Parsley - 1.5 oz allowed";
	
//	while(count!=0){
//		String fd=foods.get(count-1);
//
//		count--;
//		if(fd.contains(find)){
//			System.out.println("match found at "+count);
//			System.out.println("Food name:"+foods.get(count));
//			continue;
//		}else
//		{
//			
//		}
//		
//	}
	System.out.println("========x===============x===========");
	
//	Started reading Android Xml file
		
	File android_file = new File(file_path+"\\raw\\ThinnerCleanse_Android.xml");
	DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
	Document doc1 = dBuilder1.parse(android_file);

doc1.getDocumentElement().normalize();
System.out.println("----------------------------");
System.out.println("Root element Android :" + doc1.getDocumentElement().getNodeName());

NodeList nList_android=doc1.getElementsByTagName("item");

System.out.println(nList_android.getLength());

System.out.println("----------------------------");
ArrayList<String> foods_android=new ArrayList<String>();
String f_item_android="";
int count_android=0;
for (int i = 0; i < nList_android.getLength(); i++) {

	f_item_android=nList_android.item(i).getTextContent();
	//System.out.println(i+":"+f_item_android+"\n");
	foods_android.add(f_item_android);
	f_item_android="";
	count_android++;
}

int not_matched=0;
for (int i = 0; i < foods.size(); i++) {

	for (int j = 0; j < foods_android.size(); j++) {
		if(!(foods.get(i).contentEquals(foods_android.get(j)))&& j==foods_android.size()-1){ //!(foods.get(i).matches(foods_android.get(j)))
			System.out.println(i+":"+foods.get(i)+"\n");
			not_matched++;
		}
		if(foods.get(i).contains(foods_android.get(j))){
			break;
		}
		
		
	}
}
System.out.println("Not matched items are :"+not_matched);

/*String find="Parsley - 1.5 oz allowed";
System.out.println(count_android);
while(count_android!=0){
	String fd=foods_android.get(count_android-1);

	count_android--;
	if(fd.contains(find)){
		System.out.println("match found at "+count_android);
		System.out.println("Food name:"+foods_android.get(count_android));
		continue;
	}else
	{
		
		//System.out.println("Not found");
	}
	
}*/
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
  

}