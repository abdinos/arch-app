package myboot.app2.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myboot.app2.model.Counter;

@Service
@Transactional
public class CounterManager {

    @PersistenceContext
    EntityManager em;

    public Counter getCounter(String name) {
        return em.find(Counter.class, name);
    }

    public void removeCounter(String name) {
        Counter c = em.find(Counter.class, name);
        if (c != null) {
            em.remove(c);
        }
    }

    public void createCounter(String name, Integer value) {
        removeCounter(name);
        Counter c = new Counter();
        c.setName(name);
        c.setValue(value);
        em.persist(c);
    }

}