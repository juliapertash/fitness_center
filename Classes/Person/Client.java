package Person;

import java.util.Date;

public class Client {
    private String Surname;
    private String Name;
    private String Lastname;
    private String Birthdate;
    private String ContactNumber;
    private String _Adress;


    public void Setc(String value){
        ContactNumber=value;
    }
    public void Seta(String value){
        _Adress=value;
    }
    public Client(String surname, String name, String lastname, String birthdate, String contactNumber, String adress) {

        Surname = surname;
        Name = name;
        Lastname = lastname;
        Birthdate = birthdate;
        ContactNumber = contactNumber;
        _Adress = adress;
    }
    public void ToString()
    {

        System.out.printf("Фамилия: %s, Имя: %s, Отчество: %s, Дата рождения: %s, номер: %s, адрес: %s.\n", Surname, Name, Lastname, Birthdate, ContactNumber, _Adress);
    }
}
