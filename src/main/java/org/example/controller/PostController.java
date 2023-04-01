package org.example.controller;

import com.google.gson.Gson;
import org.example.model.Post;
import org.example.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;
    private Gson gson;

    public PostController(PostService service, Gson gson) {
        this.service = service;
        this.gson = new Gson();
    }

    public PostController(PostService service) {
        this.service = service;
    }

    public void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        response.getWriter().print(gson.toJson(service.all()));
    }

    public void getById(long id, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        response.getWriter().print(gson.toJson(service.getById(id)));
    }

    public void save(Reader body, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var post = gson.fromJson(body, Post.class);
        final var data = service.save(post);
        response.getWriter().print(gson.toJson(data));
    }

    public void removeById(long id, HttpServletResponse response) {
        response.setContentType(APPLICATION_JSON);
        service.removeById(id);
    }
}