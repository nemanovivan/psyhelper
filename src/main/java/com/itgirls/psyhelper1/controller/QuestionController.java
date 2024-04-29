package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.QuestionCreateDto;
import com.itgirls.psyhelper1.dto.QuestionDto;
import com.itgirls.psyhelper1.dto.QuestionUpdateDto;
import com.itgirls.psyhelper1.exception.NotFoundException;
import com.itgirls.psyhelper1.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    final QuestionService service;

    @PostMapping
    ResponseEntity createQuestion(@RequestBody @Valid QuestionCreateDto dto) {
        try {
            return ResponseEntity.ok(service.createQuestion(dto));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    ResponseEntity updateQuestion(@PathVariable("id") UUID id, @RequestBody @Valid QuestionUpdateDto dto) {
        try {
            return ResponseEntity.ok(service.updateQuestion(id, dto));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    void deleteQuestion(@PathVariable("id") UUID id) {
        service.deleteQuestion(id);
    }

    @GetMapping("/{id}")
    ResponseEntity getQuestionById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(service.getQuestionById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    List<QuestionDto> getAllQuestions() {
        return service.getAllQuestions();
    }
}
