package streams;


import streams.beans.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {
        Person william = new Person("William", 29);
        Person priscilla = new Person("Priscilla", 23);
        Person anaPaula = new Person("Ana Paula", 29);
        Person john = new Person("John", 40);
        Person eloisa = new Person("Heloisa", 11);
        List<Person> people = Arrays.asList(william, priscilla, anaPaula, john, eloisa);

        Stream<Person> personStream = people.stream().filter(person -> person.getAge() >= 29);
        personStream.forEach(person -> System.out.println(person));
        System.out.println("-------------------------------------------------------");

        Stream<String> nameStream = people.stream().map(person -> person.getName());
        nameStream.forEach(name -> System.out.println(name));
        System.out.println("-------------------------------------------------------");

        Double averageAge = people.stream().collect(Collectors.averagingInt(person -> person.getAge()));
        System.out.println("Average age is " + averageAge.intValue());
        System.out.println("-------------------------------------------------------");

        IntSummaryStatistics ageSum = people.stream().collect(Collectors.summarizingInt(person -> person.getAge()));
        System.out.println("Age sum is " + ageSum);
        System.out.println("-------------------------------------------------------");

        Map<Integer, List<Person>> personByAge = people.stream().collect(Collectors.groupingBy(person -> person.getAge()));
        personByAge.forEach( (age, person) -> System.out.println("Age " + age + " | " +person));
        System.out.println("-------------------------------------------------------");


        String phrase = people.stream()
                .filter( person -> person.getAge() >= 18)
                .map(person -> person.getName())
                //.collect(Collectors.joining());
                .collect(Collectors.joining(" and ", " In Brazil ", " are of legal age."));
        System.out.println(phrase);
        System.out.println("-------------------------------------------------------");

        // Creating my own Collector
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                () -> new StringJoiner(" | "),
                (joiner, person) -> joiner.add(person.getName().toUpperCase()),
                (joiner1, joiner2) -> joiner1.merge(joiner2),
                StringJoiner::toString);

        String listNames = people.stream().collect(personNameCollector);
        System.out.println(listNames);
        System.out.println("-------------------------------------------------------");

        people.stream()
                .reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2)
               .ifPresent(System.out::println);
        System.out.println("-------------------------------------------------------");

        Integer ageSumWithReduce = people.stream()
                .reduce(0, (sum, person) -> sum += person.getAge(),
                        (person1, person2) -> person1 + person2);
        System.out.println("Age sum: " +ageSumWithReduce);


    }
}
