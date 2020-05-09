package streams;


import streams.beans.Person;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Stream performs operations in collections.
 * It can be performed either sequentially or parallel
 */
public class StreamsExample {

    public static void main(String[] args) {
        Person william = new Person("William", 29);
        Person priscilla = new Person("Priscilla", 23);
        Person anaPaula = new Person("Ana Paula", 29);
        Person john = new Person("John", 40);
        Person eloisa = new Person("Heloisa", 11);
        List<Person> people = Arrays.asList(william, priscilla, anaPaula, john, eloisa);

        System.out.println("---------------------Filter----------------------------");
        Stream<Person> personStream = people.stream().filter(person -> person.getAge() >= 29);
        personStream.forEach(person -> System.out.println(person));
        System.out.println("-------------------------------------------------------");

        System.out.println("------------------------Map--------------------------");
        //map -> it converts(transforms) one type to another
        List<String> names = people.stream()
                //.map(person -> person.getName()) //long way of map
                .map(Person::getName) //short way of map
                .collect(toList());
        names.forEach(name -> System.out.println(name));
        System.out.println("-------------------------------------------------------");

        System.out.println("-----------------------Average-------------------------------");
        Double averageAge = people.stream().collect(Collectors.averagingInt(person -> person.getAge()));
        System.out.println("Average age is " + averageAge.intValue());
        System.out.println("-------------------------------------------------------");

        System.out.println("-----------------------------Summarize-------------------------");
        IntSummaryStatistics ageSum = people.stream().collect(Collectors.summarizingInt(person -> person.getAge()));
        System.out.println("Age sum is " + ageSum);
        System.out.println("-------------------------------------------------------");

        System.out.println("---------------------GroupBy--------------------------------");
        Map<Integer, List<Person>> personByAge = people.stream().collect(Collectors.groupingBy(person -> person.getAge()));
        personByAge.forEach( (age, person) -> System.out.println("Age " + age + " | " +person));
        System.out.println("-------------------------------------------------------");

        System.out.println("----------------------Joining--------------------------------");
        String phrase = people.stream()
                .filter( person -> person.getAge() >= 18)
                .map(person -> person.getName())
                //.collect(Collectors.joining());
                .collect(Collectors.joining(" and ", " In Brazil ", " are of legal age."));
        System.out.println(phrase);
        System.out.println("-------------------------------------------------------");

        System.out.println("----------------------Own Collector--------------------------------");
        // Creating my own Collector
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                () -> new StringJoiner(" | "),
                (joiner, person) -> joiner.add(person.getName().toUpperCase()),
                (joiner1, joiner2) -> joiner1.merge(joiner2),
                StringJoiner::toString);

        String listNames = people.stream().collect(personNameCollector);
        System.out.println(listNames);
        System.out.println("-------------------------------------------------------");

        System.out.println("----------------------Reduce--------------------------------");
        people.stream()
                .reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2)
               .ifPresent(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("----------------------Sum with Reduce--------------------------------");
        Integer ageSumWithReduce = people.stream()
                .reduce(0, (sum, person) -> sum += person.getAge(),
                        (person1, person2) -> person1 + person2);
        System.out.println("Age sum: " +ageSumWithReduce);
        System.out.println("-------------------------------------------------------");

        System.out.println("-------------------------Size----------------------------");
        System.out.println("The size of list is: " + people.stream().count());
        System.out.println("-------------------------------------------------------");

        System.out.println("-------------------------Distinct----------------------------");
        List<Integer> distinctAge = people.stream()
                .map(Person::getAge)
                .collect(toList());
        distinctAge.add(40);
        distinctAge.add(11);
        List<Integer> listDisticnted = distinctAge.stream().distinct().collect(toList());
        listDisticnted.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("-----------------------Sort------------------------------");
        List<String> namesSorted = people.stream()
                .map(Person::getName)
                .sorted()
                .collect(toList());
        namesSorted.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("---------------------Custom Sort By Name--------------------------------");
        List<Person> listSortedByName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(toList());
        listSortedByName.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("-----------------------Sort Reversed By Age------------------------------");
        List<Person> ageByOldest = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(toList());
        ageByOldest.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("------------------------Limit-------------------------------");
        List<Integer> limitList = people.stream()
                .map(Person::getAge)
                .limit(2)
                .collect(toList());
        limitList.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("------------------Skip-----------------------------------");
        List<Person> skipItems = people.stream()
                .skip(4)
                .collect(toList());
        skipItems.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        System.out.println("--------------------allMatch|anyMatch|noneMatch----------------------------");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 18);
        System.out.println(allMatch);
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 18);
        System.out.println(anyMatch);
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge() > 18);
        System.out.println(noneMatch);
        System.out.println("-------------------------------------------------------");

        System.out.println("--------------------of|iterate|generate----------------------------------");
        Stream<String> carsStream = Stream.of("Polo", "Audi A3", "T-Cross");
        carsStream.forEach(System.out::println);
        Stream.iterate(1, x -> x*2)
                .limit(10)
                .forEach(System.out::print);
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(2)
                .forEach(System.out::println);

    }
}
