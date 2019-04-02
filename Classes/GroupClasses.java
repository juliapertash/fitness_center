
import Person.Client;

import java.util.List;

public class GroupClasses extends FitnessCenter{
    private String Name;
    private int Duration;
    private String About;
    private String Type;
    private int ID;
    private int Price;
    private List<Client> ClientsOfAGroup;


    public GroupClasses(String name, int duration, String about, String type, int id, int price, List<Client> clientsOfAGroup) {
        Name = name;
        Duration = duration;
        About = about;
        Type = type;
        ID = id;
        Price = price;
        ClientsOfAGroup = clientsOfAGroup;
    }
}
