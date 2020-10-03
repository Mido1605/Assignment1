import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Character> list;
        list = new ArrayList<Character>();
    
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