package com.example.java3566project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addCourse(@RequestParam String courseName,
                                          @RequestParam String courseNumber,
                                          @RequestParam Integer capacity) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return "Course Saved";
    }

    @GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
