import java.io.*;
import java.util.*;

public class PointCP5EfficiencyTest {

    public static void main(String[] args) {
        PointCP5 point;
        long startTime;
        long totalTime;
        long endTime;
        int runningTime = 0;

        long smallestTime = 999999; // made it a very large number so the first time
                                    // set it will automatically be changed.
        long largestTime = 0;
        int median;
        ArrayList<Long> listOfTimes = new ArrayList<Long>();
        int counter = 0;

        // i for x/rho
        // j for y/theta
        // k to ensure every value gets tested for polar/cartesian
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 360; j += 1) {
                for (int k = 0; k < 2; k++) {
                    counter++;
                    if (k == 0) {
                        startTime = System.nanoTime();
                        point = new PointCP3(i, j);
                        point.getX();
                        point.getY();
                        point.getRho();
                        point.getTheta();
                        endTime = System.nanoTime();
                        totalTime = endTime - startTime;
                        runningTime += totalTime;

                        listOfTimes.add(totalTime);

                        if (totalTime > largestTime) {
                            largestTime = totalTime;
                        }
                        if (totalTime < smallestTime) {
                            smallestTime = totalTime;
                        }

                    } else {
                        startTime = System.nanoTime();
                        point = new PointCP2(i, j);
                        point.getRho();
                        point.getTheta();
                        point.getX();
                        point.getY();

                        endTime = System.nanoTime();
                        totalTime = endTime - startTime;
                        runningTime += totalTime;

                        listOfTimes.add(totalTime);

                        if (totalTime > largestTime) {
                            largestTime = totalTime;
                        }
                        if (totalTime < smallestTime) {
                            smallestTime = totalTime;
                        }
                    }
                }

            }
        }
        System.out.println(
                "Smallest time: " + smallestTime + " nanoseconds\nLargest time: " + largestTime + " nanoseconds");
        System.out.println("Mean: " + runningTime / counter + " nanoseconds.");

        Collections.sort(listOfTimes);
        median = counter / 2;
        System.out.println("Median: " + listOfTimes.get(median) + " nanoseconds.");

    }
}