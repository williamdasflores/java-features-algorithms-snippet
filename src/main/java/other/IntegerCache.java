package other;

public class IntegerCache {

    public static void main(String ...args) {
        // It ranges from -128 to 127
        /**If x and y is 127 they are equals but if they are
         * out of the range then will be not equal
         */
       /* Integer x = 128;
        Integer y = 128;*/
        Integer x = 127;
        Integer y = 127;

        if (x == y)
            System.out.println("They are equals!");
        else
            System.out.println("Not equals!");
    }
}
