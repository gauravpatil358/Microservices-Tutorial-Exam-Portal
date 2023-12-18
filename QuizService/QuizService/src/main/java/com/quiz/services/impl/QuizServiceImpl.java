package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepo;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepo quizRepo;
    private QuestionClient questionClient;

    //Run Both the services to run the program

    public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
        this.quizRepo = quizRepo;
        this.questionClient = questionClient;
    }

    //Create
    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    //GetAll
    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepo.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuesOfQuizz(quiz.getId()));         //Set quizzes 1 by 1
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    //GetOne
    @Override
    public Quiz getOne(Long id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not Found"));
        quiz.setQuestions(questionClient.getQuesOfQuizz(quiz.getId()));
        return quiz;
    }

    //Delete
    @Override
    public void deleteById(Long id) {
        quizRepo.deleteById(id);
    }

    @Override
    public Quiz updateById(Quiz quiz, Long id) {                                                         //postman
        Quiz qz = quizRepo.findById(id)
                 .orElseThrow(()-> new RuntimeException("Sorry didn't get id of "+id));
             qz.setId(quiz.getId());
             qz.setTitle(quiz.getTitle());
        return quizRepo.save(qz);

    }


}
