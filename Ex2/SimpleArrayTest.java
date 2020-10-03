public class SimpleArrayTest {
    public static void main(String[] args) {

        int end = 500000;
        char[] list = new char[end];

        for(int i = 0; i < list.length; i++){
            list[i] = (char) (i%26 +97);
        }

        long start = System.currentTimeMillis();

        String finalString = "";
        for(char elem : list){
            finalString += elem;
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish -start;

        System.out.println("Time needed for a Simple Array to perform the task with "
        + end+ " elements : "+timeElapsed+ " millisecondes");

    }
}
