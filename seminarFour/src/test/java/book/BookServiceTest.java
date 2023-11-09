package book;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

//У вас есть класс BookService, который использует интерфейс BookRepository
// для получения информации о книгах из базы данных.
// Ваша задача написать unit-тесты для BookService,
// используя Mockito для создания мок-объекта BookRepository.

public class BookServiceTest {

    @Test
    public void testFindBookById() {
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findById(anyString())).thenReturn(new Book("b02"));

        BookService bookService = new BookService(bookRepository);
        bookService.findBookById("b02");
    }

    @Test
    public void testFindAllBook() {
        BookRepository bookRepository = mock(BookRepository.class);
        List expectedBDBooks = Arrays.asList(
                new Book("b01", "Три мушкетера", "А.Дюма"),
                new Book("b02", "Братья Карамазовы", "Ф.Достоевский"),
                new Book("b03", "Собор Парижской Богоматери", "В.Гюго"),
                new Book("b04", "Черный тюльпан", "А.Дюма")
        );
        when(bookRepository.findAll(anyString())).thenReturn(expectedBDBooks);

        //Создаем экземпляр BookService и помещаем в него мок-объект
        BookService bookService = new BookService(bookRepository);
        assertThat(bookService.findAllBooks("SELECT * FROM book ").size()).isEqualTo(4);
    }


    @Test
    public void testFindAllADuma() {
        BookRepository bookRepository = mock(BookRepository.class);
        List expectedBDBooks = Arrays.asList(
                new Book("b01", "Три мушкетера", "А.Дюма"),
                new Book("b02", "Братья Карамазовы", "Ф.Достоевский"),
                new Book("b03", "Собор Парижской Богоматери", "В.Гюго"),
                new Book("b04", "Черный тюльпан", "А.Дюма")
        );
        when(bookRepository.findAll("А.Дюма")).thenReturn(expectedBDBooks);

        //Создаем экземпляр BookService и помещаем в него мок-объект
        BookService bookService = new BookService(bookRepository);
        List resultDumaBooks = bookService.findAllBooks("А.Дюма");
        assertEquals(expectedBDBooks, resultDumaBooks);
    }
}
