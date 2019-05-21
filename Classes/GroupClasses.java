
import Person.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupClasses {
    public String Name;
    private int Duration;
    private String About;
    private String Type;
    private int ID;
    private int Price;
    public ArrayList<Client> Clients;


    public GroupClasses(String name, int duration, String about, String type, int id, int price, ArrayList<Client> clients) {
        Name = name;
        Duration = duration;
        About = about;
        Type = type;
        ID = id;
        Price = price;
       Clients = new ArrayList<Client>();
    }
    void ToString()
    {
        System.out.printf("Name: %s \t\n", Name);


    }
    void ToString1(ArrayList<String> names)
    {
        System.out.printf("Name: %s \t\n", Name);
        names.add(Name);



    }
}
