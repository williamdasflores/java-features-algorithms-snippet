package stream_terminal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

public class StreamMinByMaxByExamples {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person_1 = new Person("William", "Flores", 29);
        Person person_2 = new Person("John", "Stifler", 23);
        people.add(person_1);
        people.add(person_2);

        System.out.println(people.stream()
                .collect(minBy(Comparator.comparing(Person::getAge))));
        System.out.println(people.stream()
                .collect(maxBy(Comparator.comparing(Person::getAge))));

        System.out.println(people.stream()
            .collect(summingInt(Person::getAge)));
        System.out.println(people.stream()
                .collect(averagingInt(Person::getAge)));
    }
}