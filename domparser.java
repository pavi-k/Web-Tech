import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class domparser
{
public static void main(String args[])
{


int ch,i,j;
String m="",n,o,p;
Scanner scan=new Scanner(System.in);
do{
	System.out.println("============================");
System.out.println("\n1.Insert 2.Delete 3.View 4.Modify\nEnter the choice:");
ch=scan.nextInt();
switch(ch){
case 3:
try
{
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
 
//Build Document
Document document = builder.parse(new File("p1.xml"));
 
//Normalize the XML Structure; It's just too important !!
document.getDocumentElement().normalize();
 
//Here comes the root node
Element root = document.getDocumentElement();
System.out.println(root.getNodeName());
 
//Get all employees
NodeList nList = document.getElementsByTagName("customer");
System.out.println("============================");
 
for (int temp = 0; temp < nList.getLength(); temp++)
{
 Node node = nList.item(temp);
 System.out.println("");    //Just a separator
 if (node.getNodeType() == Node.ELEMENT_NODE && node!=null)
 {
    //Print each employee's detail
    Element eElement = (Element) node;
    if(eElement.getAttribute("no")!=null)
    System.out.println("Employee id : "    + eElement.getAttribute("no"));
	if(eElement.getElementsByTagName("name").item(0)!=null){
    System.out.println("Name : "  + eElement.getElementsByTagName("name").item(0).getTextContent());
}
	if(eElement.getElementsByTagName("phone").item(0)!=null)
    System.out.println("phone: "   + eElement.getElementsByTagName("phone").item(0).getTextContent());
	if(eElement.getElementsByTagName("Email").item(0)!=null)
    System.out.println("Email: "   + eElement.getElementsByTagName("Email").item(0).getTextContent());
	if(eElement.getElementsByTagName("Branch").item(0)!=null)
    System.out.println("Location : "    + eElement.getElementsByTagName("Branch").item(0).getTextContent());
 }
}
}
catch (Exception e)
{ e.printStackTrace(System.out);
}
break;
case 1:
try
{ 
	int k;
	String ne="" ,me="";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
 
//Build Document
Document doc = builder.parse(new File("p1.xml"));
 
//Normalize the XML Structure; It's just too important !!
doc.getDocumentElement().normalize();
Node company = doc.getFirstChild();
		System.out.println("\nEnter the customer id:");
		k=scan.nextInt();
		Node staff = doc.getElementsByTagName("customer").item(k-1);

		// append a new node to staff
		System.out.println("Enter a node name:");
		m=scan.next();

System.out.println("Enter value:");
		n=scan.next();
		Element age = doc.createElement(m);
		age.appendChild(doc.createTextNode(n));
		staff.appendChild(age);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("p1.xml"));
		transformer.transform(source, result);
		System.out.println("Done");
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
	break;
case 2:
try
{
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
 
//Build Document
Document doc = builder.parse(new File("p1.xml"));
 
//Normalize the XML Structure; It's just too important !!
doc.getDocumentElement().normalize();
Node company = doc.getFirstChild();
		System.out.println("\nEnter the customer id to delete:");
		int k=scan.nextInt();
		Node staff = doc.getElementsByTagName("customer").item(k-1);

		// append a new node to staff
		System.out.println("Enter a node name to delete:");
		m=scan.next();
		NodeList list4 = staff.getChildNodes();
		for (int v = 0; v < list4.getLength(); v++) {
			
                   Node node4 = list4.item(v);
		   if (m.equals(node4.getNodeName())) {
			staff.removeChild(node4);
		   }

		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("p1.xml"));
		transformer.transform(source, result);
		

		System.out.println("Done");
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
break;
case 4:
try{
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
 
//Build Document
Document doc = builder.parse(new File("p1.xml"));
 
//Normalize the XML Structure; It's just too important !!
doc.getDocumentElement().normalize();
Node company = doc.getFirstChild();
System.out.println("\nEnter the customer id to modify:");
		int k=scan.nextInt();
System.out.println("Enter a node name to modify:");
		m=scan.next();
		System.out.println("Enter a value:");
		n=scan.next();
		
		Node staff = doc.getElementsByTagName("customer").item(k-1);
NodeList list1 = staff.getChildNodes();

		for ( i = 0; i < list1.getLength(); i++) {
			
                   Node node3 = list1.item(i);

		   // get the salary element, and update the value
		   if (m.equals(node3.getNodeName())) {
			node3.setTextContent(n);
		   }
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("p1.xml"));
		transformer.transform(source, result);
		} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
		break;

}
}while(ch<5);
}
}

