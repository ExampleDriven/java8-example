package org.exampledriven.java8example.stream;

public class Book {

    public enum Type {
        ROMANCE, HORROR
    }

    public Book() {
    }

    public Book(Type type) {
        this.type = type;
    }

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public boolean isRomance() {
        return Type.ROMANCE.equals(type);
    }

    @Override
    public String toString() {
        return "Book{" +
                "type=" + type +
                '}';
    }
}
