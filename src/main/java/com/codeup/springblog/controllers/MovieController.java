package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Movie;
import com.codeup.springblog.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {


    private MovieRepository movieDao;


    public MovieController(MovieRepository movieDao) {
        this.movieDao = movieDao;
    }

    // Read
    @GetMapping
    public String showMovies(Model model) {

        model.addAttribute("movies",movieDao.findAll());
        return "movies/index";
    }

    // Create
    @GetMapping("/create")
    public String createMovie(Model model) {
        // TODO: Complete this
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }


    @PostMapping("/create")
    public String doCreateMovie(
            @ModelAttribute Movie movie
    ) {
        // TODO: Complete this

        movieDao.save(movie);
        return "movies/index";
    }


    // Update
    @GetMapping("/update/{id}")
    public String updateMovie(
            @PathVariable long id,
            Model model) {

        model.addAttribute("movie", movieDao.getById(id));

        // TODO: Populate a form like the Create form, such that
        // it will allow you to update an existing movie.
        return "movies/create";
    }

    @PostMapping("/update")
    public String doUpdateMovie(
            @ModelAttribute Movie movie
    ) {

        movieDao.save(movie);

        return "redirect:/movies";
    }


    // Delete
    @PostMapping("/delete")
    public String deleteMovie(
            @RequestParam(name="id") long id
    ) {
        // TODO: Add button to the movies index page that will delete the items
        // TODO: button should be in a form, value will be the id of the item.
        // TODO: Send the user back to to the main page.

        movieDao.deleteById(id);

        return "redirect:/movies";
    }


}