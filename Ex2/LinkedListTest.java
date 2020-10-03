import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Character> list;
        list = new LinkedList<Character>() ;

        int end = 500000;

        long start = System.currentTimeMillis();

        for (var i = 0; i < end; i++) {
            // list.add( (char) i);
            list.add((char) (i%26 +97));
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish -start;

        System.out.println(timeElapsed);

    }
}
