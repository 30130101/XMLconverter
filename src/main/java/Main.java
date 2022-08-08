import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File file = new File(args[0]);
        convertToXML(file);

    }
    public static void convertToXML(File file){
        ArrayList<Person> peopleList = new ArrayList<>();
        People people = new People();
        boolean newPerson = false;
        try {
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            String s = br.readLine();
            String[] st = s.split("\\|");
            do {
                Person person = new Person();
                person.firstName = st[1];
                person.lastName = st[2];
                newPerson = false;
                outer:
                while ((s = br.readLine()) != null) {
                    st = s.split("\\|");
                    switch (st[0]) {
                        case "P":
                            newPerson = true;
                            break outer;
                        case "T":
                            person.setPhone(new Phone(st[1], st[2]));
                            break;
                        case "A":
                            person.setAddress(new Address(st[1], st[2], st[3]));
                            break;
                        case "F":
                            do {
                                st[0] = "";
                                Family f = new Family();
                                f.setName(st[1]);
                                f.setBorn(st[2]);
                                while ((s = br.readLine()) != null) {
                                    st = s.split("\\|");
                                    if (st[0].equals("T")) {
                                        f.setPhone(new Phone(st[1], st[2]));
                                    } else if (st[0].equals("A")) {
                                        f.setAddress(new Address(st[1], st[2], st[3]));
                                    } else if (st[0].equals("P")) {
                                        newPerson = true;
                                        person.setFamily(f);
                                        break outer;
                                    } else
                                        break;
                                }
                                person.setFamily(f);
                            } while (st[0].equals("F"));
                            break;
                        default:
                            break;
                    }
                }
                peopleList.add(person);

            } while (newPerson);

            br.close();

            //Write content to output
            /*
            people.setPeople(peopleList);
            for (Person p : peopleList) {
                System.out.println(p.getAddress());
                System.out.println(p.getFamily());
                System.out.println(p.getFirstName());
                System.out.println(p.getLastName());
                System.out.println(p.getPhone());
            }
            */
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.printf("ERROR: %s\n", e);
        }

        try {

            ObjectMapper mapper = new XmlMapper();
            mapper.writeValue(new File("output.xml"), people);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
