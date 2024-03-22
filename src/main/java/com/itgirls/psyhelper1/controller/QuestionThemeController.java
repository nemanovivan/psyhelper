package com.itgirls.psyhelper1.controller;

import com.itgirls.psyhelper1.dto.QuestionThemeDTO;
import com.itgirls.psyhelper1.service.QuestionThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/questions")
public class QuestionThemeController {
    private final QuestionThemeService questionThemeService;

    @PostMapping
    public ResponseEntity<QuestionThemeDTO> createQuestionTheme(@RequestBody QuestionThemeDTO questionThemeDTO) {
        QuestionThemeDTO savedTheme = questionThemeService.saveTheme(questionThemeDTO);
        return new ResponseEntity<>(savedTheme, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionThemeDTO> getQuestionThemeById(@PathVariable UUID id) {
        return questionThemeService.getInfoById(id)
                .map(theme -> new ResponseEntity<>(theme, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/id")
    public ResponseEntity<QuestionThemeDTO> updateQuestionTheme(@PathVariable UUID id, @RequestBody QuestionThemeDTO questionThemeDTO) {
        questionThemeDTO.setId(id);
        QuestionThemeDTO updateQuestion = questionThemeService.saveTheme(questionThemeDTO);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);

    }
@DeleteMapping("/{id}")
    public ResponseEntity<QuestionThemeDTO> deleteQuestionTheme(@PathVariable UUID id) {
    questionThemeService.deleteThemeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
