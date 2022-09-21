package myboot.app4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myboot.app1.dao.MovieRepository;
import myboot.app1.model.Movie;

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

}