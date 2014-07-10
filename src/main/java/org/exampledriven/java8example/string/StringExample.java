package org.exampledriven.java8example.string;

public class StringExample {

    public static String concatenate(String[] stringArray, String delimiter) {

        if (delimiter == null || stringArray == null || stringArray.length == 0) {
            return null;
        }

        String result = stringArray[0];

        for (int i = 1; i < stringArray.length ;i++) {
            result += delimiter;
            result += stringArray[i];

        }
        return result;
    }

    public static String concatenateUsingStringBuffer(String[] stringArray, String delimiter) {

        if (delimiter == null || stringArray == null || stringArray.length == 0) {
            return null;
        }

        StringBuffer result = new StringBuffer().append(stringArray[0]);

        for (int i = 1; i < stringArray.length ;i++) {
            result.append(delimiter).append(stringArray[i]);

        }

        return result.toString();
    }

    public static String concatenateUsingStringBuilder(String[] stringArray, String delimiter) {

        if (delimiter == null || stringArray == null || stringArray.length == 0) {
            return null;
        }

        StringBuilder result = new StringBuilder().append(stringArray[0]);

        for (int i = 1; i < stringArray.length ;i++) {
            result.append(delimiter).append(stringArray[i]);

        }

        return result.toString();
    }

    public static String concatenateUsingStringJoin(String[] stringArray, String delimiter) {

        if (delimiter == null || stringArray == null || stringArray.length == 0) {
            return null;
        }

        return String.join(delimiter, stringArray);
    }

}
