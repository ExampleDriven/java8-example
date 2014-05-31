package org.exampledriven.java8example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamExampleTest {

    public static final int EXPECTED = 25000;
    public static final int SIZE = 50000;

    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = Stream.iterate(new Book(Book.Type.HORROR), previousPerson -> {
                Book newBook = new Book();

                if (Book.Type.HORROR.equals(previousPerson.getType())) {
                    newBook.setType(Book.Type.ROMANCE);
                } else {
                    newBook.setType(Book.Type.HORROR);
                }

                return newBook;
            }
        ).limit(SIZE).
        collect(Collectors.toList());
    }

    @Test
    public void testCountRomanceUsingStream() {

        long count = StreamExample.countRomanceUsingStream(books.stream());
        assertEquals(EXPECTED, count);


    }

    @Test
    public void testCountRomanceUsingParallelStream() {

        long count = StreamExample.countRomanceUsingStream(books.parallelStream());
        assertEquals(EXPECTED, count);

    }

    @Test
    public void testCountRomanceUsingList() {

        long count = StreamExample.countRomanceUsingList(books);
        assertEquals(EXPECTED, count);

    }

    @Test
    public void comparePerformance() {

        long timeStream = measureTime(() -> testCountRomanceUsingStream());
        System.out.println("timeStream : " + timeStream);

        long timeParallelStream = measureTime(() -> testCountRomanceUsingParallelStream());
        System.out.println("timeParallelStream : " + timeParallelStream);

        long timeListStream = measureTime(() -> testCountRomanceUsingList());
        System.out.println("timeListStream : " + timeListStream);

    }

    private long measureTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

}