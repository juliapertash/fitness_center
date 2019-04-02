import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {


    }

    public void ReadXML() throws ParserConfigurationException, IOException, SAXException {

        ArrayList<GroupClasses> GroupClassesList = new ArrayList<GroupClasses>();
        File file = new File("/XMLData/Groups.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(file);
        GroupClassesList.addAll((Collection<? extends GroupClasses>) document.getElementsByTagName("Group"));
    }
}
