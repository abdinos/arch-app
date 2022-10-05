package myboot.app4.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HelloRestControllerTest {

    @Test
    void testHello() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/hello", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals("Hello",response.getBody());

    }

    @Test
    void testList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<List> response = restTemplate.getForEntity(url + "/list", List.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(Arrays.asList(10, 20, 30),response.getBody());
    }

    @Test
    void testHelloWithMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/hello/abdessettar", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals("Hello abdessettar",response.getBody());
    }

    @Test
    void testHello2() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/hello", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals("Hello",response.getBody());

    }

    @Test
    void testNotFound() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";

        Assertions.assertThrows(HttpClientErrorException.NotFound.class, () -> {

            restTemplate.getForEntity(url + "/notfound", String.class);});
    }

    @Test
    void testNoContent() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/nocontent", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void testHeaders() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/headers";
        HttpHeaders headers = new HttpHeaders();
        headers.add("myHeader", "myHeaderValue");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, String.class);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(headers, entity.getHeaders());
        ResponseEntity<String> request = restTemplate.exchange(url,HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }
}