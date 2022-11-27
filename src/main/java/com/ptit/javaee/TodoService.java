package com.ptit.javaee;

import com.ptit.javaee.data.Todo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class TodoService {
    @Inject
    TodoEJB ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAll() {
        return ejb.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Todo todo) {
        ejb.create(todo);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Todo todo) {
        ejb.update(id, todo);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        ejb.remove(id);
    }
}