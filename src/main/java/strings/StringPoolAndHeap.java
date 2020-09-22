package strings;

public class StringPoolAndHeap {

    public static void main(String[] args) {
        String name1 = "William";
        String name2 = "William";
        String name3 = name2;

        String name4 = new String("William");
        String name5 = new String("William");

        System.out.println(name1 == name2);
        System.out.println(name1 == name3);
        System.out.println(name2 == name3);

        System.out.println(name1 == name4);
        System.out.println(name1 == name5);
        System.out.println(name4 == name5);
    }
}
