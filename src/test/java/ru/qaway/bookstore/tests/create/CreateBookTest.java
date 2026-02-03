package ru.qaway.bookstore.tests.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "createBooks")
    public void testCreateBook(Book book) {

        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);

        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);
    }

    @DataProvider
    public Object[][] createBooks() {
        return new Object[][] {
                { Book.defaultOf() },

                { Book.defaultOf().setTitle(randomAlphabetic(3)) },
                { Book.defaultOf().setTitle(randomAlphabetic(256)) },
                { Book.defaultOf().setDescription(randomAlphabetic(3)) },
                { Book.defaultOf().setDescription(randomAlphabetic(512)) },
                { Book.defaultOf().setAuthor(randomAlphabetic(3)) },
                { Book.defaultOf().setAuthor(randomAlphabetic(100)) },
                { Book.defaultOf().setPrice(0) },
                { Book.defaultOf().setCount(0) },
                { Book.defaultOf().setCategory(Category.Detective) },
                { Book.defaultOf().setCategory(Category.Fiction) },
                { Book.defaultOf().setCategory(Category.Horror) },
                { Book.defaultOf().setCategory(Category.Thriller) },
        };
    }
}
