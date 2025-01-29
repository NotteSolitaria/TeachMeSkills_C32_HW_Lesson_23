package DOM;

import model.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    public static void parsingXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            Document doc = factory.newDocumentBuilder().parse(new File(fileName));
            doc.getDocumentElement().normalize();

            Book bookWithMostPages = null;
            int maxPages = 0;

            NodeList booksList = doc.getElementsByTagName("book");

            for (int i = 0; i < booksList.getLength(); i++) {
                Element bookElement = (Element) booksList.item(i);
                int pages = Integer.parseInt(bookElement.getElementsByTagName("pages").item(0).getTextContent());
                if (pages > maxPages) {
                    maxPages = pages;
                    bookWithMostPages = new Book();
                    bookWithMostPages.setAuthor(bookElement.getElementsByTagName("author").item(0).getTextContent());
                    bookWithMostPages.setGenre(bookElement.getElementsByTagName("genre").item(0).getTextContent());
                    bookWithMostPages.setPages(String.valueOf(pages));
                    bookWithMostPages.setTitle(bookElement.getElementsByTagName("title").item(0).getTextContent());
                    bookWithMostPages.setYear(bookElement.getElementsByTagName("year").item(0).getTextContent());
                }
            }

            System.out.println("Book with the most pages: " + bookWithMostPages);
        } catch (Exception e) {
            throw new RuntimeException("Error in parsing XML file", e);
        }
    }
}
