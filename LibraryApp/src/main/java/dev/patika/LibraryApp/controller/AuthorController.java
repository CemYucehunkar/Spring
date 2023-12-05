package dev.patika.LibraryApp.controller;

import dev.patika.LibraryApp.dto.request.AuthorRequest;
import dev.patika.LibraryApp.dto.response.AuthorResponse;
import dev.patika.LibraryApp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    // Burada yapılmak istenen şey, AuthorController sınıfının içerisinde AuthorService sınıfının nesnesini oluşturmak ve bu nesneyi kullanarak AuthorService sınıfının içerisindeki metodları çağırmaktır.


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getById(@PathVariable("id") Long id) {
        return authorService.getById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse save(@RequestBody AuthorRequest author) {
        return authorService.create(author);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse update(@PathVariable Long id, @RequestBody AuthorRequest request) {
        return authorService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        authorService.deleteById(id);
    }

}