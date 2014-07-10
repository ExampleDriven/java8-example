package org.exampledriven.java8example.stream;

import org.exampledriven.java8example.stream.Book;
import org.exampledriven.java8example.stream.StreamExample;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.exampledriven.java8example.StopWatch.measureTime;
import static org.junit.Assert.*;

public class StreamExampleTest {

    public static final int NUMBER_OF_BOOKS = 5000000;
    public static final int NUMBER_OF_ROMANCE = NUMBER_OF_BOOKS / 2;

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
        ).limit(NUMBER_OF_BOOKS).
        collect(Collectors.toList());
    }

    @Test
    public void testCountRomanceUsingStream() {

        long count = StreamExample.countRomanceUsingStream(books.stream());
        assertEquals(NUMBER_OF_ROMANCE, count);

    }

    @Test
    public void testCountRomanceUsingParallelStream() {

        long count = StreamExample.countRomanceUsingStream(books.parallelStream());
        assertEquals(NUMBER_OF_ROMANCE, count);

    }

    @Test
    public void testCountRomanceUsingList() {

        long count = StreamExample.countRomanceUsingList(books);
        assertEquals(NUMBER_OF_ROMANCE, count);

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

}