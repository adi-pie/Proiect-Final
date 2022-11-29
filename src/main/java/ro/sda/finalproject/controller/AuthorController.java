package ro.sda.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.User;
import ro.sda.finalproject.service.AuthorService;

import java.util.List;


@RestController
@RequestMapping(path = "/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @GetMapping("/getAuthor")
    public List<Author> getAuthor() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/createAuthor")
    public void registerNewAuthor(@RequestBody Author author){
        authorService.createAuthor(author);

    }

    @DeleteMapping(path = "{author_id}")
    public void deleteAuthor(@PathVariable("author_id") Integer authorId){
        authorService.deleteAuthor(authorId);

    }

    @PutMapping(path = "{author_id}")
    public void updateAuthor(Author author){
        authorService.updateAuthor(author);
    }




}
