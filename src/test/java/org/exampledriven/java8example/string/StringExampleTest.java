package org.exampledriven.java8example.string;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.exampledriven.java8example.StopWatch.measureTime;

public class StringExampleTest {

    private static final String EXPECTED = "a,b,c,d,e,f,g,h";
    private static final String[] stringArray = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final String DELIMITER = ",";
    private static final int LOOP_COUNT = 100000;

    @Test
    public void testStringConcatenation() {

        String result = StringExample.concatenate(stringArray, DELIMITER);
        assertEquals(EXPECTED, result);

    }



    @Test
    public void testConcatenateUsingStringBuffer() {

        String result = StringExample.concatenateUsingStringBuffer(stringArray, DELIMITER);
        assertEquals(EXPECTED, result);

    }

    @Test
    public void testConcatenateUsingStringBuilder() {

        String result = StringExample.concatenateUsingStringBuilder(stringArray, DELIMITER);
        assertEquals(EXPECTED, result);

    }

    @Test
    public void testConcatenateUsingStringJoin() {

        String result = StringExample.concatenateUsingStringJoin(stringArray, DELIMITER);
        assertEquals(EXPECTED, result);

    }

    @Test
    public void comparePerformance() {

        long timeStringConcatenation = measureTime(() ->
                {
                    for (int i = 0; i < StringExampleTest.LOOP_COUNT; i++) {
                        testStringConcatenation();
                    }
                }
        );
        System.out.println("timeStringConcatenation : " + timeStringConcatenation);

        long timeConcatenateUsingStringBuffer = measureTime(() ->
                {
                    for (int i = 0; i < StringExampleTest.LOOP_COUNT; i++) {
                        testConcatenateUsingStringBuffer();
                    }
                }
        );
        System.out.println("timeConcatenateUsingStringBuffer : " + timeConcatenateUsingStringBuffer);

        long timeConcatenateUsingStringBuilder = measureTime(() ->
                {
                    for (int i = 0; i < StringExampleTest.LOOP_COUNT; i++) {
                        testConcatenateUsingStringBuilder();
                    }
                }
        );
        System.out.println("timeConcatenateUsingStringBuilder : " + timeConcatenateUsingStringBuilder);

        long timeConcatenateUsingStringJoin = measureTime(() ->
                {
                    for (int i = 0; i < StringExampleTest.LOOP_COUNT; i++) {
                        testConcatenateUsingStringJoin();
                    }
                }
        );
        System.out.println("timeConcatenateUsingStringJoin : " + timeConcatenateUsingStringJoin);


    }


}
