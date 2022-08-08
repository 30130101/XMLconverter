
import java.util.ArrayList;


public class Person {
    String firstName;
    String lastName;
    Address address;

    ArrayList<Family> family = new ArrayList<>();
    Phone phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Family> getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family.add(family);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
