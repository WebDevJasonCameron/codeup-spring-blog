package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
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

    // CON
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
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
                          @RequestParam(name="body") String body){
        Post post = new Post(title, body);

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




//    @GetMapping("{id}")
//    public String postById(@PathVariable long id){
//        return "here is the post " + id ;
//    }
//
//    @GetMapping("/create")
//    public String createPost(){
//        return "you just created a post";
//    }
//
//    @PostMapping("/create")
//    public String submitPost(){
//        return "you just created a post";
//    }
//
//    Post post1 = new Post("2022/05/15, It takes Three to Pair Program", "Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?\n" +
//            "\n");
//
//    Post post2 = new Post("2022/05/10, Have You Seen my Programmer?", "Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?\n" +
//            "\n");
//
//    List<Post> allPosts = Arrays.asList(post1, post2);



}  //<--END
