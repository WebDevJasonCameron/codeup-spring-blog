package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostDetails;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostDetailsRepository;
import com.codeup.springblog.repositories.PostImagesRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
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
    private final PostImagesRepository postImagesDao;
    private final UserRepository userDao;

    // CON
    public PostController(PostRepository postDao, PostDetailsRepository postDetailsDao, PostImagesRepository postImagesDao, UserRepository userDao) {
        this.postDao = postDao;
        this.postDetailsDao = postDetailsDao;
        this.postImagesDao = postImagesDao;
        this.userDao = userDao;
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

        // Choice Logic
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
                          @RequestParam(name="is-awesome", defaultValue = "False") Boolean isAwesome,
                          @RequestParam(name="image-title") String imageTitle,
                          @RequestParam(name="url") String url ) {

//        System.out.println("is Awesome returns:" + isAwesome);

        // Add user to all posts (for now)
        Long id = Long.valueOf(1);
        User user = userDao.getById(id);

        // Set and save pd first
        PostDetails postDetails = new PostDetails(isAwesome, historyOfPost, topicDescription);
        postDetailsDao.save(postDetails);

        // Set and save p with pd
        Post post = new Post(title, body, postDetails, user);
        postDao.save(post);

        // Save pi with p
        PostImage postImage = new PostImage(imageTitle, url, post);

        // Create array
        List<PostImage> postImages = new ArrayList<>();
        postImages.add(postImage);

        // Set the pi(s) to created post
        post.setPostImages(postImages);

        // re-save post (to update with pi(s))
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
