package stream_terminal;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExamples {
    public static void main(String[] args) {
        List<Person> people = Person.getListPeople();

        Map<String, List<Person>> collectAges = people.stream()
                .collect(groupingBy(Person::getGender));
        System.out.println(collectAges.get("F"));
        System.out.println("------------");

        Map<String, List<Person>> collect = people.stream()
                .collect(groupingBy(person -> person.getAge() < 18 ? "youngest" : "oldest"));
        System.out.println(collect.get("youngest"));
        System.out.println("------------");

        Map<String, Map<String, List<Person>>> collect1 = people.stream()
                .collect(groupingBy(Person::getGender,
                        groupingBy(person -> person.getAge() < 18 ? "youngest" : "oldest")));
        System.out.println(collect1);
        System.out.println("------------");

        LinkedHashMap<String, Set<Person>> nameAndObject = people.stream()
                .collect(groupingBy(Person::getName, LinkedHashMap::new, toSet()));
        System.out.println(nameAndObject);
        System.out.println("------------");

        Map<String, Person> collect2 = people.stream()
                .collect(groupingBy(Person::getGender,
                        collectingAndThen(maxBy(Comparator.comparing(Person::getAge)),
                                Optional::get)));
        System.out.println(collect2);

    }

}

