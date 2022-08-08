
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


import java.util.ArrayList;

public class People {
    @JacksonXmlElementWrapper(localName = "people")
    @JacksonXmlProperty(localName = "person")

    ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return people;
    }
    public void addPerson(Person p){
        people.add(p);
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
