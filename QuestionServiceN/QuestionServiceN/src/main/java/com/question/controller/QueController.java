package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QueController {

    private QuestionService questionService;

    public QueController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public Question createQue(@RequestBody Question question){
        return questionService.create(question);
    }

    //get
    @GetMapping("/{queId}")
    public Question getOneQue(@PathVariable Long queId){
        return questionService.getOne(queId);
    }
    //GetAll
    @GetMapping
    public List<Question> getAllQues(){
        return questionService.getAll();
    }

    //update
    @PutMapping("/updt/{qId}")
    public Question updateQuess(@RequestBody Question question,@PathVariable Long qId){
        return questionService.updateQue(question,qId);
    }
    //Delete
    @DeleteMapping("/del/{qID}")
    public String deleteQu(@PathVariable Long qID){
        questionService.delete(qID);
        return "Deleted Successfully";
    }

    //get All questions of Specific Quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuesOfQuizz(@PathVariable Long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
