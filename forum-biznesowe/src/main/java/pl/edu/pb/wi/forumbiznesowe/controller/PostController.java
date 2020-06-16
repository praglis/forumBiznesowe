package pl.edu.pb.wi.forumbiznesowe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pb.wi.forumbiznesowe.dao.entity.Post;
import pl.edu.pb.wi.forumbiznesowe.services.PostService;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public Iterable<Post> getAll(){
        return postService.findAll();
    }

    @GetMapping
    public Optional<Post> getPost(@RequestParam Long id){
        return postService.find(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        postService.add(post);
    }

    @PutMapping
    public void updatePost(@RequestBody Post post){
        postService.update(post);
    }

    @DeleteMapping
    public void deletePost(@RequestParam Long id){
        postService.delete(id);
    }

    @GetMapping("/category")
    public Iterable<Post> getPostsByCategory(@RequestParam Long id){
        return postService.getPostsByCategory(id);
    }

}
