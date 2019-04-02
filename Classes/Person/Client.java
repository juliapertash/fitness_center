package Person;

import java.util.Date;

public class Client {
    private int Code;
    private String Surname;
    private String Name;
    private String Lastname;
    private Date Birthdate;
    private String ContactNumber;
    private Adress _Adress;

    public Client(int code, String surname, String name, String lastname, Date birthdate, String contactNumber, Adress adress, String city, String street, int houseNumber, int apartNumber) {
        Code = code;
        Surname = surname;
        Name = name;
        Lastname = lastname;
        Birthdate = birthdate;
        ContactNumber = contactNumber;
        _Adress = new Adress(city,street,houseNumber,apartNumber);
    }
}
