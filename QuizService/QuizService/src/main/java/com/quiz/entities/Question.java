package com.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {

    private Long questionId;
    private String question;
    private Long quizId;

    //Copy And paste all the fields from Question entity of QuestionService and remove table related annotation
}
