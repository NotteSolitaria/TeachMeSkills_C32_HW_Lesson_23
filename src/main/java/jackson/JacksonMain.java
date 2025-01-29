package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonMain {
    public static List<Book> jacksonParse() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            List<Book> books = mapper.readValue(new File("books.json"), mapper.getTypeFactory().constructCollectionType(List.class, Book.class));
            return books;

        } catch (JsonProcessingException e) {
            e.getMessage();
            return null;
        }
    }
}
