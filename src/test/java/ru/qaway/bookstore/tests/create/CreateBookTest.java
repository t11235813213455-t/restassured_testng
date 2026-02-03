package ru.qaway.bookstore.tests.create;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
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
}
