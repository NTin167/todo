package com.ptit.javaee;

import com.ptit.javaee.data.Todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TodoEJBImpl implements TodoEJB{
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Todo> findAll() {
        Query q = em.createQuery("SELECT t FROM Todo t");
        return q.getResultList();
    }

    @Override
    public void create(Todo todo) {
        em.persist(todo);
    }

    @Override
    public void update(Long id, Todo todo) {
        Todo entity = em.find(Todo.class, id);
        entity.setDescription(todo.getDescription());
        em.merge(entity);
    }

    @Override
    public void remove(Long id) {
        Todo entity = em.find(Todo.class, id);
        em.remove(entity);
    }
}
