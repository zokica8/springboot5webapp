package com.zoranvasilic.spring5webapp.controllers;

import com.zoranvasilic.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public ModelAndView getAuthors() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authors", authorRepository.findAll());

        return modelAndView;
    }
}
