package com.polarbookshop.catalog_service.web;




import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import com.polarbookshop.catalog_service.domain.Book;



@JsonTest
class BookJsonTests {


    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
       // var book = new Book("1234567890", "Title", "Author", 9.90);
        var book = new Book("Author", "Title", "1234567890", 9.90);
        var jsonContent = json.write(book);

        

        // assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
        //         .isEqualTo(book.isbn());
        // assertThat(jsonContent).extractingJsonPathStringValue("@.title")
        //         .isEqualTo(book.title());
        // assertThat(jsonContent).extractingJsonPathStringValue("@.author")
        //         .isEqualTo(book.author());
        // assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
        //         .isEqualTo(book.price());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
         assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());
           assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());
        


    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
              "author": "Author",
               "title" : "Title",
               "isbn" : "1234567890",
               "price" : 9.90
        }
                """;
                assertThat(json.parse(content))
                        .usingRecursiveComparison()
                        .isEqualTo(new Book("Author", "Title", "1234567890", 9.90));
    }
  
}
