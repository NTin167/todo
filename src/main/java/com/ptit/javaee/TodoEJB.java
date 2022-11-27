package com.ptit.javaee;

import com.ptit.javaee.data.Todo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TodoEJB {
    List<Todo> findAll();
    void create(Todo todo);
    void update(Long id, Todo todo);
    void remove(Long id);
}
