package model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    private List<Book> books;

    public Books() {
    }

    public Books(List<Book> booksList) {
        this.books = booksList != null ? booksList : new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books != null ? books : new ArrayList<>();
    }
}
