package optional;

import domain.Person;

import java.util.List;
import java.util.Optional;

public class OptionalMapFlatMapExample {

    private static void optionalFilter() {
        //Optional<List<Person>> optionalPeople = Optional.ofNullable(Person.getListPeople());
        Optional<List<Person>> optionalPeople = Optional.ofNullable(null);

        optionalPeople.ifPresent(optional -> optional.stream()
                .filter(person -> person.getGender().equals("F"))
                .forEach(person -> System.out.println(person.getName())));
    }

    public static void main(String[] args) {
        optionalFilter();
    }
}
