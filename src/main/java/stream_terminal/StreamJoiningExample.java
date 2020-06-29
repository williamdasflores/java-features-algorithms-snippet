package stream_terminal;

import domain.Person;

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

