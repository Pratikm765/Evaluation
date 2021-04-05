package com.project.pavani.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ayush.pandey
 */

@RestController
@RequestMapping("/api")
public class HelloController {

@GetMapping("/getHello")
public String getHello()
{
    return "Hibernate version :   " + org.hibernate.Version.getVersionString();
}

}
