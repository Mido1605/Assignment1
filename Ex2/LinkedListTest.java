import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Character> list;
        list = new LinkedList<Character>() ;

        int end = 2000000;

        long start1 = System.currentTimeMillis();

        for (var i = 0; i < end; i++) {
            // list.add( (char) i);
            list.add((char) (i%26 +97));
        }

        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;

        System.out.println(timeElapsed1);

        long start = System.currentTimeMillis();

        String finalString = "";
        for(char elem : list){
            finalString += elem;
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish -start;

        System.out.println("Time needed for an LinkedLisr to perform the task with "
        + end+ " elements : "+timeElapsed+ " millisecondes");

    }
}
