package org.myproject.ebiblio;

import org.junit.jupiter.api.Test;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EbiblioApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveBook() {

    }
}
