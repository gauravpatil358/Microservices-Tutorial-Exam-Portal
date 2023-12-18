package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    //Create
    Question create(Question question);

    //GetAll
    List <Question> getAll();

    //GetOne
    Question getOne(Long id);

    //Update
    Question updateQue(Question question,Long id);

    //Delete
    void delete(Long id);

    //All Question of Quiz
    List<Question> getQuestionsOfQuiz(Long quizId);

}
