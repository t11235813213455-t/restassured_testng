package ru.qaway.bookstore.tests.rest.model.request;

public class AccessModifiers {

    public static void main(String[] args) {
        Book book = new Book();

        book.setTitle("The Adventures of Tom Sawyer");
        System.out.println(book.getTitle());

        book.setDescription("The story about Tom Sawyer.");
        System.out.println(book.getDescription());
    }
}
