package com.blogsite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogsite.model.BlogEntry;

@Controller
public class BlogController {
    private List<BlogEntry> entries = new ArrayList<BlogEntry>();

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("entries", entries);
        return "home";
    }

    @GetMapping("/add")
    public String showAddEntryForm() {
        return "add-entry";
    }

    @PostMapping("/add")
    public String addEntry(@RequestParam String title, @RequestParam String content, @RequestParam String author) {
        BlogEntry entry = new BlogEntry(title, content, author);
        entries.add(entry);
        return "redirect:/";
    }
}
