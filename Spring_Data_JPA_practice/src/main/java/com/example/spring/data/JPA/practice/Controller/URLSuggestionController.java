package com.example.spring.data.JPA.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class URLSuggestionController {

    private final List<String> url = List.of(
            "/api/courses",
            "/api/courses/{id}",
            "/api/courses/native",
            "/api/students/all",
            "/api/students/{id}",
            "/api/students/assigncourse/{id}/{cid}",
            "/api/students/search?firstname=\"\"",
            "/api/coursematerial",
            "/api/teacher",
            "/api/teacher/{id}",
            "/api/teacher/update"
    );

    @GetMapping("api/help")
    public List<String> suggestAvailableUrl(@RequestParam String prefix)
    {
        return url.stream()
                .filter(url->url.startsWith("/api/"+prefix))
                .collect(Collectors.toList());
    }
}
