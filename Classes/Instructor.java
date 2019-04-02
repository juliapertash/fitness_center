import Person.Client;

import java.util.List;

public class Instructor extends GroupClasses
        {
            private int Code;
            private String Surname;
            private String Name;
            private String Lastname;
            public Instructor(String name, int duration, String about, String type, int id, int price, List<Client> clientsOfAGroup, int code, String surname, String name1, String lastname) {

                super(name, duration, about, type, id, price, clientsOfAGroup);
                Code = code;

                Surname = surname;
                Name = name1;
                Lastname = lastname;
            }
        }
