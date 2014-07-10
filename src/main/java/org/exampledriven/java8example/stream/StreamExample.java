package org.exampledriven.java8example.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static long countRomanceUsingStream(Stream<Book> books) {

        long count = books.
            filter(Book::isRomance).
            count();

        return count;

    }

    public static long countRomanceUsingList(List<Book> books) {
        long count = 0;
        for (Book book : books) {
            if (book.isRomance()) {
                count++;
            }
        }

        return count;
    }
}
