package com.examExamQuestions.service;

import com.examExamQuestions.Question;

import java.util.List;

public interface QuestionService {
    Question getRandomQuestion();

    void addQuestion(Question question);

    void removeQuestion(Question question);

    List<Question> getAllQuestions();
}
