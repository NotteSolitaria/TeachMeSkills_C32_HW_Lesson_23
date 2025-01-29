package JAXB;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Book;
import model.Books;

import java.io.File;
import java.util.List;

public class JAXBMain {
    public static void JAXBParse(List<Book> booksList) throws JAXBException {
        try {
            Books books = new Books();
            books.setBooks(booksList);

            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(books, new File("books.xml"));
        } catch (JAXBException e) {
            throw new JAXBException(e);
        }
    }
}
