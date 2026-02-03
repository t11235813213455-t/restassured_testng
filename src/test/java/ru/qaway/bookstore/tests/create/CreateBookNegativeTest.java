package ru.qaway.bookstore.tests.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookResponse;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "createBooksNegative")
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());
    }

    @DataProvider
    public Object[][] createBooksNegative() {
        return new Object[][] {
                { Book.defaultOf().setTitle(randomAlphabetic(2))},
                { Book.defaultOf().setTitle(randomAlphabetic(257))},
                { Book.defaultOf().setDescription(randomAlphabetic(2))},
                { Book.defaultOf().setDescription(randomAlphabetic(513))},
                { Book.defaultOf().setAuthor(randomAlphabetic(2))},
                { Book.defaultOf().setAuthor(randomAlphabetic(101))},
                { Book.defaultOf().setPrice(-1)},
                { Book.defaultOf().setCount(-1)},
                { Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}
