package ru.qaway.bookstore.tests.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookResponse;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());
    }
}
