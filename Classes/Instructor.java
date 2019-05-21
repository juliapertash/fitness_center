import Person.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Instructor extends GroupClasses
        {
            private int Code;
            private String Surname;
            private String Name;
            private String Lastname;
            public Instructor(String name, int duration, String about, String type, int id, int price, ArrayList<Client> clients, int code, String surname, String name1, String lastname) {

                super(name, duration, about, type, id, price, clients);
                Code = code;

                Surname = surname;
                Name = name1;
                Lastname = lastname;
            }

            @Override
            void ToString() {
                super.ToString();
                System.out.printf("Инструктор: %s\t%s\t%s\t%s\n", Code, Surname, Name, Lastname);
            }
        }
