import DOM.DOMParser;
import JAXB.JAXBMain;
import jackson.JacksonMain;
import jakarta.xml.bind.JAXBException;
import model.Book;

import java.io.IOException;
import java.util.List;

/**
 * 1. Using the Jackson library, write a Java program that parses a JSON file (books.json) and saves the data to a Java collection.
 * 2. Convert the data from this collection to XML using the JAXB library.
 * Save the resulting XML to a file.
 * 3. Using any parser (DOM, SAX, StAX), parse the data in a Java application and output to the console information about the book with the largest number of pages.
 */

public class ApplicationRunner {
    public static void main(String[] args) throws IOException, JAXBException {
        List<Book> listOfBooks = JacksonMain.jacksonParse();

        JAXBMain.JAXBParse(listOfBooks);

        DOMParser.parsingXML("books.xml");
    }
}
