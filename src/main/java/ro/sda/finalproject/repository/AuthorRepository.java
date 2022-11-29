package ro.sda.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalproject.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAll();

    Optional<Author> findAuthorByFirstname(String firstname);
    Optional<Author> findAuthorByFirstnameAndLastname(String firstName, String lastName);
    Optional<Author> findAuthorByLastname(String lastName);
}


