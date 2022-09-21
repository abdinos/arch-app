

package myboot.app2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import myboot.app2.model.Counter;
import myboot.app2.services.CounterManager;

@SpringBootTest
public class TestCounterManager {

    @Autowired
    public CounterManager cm;

    @Test
    public void testCounterManager() {
        cm.createCounter("C1", 10);
        Counter c = cm.getCounter("C1");
        assertEquals(Integer.valueOf(10), c.getValue());
    }

}