import org.w3c.dom.*;
import javax.xml.parsers.*;
public class DTDValidator{
	public static void main(String[] args) throws Exception
	{
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			Document doc = factory.newDocumentBuilder().parse(args[0]);
			System.out.println("xml file is valid");
		}catch(Exception e){ System.out.println("Not Valid"+e);}
	}
}