package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
   private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //Create
    @PostMapping
    public Quiz createC(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    //GetAll
    @GetMapping
    public List<Quiz> getAllC(Quiz quiz){
        return quizService.getAll();
    }

    //GetOne
    @GetMapping("/{id}")
    public Quiz getOneC(@PathVariable Long id){
        return quizService.getOne(id);
    }

    @PutMapping("/up/{id}")
    public Quiz updateQuiz(@RequestBody Quiz quiz,@PathVariable Long id){
        return  quizService.updateById(quiz, id);
    }


    @DeleteMapping("/del/{id}")
    public String  deleteQuiz(@PathVariable Long id){
         quizService.deleteById(id);
         return "Deleted Successfully";
    }

//    @DeleteMapping("/del/{id}")
//    public void deleteById(@PathVariable Long id){
//        quizService.deleteById(id);
//    }
}
