package com.snipper.controller;
import com.snipper.model.Snippet;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SnippetController {

    // Simulating the data
    private final List<Snippet> snippets = Arrays.asList(
            new Snippet(1, "Python", "print('Hello, World!')"),
            new Snippet(2, "Python", "def add(a, b):\n    return a + b"),
            new Snippet(3, "Python", "class Circle:\n    def __init__(self, radius):\n        self.radius = radius\n\n    def area(self):\n        return 3.14 * self.radius ** 2"),
            new Snippet(4, "JavaScript", "console.log('Hello, World!');"),
            new Snippet(5, "JavaScript", "function multiply(a, b) {\n    return a * b;\n}"),
            new Snippet(6, "JavaScript", "const square = num => num * num;"),
            new Snippet(7, "Java", "public class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, World!\");\n    }\n}"),
            new Snippet(8, "Java", "public class Rectangle {\n    private int width;\n    private int height;\n\n    public Rectangle(int width, int height) {\n        this.width = width;\n        this.height = height;\n    }\n\n    public int getArea() {\n        return width * height;\n    }\n}")
    );

    @GetMapping("/snippets")
    public List<Snippet> getAllSnippets() {
        return snippets;
    }

    @GetMapping("/snippets/{id}")
    public Snippet getSnippetById(@PathVariable int id) {
        Optional<Snippet> snippet = snippets.stream()
                .filter(s -> s.getId() == id)
                .findFirst();

        return snippet.orElse(null);
    }

    @PostMapping("/snippets")
    public String createSnippet(@RequestBody Snippet newSnippet) {

        Optional<Snippet> existingSnippet = snippets.stream()
                .filter(s -> s.getId() == newSnippet.getId())
                .findFirst();

        if (existingSnippet.isPresent()) {
            return "Snippet with the same ID already exists.";
        }

        snippets.add(newSnippet);
        return "Snippet created successfully.";
    }



}