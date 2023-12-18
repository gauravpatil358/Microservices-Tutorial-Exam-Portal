package com.quiz.services;

import com.quiz.entities.Quiz;
import java.util.List;

public interface QuizService {

    //Create
    Quiz add(Quiz quiz);

    //get
    Quiz getOne(Long id);

    //get ALl
    List<Quiz> getAll();

    //Delete
    void deleteById(Long id);

    //Update
    Quiz updateById(Quiz quiz,Long id);
}
