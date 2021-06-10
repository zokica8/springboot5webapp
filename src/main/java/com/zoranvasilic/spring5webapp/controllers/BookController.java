package com.zoranvasilic.spring5webapp.controllers;

import com.zoranvasilic.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public ModelAndView getBooks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookRepository.findAll());

        return modelAndView;
    }
}
