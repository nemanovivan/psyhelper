package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.AnswerCreateDto;
import com.itgirls.psyhelper1.dto.AnswerDto;
import com.itgirls.psyhelper1.dto.AnswerUpdateDto;
import com.itgirls.psyhelper1.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer_to_question")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    ResponseEntity createAnswer(@RequestBody @Valid AnswerCreateDto createDto) {
        try {
            return ResponseEntity.ok(answerService.createAnswer(createDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    ResponseEntity updateAnswer(@PathVariable("id") UUID id, @RequestBody @Valid AnswerUpdateDto updateDto) {
        try {
            return ResponseEntity.ok(answerService.updateAnswer(id, updateDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    void deleteAnswer(@PathVariable("id") UUID id) {
        answerService.deleteAnswer(id);
    }

    @GetMapping
    List<AnswerDto> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping
    AnswerDto getAnswerById(@PathVariable("id") UUID id) {
        return answerService.getAnswerById(id);
    }

    @GetMapping
    List<AnswerDto> getAnswersByUserId(@PathVariable("id") UUID id) {
        return answerService.getAnswersByUserId(id);
    }

    @GetMapping
    List<AnswerDto> getAnswersByQuestionId(@PathVariable("id") UUID id) {
        return answerService.getAnswersByQuestionId(id);
    }
}
