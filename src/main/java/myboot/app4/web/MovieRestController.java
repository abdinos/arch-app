package myboot.app4.web;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import myboot.app1.dao.MovieRepository;
import myboot.app1.model.Movie;

import javax.validation.Valid;

@RestController

@RequestMapping("/api")
public class MovieRestController {

    @Autowired
    MovieRepository repo;

    @GetMapping("/movies")
    public Iterable<Movie> getMovies() {
        return repo.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return repo.findById(id).get();
    }
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable int id) {
        repo.deleteById(id);
    }
    @PostMapping("/movies")
    public Movie postMovie(@RequestBody @Valid Movie m) {
        repo.save(m);
        return m;
    }


}