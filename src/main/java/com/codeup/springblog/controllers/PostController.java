package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostDetails;
import com.codeup.springblog.repositories.PostDetailsRepository;
import com.codeup.springblog.repositories.PostRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    // ATT
    private final PostRepository postDao;
    private final PostDetailsRepository postDetailsDao;

    // CON
    public PostController(PostRepository postDao, PostDetailsRepository postDetailsDao) {
        this.postDao = postDao;
        this.postDetailsDao = postDetailsDao;
    }

    // METHS
    @GetMapping
    public String postWork(){
        return "posts/index";
    }

    @GetMapping("/{userChoice}")
    public String showSingleOrAllPosts(@PathVariable String userChoice, Model model){
        List<Post> posts = postDao.findAll();
        Post post = posts.get(posts.size() -1);

        if(userChoice.equals("single")){
            model.addAttribute("post", post);
        } else if (userChoice.equals("all")){
            model.addAttribute("posts", posts);
        }

        model.addAttribute("userChoice", userChoice);
        model.addAttribute("post", post);
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/create")
    public String createPostPage(){
        return "posts/create";
    }

    @PostMapping("/create")
    public String addPost(@RequestParam(name="title") String title,
                          @RequestParam(name="body") String body,
                          @RequestParam(name="history-of-post") String historyOfPost,
                          @RequestParam(name="topic-description") String topicDescription,
                          @RequestParam(name="is-awesome", defaultValue = "False") Boolean isAwesome ) {

        System.out.println("is Awesome returns:" + isAwesome);

        PostDetails postDetails = new PostDetails(isAwesome, historyOfPost, topicDescription);
        postDetailsDao.save(postDetails);

        Post post = new Post(title, body, postDetails);
        postDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable String id){
        long postId = Long.parseLong(id);
        postDao.deleteById(postId);
        return "redirect:/posts";
    }


    @GetMapping("/edit/{id}")
    public String editPostPage(@PathVariable String id, Model model){
        Long postId = Long.parseLong(id);
        Post post = postDao.getById(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/edit")
    public String updatePost(@RequestParam(name="original-id") String originalId,
                             @RequestParam(name="original-title") String originalTitle,
                             @RequestParam(name="original-body") String originalBody,
                             @RequestParam(name="edited-title") String editedTitle,
                             @RequestParam(name="edited-body") String editedBody){
        String finalTitle;
        String finalBody;
        Long id = Long.parseLong(originalId);

        if (editedTitle != ""){
            finalTitle = editedTitle;
        } else {
            finalTitle = originalTitle;
        }

        if (editedBody != "null"){
            finalBody = editedBody;
        } else {
            finalBody = originalBody;
        }

        System.out.println("Body: "+finalBody);
        System.out.println("title: "+finalTitle);
        System.out.println("id: "+ id);

        Post finalPost = new Post(finalTitle, finalBody);

        postDao.save(finalPost);

        return "redirect:/posts";
    }





}  //<--END
