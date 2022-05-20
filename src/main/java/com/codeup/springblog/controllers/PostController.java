package com.codeup.springblog.controllers;

import com.codeup.springblog.models.*;
import com.codeup.springblog.repositories.*;
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
    private final TagRepository tagDao;

    // CON
    public PostController(PostRepository postDao, PostDetailsRepository postDetailsDao, PostImagesRepository postImagesDao, UserRepository userDao, TagRepository tagDao) {
        this.postDao = postDao;
        this.postDetailsDao = postDetailsDao;
        this.postImagesDao = postImagesDao;
        this.userDao = userDao;
        this.tagDao = tagDao;
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
    public String createPostPage(Model model){

        List<Tag> tags = tagDao.findAll();

        model.addAttribute("tags", tags);

        return "posts/create";
    }

    @PostMapping("/create")
    public String addPost(@RequestParam(name="title") String title,
                          @RequestParam(name="body") String body,
                          @RequestParam(name="history-of-post") String historyOfPost,
                          @RequestParam(name="topic-description") String topicDescription,
                          @RequestParam(name="is-awesome", defaultValue = "False") Boolean isAwesome,
                          @RequestParam(name="image-title") String imageTitle,
                          @RequestParam(name="tags-id") String tagsID,
                          @RequestParam(name="url") String url ) {

//        System.out.println("is Awesome returns:" + isAwesome);              // Needs Fixing
//        System.out.println("tagsID = " + tagsID);                           // Check type of input

        // Break String into a String Array(List)
        List<String> tagsIdStringList = List.of(tagsID.split(","));
        System.out.println("tagsIdStringList = " + tagsIdStringList);

        // Create Tags List
        List<Tag> tags = new ArrayList<>();

        // Include form's tags into Tags List
        for (int i = 0; i < tagsIdStringList.size(); i++) {
            Tag tag = tagDao.getById(Long.valueOf(tagsIdStringList.get(i)));
            tags.add(tag);
        }

        // Add user to all posts (for now)
        Long id = Long.valueOf(1);
        User user = userDao.getById(id);

        // Set and save pd first
        PostDetails postDetails = new PostDetails(isAwesome, historyOfPost, topicDescription);
        postDetailsDao.save(postDetails);

        // Set and save p with pd
        Post post = new Post(title, body, postDetails, user, tags);
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

    @PostMapping("add-image")
    public String addImageToSinglePost(@RequestParam(name="image-title") String imageTitle,
                                       @RequestParam(name="url") String url,
                                       @RequestParam(name="post-id") String postId,
                                       Model model){

        long id = Long.parseLong(postId);
        System.out.println("id = " + id);

        // Create, save, place in obj var?!
        PostImage postImage = postImagesDao.save(new PostImage(imageTitle, url));

        // Call post obj and place in obj var... then get its list of img
        Post post = postDao.getById(id);
        List<PostImage> postImages = post.getPostImages();

        // Place img in list
        postImages.add(postImage);

        // place list in post
        post.setPostImages(postImages);

        // save post with new list of img
        postDao.save(post);

        model.addAttribute(post);

        return "redirect:/posts/show";
    }



}  //<--END
