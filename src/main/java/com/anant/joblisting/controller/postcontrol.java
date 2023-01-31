package com.anant.joblisting.controller;
import com.anant.joblisting.repository.searchrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.anant.joblisting.model.*;
import com.anant.joblisting.repository.postrepo;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController // this is for controlling our get post methods
public class postcontrol
{

    @Autowired
    postrepo pr; // this is used to do mapping in getall method

    @Autowired
    searchrepo sr;

    @ApiIgnore // this disables all the inbuild api functions ie. fetch get put patch  add etc
    @RequestMapping (value = "/")// this to do mapping with swagger api ie requesting server
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<post> getAll(){ // this method is used for fetching all posts
        return pr.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<post> getPost(@PathVariable String text){ // this path variable is for creating a path for our text keyword
        return sr.findByText(text);
    }

    @PostMapping("/post") // postMapping is for submitting and getMapping is for requesting
    public post addPost(@RequestBody post p){ // requestBody is for accepting data
        return pr.save(p); // this .save method just save it the new post in database as pr is mongorepository
    }


}
