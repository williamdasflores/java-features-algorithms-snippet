package stream_terminal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamJoiningExample {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person_1 = new Person("William", "Flores", 29);
        Person person_2 = new Person("John", "Stifler", 23);
        people.add(person_1);
        people.add(person_2);

        String joiningName = people.stream()
                .map(person -> person.getName()+ " " +person.getLastName())
                .collect(Collectors.joining(" - "));
        List<String> listaLastNames = people.stream()
                .collect(mapping(Person::getLastName, toList()));
        listaLastNames.forEach(System.out::println);

        System.out.println(joiningName);
        System.out.println(people.stream().collect(counting()));

    }
}

@Getter
@AllArgsConstructor
@ToString
class Person {
    private String name;
    private String lastName;
    private int age;
    private String gender;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public static List<Person> getListPeople() {
        List<Person> people = new ArrayList();
        Person person_1 = new Person("William", "Flores", 29, "M");
        people.add(person_1);
        Person person_2 = new Person("Marcella", "Freitas", 21, "F");
        people.add(person_2);
        Person person_3 = new Person("Jessica", "Cavalcante", 28, "F");
        people.add(person_3);
        Person person_4 = new Person("Gabriella", "Zukenberg", 20, "F");
        people.add(person_4);
        Person person_5 = new Person("John", "Stifler", 27, "M");
        people.add(person_5);
        Person person_6 = new Person("Maria", "Eloisa", 15, "F");
        people.add(person_6);
        Person person_7 = new Person("Jefferson", "Silva", 17, "M");
        people.add(person_7);

        return people;
    }

}
