package org.example.repository;

import org.example.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Stub
public class PostRepository {
    private final Map<Long, Post> posts;
    public PostRepository() {
        this.posts = new ConcurrentHashMap<>();;
    }
    public List<Post> all() {
        return Collections.unmodifiableList(new ArrayList<>(posts.values()));
    }

    public Optional<Post> getById(long id) {
        Post post = posts.get(id);
        return Optional.ofNullable(post);
    }

    public Post save(Post post) {
        String POST_CAN_NOT_BE_NULL = "Post cannot be null";
        Objects.requireNonNull(post, POST_CAN_NOT_BE_NULL);
        posts.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}