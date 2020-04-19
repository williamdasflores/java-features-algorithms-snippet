package streams.beans;

public class Home {

    private String address;
    private Person person;

    public Home(String address, Person person) {
        this.address = address;
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return address + " " + person;
    }
}
