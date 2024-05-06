package com.examExamQuestions.controller;

import com.examExamQuestions.Question;
import com.examExamQuestions.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;


    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.addQuestion(new Question(question, answer));
        return ResponseEntity.ok("Question added");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.removeQuestion(new Question(question, answer));
        return ResponseEntity.ok("Question removed");
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
}
