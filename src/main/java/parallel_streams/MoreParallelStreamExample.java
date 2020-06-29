package parallel_streams;

import streams.beans.Person;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MoreParallelStreamExample {
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("Default Pool Parallelism: " +commonPool.getParallelism());
        Person william = new Person("William", 29);
        Person priscilla = new Person("Priscilla", 23);
        Person anaPaula = new Person("Ana Paula", 29);
        Person john = new Person("John", 40);
        Person eloisa = new Person("Heloisa", 11);
        List<Person> people = Arrays.asList(william, priscilla, anaPaula, john, eloisa);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,10,11,12,13,14,15);

        // It will print unordered
        numbers.stream().parallel().forEach(number -> System.out.println(number));

        people.parallelStream()
                .filter( person -> {
                    System.out.format("filter: %s [%s]\n",
                    person.getName(), Thread.currentThread().getName());
                    return true;
                })
                .map(person -> {
                    System.out.format("map: %s [%s]\n",
                            person.getName(), Thread.currentThread().getName());
                    return person.getName().toUpperCase();
                })
                .forEach(person -> System.out.format("forEach: %s [%s]\n",
                        person, Thread.currentThread().getName()));
        System.out.println("-------------------------------------------------------");

        people.parallelStream()
                .filter( person -> {
                    System.out.format("filter: %s [%s]\n",
                            person.getName(), Thread.currentThread().getName());
                    return true;
                })
                .map(person -> {
                    System.out.format("map: %s [%s]\n",
                            person.getName(), Thread.currentThread().getName());
                    return person.getName().toUpperCase();
                })
                .sorted((person1, person2) -> {
                    System.out.format("sort: %s <> %s [%s]\n",
                            person1, person2, Thread.currentThread().getName());
                    return person1.compareTo(person2);
                })
                .forEach(person -> System.out.format("forEach: %s [%s]\n",
                        person, Thread.currentThread().getName()));

    }
}
