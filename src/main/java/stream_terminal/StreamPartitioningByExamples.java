package stream_terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class StreamPartitioningByExamples {

    public static void partitioningBy_1() {
        Map<Boolean, List<Person>> partitioningBy = Person.getListPeople().stream()
                .collect(partitioningBy(person -> person.getAge() > 25));
        System.out.println("PartitioningBy_1 " + partitioningBy);
    }
    public static void partitioningBy_2() {
        Map<Boolean, Set<Person>> partitioningBy = Person.getListPeople().stream()
                .collect(partitioningBy(person -> person.getAge() > 25, toSet()));
        System.out.println("PartitioningBy_2 " + partitioningBy);
    }


    public static void main(String[] args) {
        partitioningBy_1();
        partitioningBy_2();
    }

}
