import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class saxparser
{
public static void main (String argv [])
{
	try{
 File inputFile = new File("pet.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);  
 } catch (Throwable err) {
 err.printStackTrace ();
 }
}
}

class UserHandler extends DefaultHandler {

   boolean bFirstName = false;
   boolean bLastName = false;
   boolean bNickName = false;
   boolean bMarks = false;

   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
      
      if (qName.equalsIgnoreCase("customer")) {
         String rollNo = attributes.getValue("no");
         System.out.println("No : " + rollNo);
      } else if (qName.equalsIgnoreCase("name")) {
         bFirstName = true;
      } else if (qName.equalsIgnoreCase("phone")) {
         bLastName = true;
      } else if (qName.equalsIgnoreCase("Email")) {
         bNickName = true;
      }
      else if (qName.equalsIgnoreCase("Branch")) {
         bMarks = true;
      }
   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      
      if (qName.equalsIgnoreCase("customer")) {
         System.out.println("End Element :" + qName);
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

      if (bFirstName) {
         System.out.println("Name: " + new String(ch, start, length));
         bFirstName = false;
      } else if (bLastName) {
         System.out.println("phone: " + new String(ch, start, length));
         bLastName = false;
      } else if (bNickName) {
         System.out.println("Email: " + new String(ch, start, length));
         bNickName = false;
      } else if (bMarks) {
         System.out.println("Branch: " + new String(ch, start, length));
         bMarks = false;
      }
   }
}

