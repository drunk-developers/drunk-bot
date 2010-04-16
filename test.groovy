import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class URLReader {
  public static void main(String[] args) throws Exception {
    URL yahoo = new URL("http://www.webinsult.com/");
    BufferedReader bf = new BufferedReader(new InputStreamReader(yahoo.openStream()));
	
    StringBuilder URL = new StringBuilder();
    String inputLine;

    while ((inputLine = bf.readLine()) != null) {
      if (inputLine.contains("class=\"insult\" id=\"insult\"")){
        System.out.println( inputLine.substring(inputLine.lastIndexOf("\">") + 2,
                                              inputLine.lastIndexOf("</div>")) );
        break;
      }
    }
    bf.close();
  }
}
