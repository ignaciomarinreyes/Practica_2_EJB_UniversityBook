package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class University implements Serializable {

    private static int idUniversity = 0;
    private int id;
    private String name;
    private Address address;

    public University() {
    }

    public University(String name, Address address) {
        this.id = idUniversity++;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
