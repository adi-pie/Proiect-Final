package ro.sda.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    public void createAuthor(Author author) {
        Optional<Author> authorOptional = authorRepository.findAuthorByLastname(author.getLastname());
        if (authorOptional.isPresent()) {
            throw new IllegalStateException("Author is present");
        }
        authorRepository.save(author);
        // System.out.println(author);
    }


    public Author saveAuthor(Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getAuthor_id());
        if (optionalAuthor.isEmpty()) {
            return authorRepository.save(author);
        }
        throw new IllegalArgumentException("Author with id: " + author.getAuthor_id() + " already exists");
    }

    public Author updateAuthor(Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getAuthor_id());
        if (optionalAuthor.isPresent()) {
            return authorRepository.save(author);
        }
        throw new IllegalArgumentException("There is no author with id: " + author.getAuthor_id());
    }
    public void deleteAuthor(Integer authorId) {
        authorRepository.findById(authorId);
        boolean exists = authorRepository.existsById(authorId);
        if (!exists) {
            throw new IllegalStateException("Author with id " + authorId + " does not exists");
        }
        authorRepository.deleteById(authorId);
    }

}
