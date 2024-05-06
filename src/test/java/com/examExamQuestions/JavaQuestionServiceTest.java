package com.examExamQuestions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.examExamQuestions.service.JavaQuestionService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @Before
    public void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question("What is Java?", "Programming language");
        service.addQuestion(question);
        assertEquals(1, service.getAllQuestions().size());
        assertEquals(question, service.getAllQuestions().get(0));
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question("What is Java?", "Programming language");
        service.addQuestion(question);
        service.removeQuestion(question);
        assertTrue(service.getAllQuestions().isEmpty());
    }

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question("What is Java?", "Programming language");
        Question question2 = new Question("What is an interface?", "A contract for classes");
        service.addQuestion(question1);
        service.addQuestion(question2);
        assertNotNull(service.getRandomQuestion());
    }
}
