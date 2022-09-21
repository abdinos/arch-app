package myboot.app4.web;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/list")
    public List<Integer> list() {
        return Arrays.asList(10, 20, 30);
    }
    @GetMapping("/hello/{message}")
    public String helloWithMessage(@PathVariable String message) {
        return "Hello " + message;
    }
    @GetMapping(value = "/hello2")
    public ResponseEntity<String> hello2() {
        return ResponseEntity.ok("Hello");
    }
    @GetMapping(value = "/notfound")
    public ResponseEntity<String> notFound() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>(responseHeaders, HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/nocontent")
    public ResponseEntity<String> noContent() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Error204",responseHeaders, HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/headers")
    public ResponseEntity<String> headers(@RequestHeader String myHeader) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("resultHeader", myHeader.toUpperCase());
        var res = ResponseEntity.ok()//
                .headers(responseHeaders)//
                .header("xx", "yy")//
                .body("HEADER " + myHeader);
        return res;

    }

}