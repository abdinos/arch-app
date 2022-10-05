package myboot.app4.test;

import myboot.app1.dao.MovieRepository;
import myboot.app1.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieRestControllerTest {

    @Autowired
    MovieRepository repo;

    @Test
    void getMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<List> response = restTemplate.getForEntity(url + "/movies", List.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    void getNoExistingMovie() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        Assertions.assertThrows(HttpServerErrorException.InternalServerError.class, () -> {
            restTemplate.getForEntity(url + "/movies/9", String.class);});

    }
    @Test
    @Order(1)
    void getMovie() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/movies/1", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    @Order(2)
    void deleteMovie() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
         restTemplate.delete(url + "/movies/2");
        Assertions.assertThrows(HttpServerErrorException.InternalServerError.class, () -> {
            restTemplate.getForEntity(url + "/movies/2", String.class);});
    }

}