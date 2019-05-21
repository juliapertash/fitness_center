import Person.Client;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("logss.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.info("STRT APP");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<GroupClasses> GroupClassesList = new ArrayList<GroupClasses>();
    public static ArrayList<Instructor> Instructorss= new ArrayList<Instructor>();
    public static Map<String, ArrayList<Client>> clientsofgr = new HashMap<String, ArrayList<Client>> ();

    private GroupClasses gr;
    private GroupClasses gr1;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, NoSuchFieldException, IllegalAccessException, TransformerException {

        formBase();
        MENU();
 /*       System.out.println("ПРОВЕРКА.....................");
        for (GroupClasses gr:GroupClassesList
             ) {
            gr.ToString();
        }
*/


    }

    public static void MENU() throws ParserConfigurationException, IOException, SAXException, NoSuchFieldException, IllegalAccessException, TransformerException {
        Scanner in = new Scanner(System.in);
        System.out.println("***menu***");
        System.out.println("1. Список групп");
        System.out.println("2. Группы и клиенты");
        System.out.println("3. Инструкторы");
        System.out.println("4. Новый клиент");
        //System.out.println("5. Редактировать клиента");
        System.out.println("0. Выход");
        String choise = in.next();
        switch (choise) {
            case "1":
                WriteGroups();
                break;
            case "2":
                wrtGroupsClients();
            case "3":
                writeInstr();
            case "4":
                addClient();
            case "0":
                System.exit(0);

            default:
                MENU();
        }
    }
    /*
    public static void changeClient()
    {
        System.out.println("Клиенты: "+clientsofgr.size());
        for (Map.Entry<String, Client> cl:clientsofgr.entrySet())
        {
            System.out.printf("Key: %s\n", cl.getKey());
            cl.getValue().ToString();
        }
        System.out.println("Выберите клиента по ключу");
        Scanner in = new Scanner(System.in);
        String key=in.next();
        if(clientsofgr.keySet().contains(key))
        {
            System.out.println("1 - отредактировать номер, 2 - адрес");
        }
            String choise = in.next();
            switch (choise) {
                case "1":
                    System.out.println("Введите новый адрес");
                    String addr = in.next();
                    clientsofgr.get(key).Seta(addr);
                    break;
                case "2":
                  //  wrtGroupsClients();
        }
    }
    */
    public static void addClient() throws IllegalAccessException, ParserConfigurationException, NoSuchFieldException, SAXException, IOException, TransformerException {
        Scanner in = new Scanner(System.in);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        File file1 = new File("clients.xml");
        ArrayList<String> names = new ArrayList<String>();
        for (GroupClasses gr : GroupClassesList
        ) {
            gr.ToString1(names);


        }
        System.out.println("Добавление нового клиента");

        System.out.println("Введите название группы");
        String gr=in.next();
        Document doc=db.parse(file1);
Element root=doc.getDocumentElement();
        System.out.println("\n"+root.getTagName());




        if(names.contains(gr)) {
            Element newclient = doc.createElement(gr);
            root.appendChild(newclient);

            Element surn = doc.createElement("Surname");
            System.out.println("Введите фамилию");
            String s="";
            while(s.isEmpty())
            {
                s= in.next();
            }
            surn.appendChild(doc.createTextNode(s));
            newclient.appendChild(surn);

            Element Name = doc.createElement("Name");
            System.out.println("Введите имя");
            String n="";
            while(n.isEmpty())
            {
                n= in.next();
            }
            Name.appendChild(doc.createTextNode(n));
            newclient.appendChild(Name);

            Element LastName = doc.createElement("Lastname");
            System.out.println("Введите отчество");
            String l = "";
            while(l.isEmpty())
            {
                l= in.next();
            }
            LastName.appendChild(doc.createTextNode(l));
            newclient.appendChild(LastName);

            Element Birthdate = doc.createElement("Birthdate");
            System.out.println("Введите дату рождения");
            String B = "";
            while(B.isEmpty())
            {
                B= in.next();
            }
            Birthdate.appendChild(doc.createTextNode(B));
            newclient.appendChild(Birthdate);

            Element ContactNumber= doc.createElement("ContactNumber");
            System.out.println("Введите ContactNumber");
            String cn = "";
            while(cn.isEmpty())
            {
                cn= in.next();
            }
            ContactNumber.appendChild(doc.createTextNode(cn));
            newclient.appendChild(ContactNumber);

            Element _Adress= doc.createElement("_Adress");
            System.out.println("Введите _Adress");
            String ad = "";
            while(ad.isEmpty())
            {
                ad= in.next();
            }
            _Adress.appendChild(doc.createTextNode(ad));
            newclient.appendChild(_Adress);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult("clients.xml");
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            System.out.println("DONE");

        }

else
        {
            log.warning("ввод несуществующей группы");
            addClient();
        }
        GroupClassesList.clear();
Instructorss.clear();


formBase();
        MENU();
    }
public static void writeInstr() throws IllegalAccessException, ParserConfigurationException, NoSuchFieldException, SAXException, IOException, TransformerException {
    System.out.println("Инструкторы: "+Instructorss.size());
     for(Instructor i: Instructorss)
     {
         i.ToString();
     }
    MENU();
}
    public static void wrtGroupsClients() throws ParserConfigurationException, IOException, SAXException, NoSuchFieldException, IllegalAccessException, TransformerException {
        System.out.println("Группы: "+GroupClassesList.size());
        for (GroupClasses gr : GroupClassesList
        ) {
            gr.ToString();
          //  System.out.println("Клиенты: "+gr.ClientsOfAGroup.size());
          for(Client cl: clientsofgr.get(gr.Name))
          {
              cl.ToString();
          }

        }


        MENU();
    }
        public static void WriteGroups () throws ParserConfigurationException, IOException, SAXException, NoSuchFieldException, IllegalAccessException, TransformerException {
            File file_ = new File("data.xml");

            DocumentBuilderFactory dbf_ = DocumentBuilderFactory.newInstance();
            DocumentBuilder db_ = dbf_.newDocumentBuilder();
            Document document_ = db_.parse(file_);

            NodeList nodeList_ = document_.getElementsByTagName("Group");
            System.out.println(nodeList_.getLength());
            if (nodeList_.getLength() != 0) {
                log.info("Cформирован лист групп");
            }
            for (int i = 0; i < nodeList_.getLength(); i++) {
                Node node = nodeList_.item(i);
                System.out.println(node.getNodeName() + " " + i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {


                    NodeList prop = node.getChildNodes();
                    for (int j = 1; j < prop.getLength(); j+=2) {
                        Node nam = prop.item(j);

                        System.out.println(nam.getNodeName() + ": " + nam.getTextContent());

                    }

                    System.out.println("***");
                }


            }
            MENU();
        }


        public static void formBase () throws ParserConfigurationException, IOException, SAXException {

            File file = new File("data.xml");
            File file1 = new File("clients.xml");
            File file2 = new File("instr.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            Document document1 = db.parse(file1);
            Document document2 = db.parse(file2);
            NodeList nodeList = document.getElementsByTagName("Group");
            System.out.println(nodeList.getLength());
            if (nodeList.getLength() != 0) {
                log.info("Cформирован лист групп");
            }
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                log.info("Заполняю группу...");
                if (node.getNodeType() == Node.ELEMENT_NODE) {


                    NodeList prop = node.getChildNodes();
                    ArrayList<String> data = new ArrayList<String>();

                    for (int j = 0; j < prop.getLength(); j++) {
                        Node nam = prop.item(j);

                        data.add(nam.getTextContent());

                    }
                    for (var a : data
                    ) {
                        System.out.print(a);
                    }
                    //System.out.print(data.indexOf("120"));
                    String Name = data.get(1);
                    int Duration = Integer.parseInt(data.get(3));
                    String About = data.get(5);
                    String Type = data.get(7);
                    int Id = Integer.parseInt(data.get(9));
                    int Price = Integer.parseInt(data.get(11));



                    NodeList clients = document1.getElementsByTagName(Name);

                    ArrayList<Client> cll=new ArrayList<Client>();
                    if (clients.getLength() != 0) {
                       // Node gr = gru.item(0);
                       // NodeList clients = gr.getChildNodes();
                        for (int y = 0; y < clients.getLength(); y++) {
                            Node clie = clients.item(y);
                            log.info("Заполняю клиента...");
                            if (clie.getNodeType() == Node.ELEMENT_NODE) {

                                NodeList pr = clie.getChildNodes();
                                ArrayList<String> data1 = new ArrayList<String>();
                                for (int j = 0; j < pr.getLength(); j++) {
                                    Node nam = pr.item(j);

                                    data1.add(nam.getTextContent());

                                }
                                for (var a : data1
                                ) {
                                    System.out.println(data1.indexOf(a) + " " + a);
                                }
                                //System.out.println(data1.indexOf("петраш"));
                                String Surname_ = data1.get(1);
                                String Name_ = data1.get(3);
                                String Lastname_ = data1.get(5);
                                String Birthdate_ = data1.get(7);
                                String num_ = data1.get(9);
                                String addr_ = data1.get(11);
                                Client newc = new Client(Surname_, Name_, Lastname_, Birthdate_, num_, addr_);
                                cll.add(newc);
log.info("добавлен клиент");
                            }
                        }
                        clientsofgr.put(Name, cll);
                    }
                    NodeList instructors = document2.getElementsByTagName(Name);
                    if (instructors.getLength() != 0) {
                    for(int f=0; f<instructors.getLength(); f++)
                    {
                        Node instruct=instructors.item(f);
                        NodeList i_props=instruct.getChildNodes();
                        ArrayList<String> props= new ArrayList<String>();
                        for(int n=0; n<i_props.getLength(); n++)
                        {
                            Node p=i_props.item(n);
                            props.add(p.getTextContent());
                        }
                        int a= Integer.parseInt(props.get(1));
                        String b= props.get(3);
                        String c= props.get(5);
                        String d= props.get(7);
                        Instructor inst= new Instructor(Name, Duration, About, Type, Id, Price, cll,a,b,c,d);
                       Instructorss.add(inst);
                    }

                    }


                    GroupClasses g = new GroupClasses(Name, Duration, About, Type, Id, Price, cll);


                    GroupClassesList.add(g);

                  //  System.out.printf("fffffffffffffffff %s", clientsofgr.size());
                }
            }
        }
    }



