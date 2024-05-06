package com.examExamQuestions.service;

import com.examExamQuestions.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
