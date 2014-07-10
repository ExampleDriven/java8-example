package org.exampledriven.java8example;

public class StopWatch {

    public static long measureTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

}
