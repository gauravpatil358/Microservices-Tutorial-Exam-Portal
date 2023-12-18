package com.question.services.Impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepo;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public QuestionImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question NOT Found"));
    }

    @Override
    public Question updateQue(Question question, Long id) {
        Question que = questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question with this id not found"));
        que.setQuestion(question.getQuestion());
        que.setQuizId(question.getQuizId());
        return questionRepo.save(que);
    }

    @Override
    public void delete(Long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
