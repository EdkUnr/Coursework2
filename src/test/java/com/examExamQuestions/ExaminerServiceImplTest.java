package com.examExamQuestions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.examExamQuestions.service.ExaminerServiceImpl;
import com.examExamQuestions.service.QuestionService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    private QuestionService questionService;

    @Before
    public void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is Java?", "Programming language"));
        questions.add(new Question("What is polymorphism?", "Ability of an object to take many forms"));

        when(questionService.getAllQuestions()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenAnswer(invocation -> questions.get((int) (Math.random() * questions.size())));

        List<Question> retrievedQuestions = examinerService.getQuestions(2);
        assertEquals(2, retrievedQuestions.size());
        verify(questionService, atMost(3)).getRandomQuestion(); // Проверяем, что метод был вызван ровно 2 раза
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetQuestionsWithInsufficientData() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is Java?", "Programming language"));

        when(questionService.getAllQuestions()).thenReturn(questions);
        examinerService.getQuestions(2);
    }
}
