package myboot.app4.test;

import myboot.app1.model.Movie;
import myboot.app4.model.MovieDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieDTOTest {

    MovieDTO movieDTO;
    Movie movie = new Movie("1",2022,"SSSSS");

    @Test
    public void dtoTest(){
        ModelMapper modelMapper = new ModelMapper();
       movieDTO = modelMapper.map(movie, MovieDTO.class);
        assertEquals(movie.getName(), movieDTO.getName());
        assertEquals(movie.getYear(), movieDTO.getYear());
        assertEquals(movie.getDescription(), movieDTO.getDescription());
    }
}
