package com.itgirls.psyhelper1.service.impl;

import com.itgirls.psyhelper1.dto.QuestionCreateDto;
import com.itgirls.psyhelper1.dto.QuestionDto;
import com.itgirls.psyhelper1.dto.QuestionUpdateDto;
import com.itgirls.psyhelper1.exception.NotFoundException;
import com.itgirls.psyhelper1.mappers.QuestionMapper;
import com.itgirls.psyhelper1.model.Question;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.repository.QuestionRepository;
import com.itgirls.psyhelper1.repository.UsersRepository;
import com.itgirls.psyhelper1.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    final QuestionRepository repository;
    final UsersRepository usersRepository;
    final QuestionMapper mapper;

    @Override
    public QuestionDto createQuestion(QuestionCreateDto dto) {
        log.info("Creating question: {}", dto);
        Users user = getUser(dto.getUserId());

        //TODO: добавить проверку на тему после реализации

        Question question = mapper.toEntity(dto);
        question.setUser(user);
        question.setIsClosed(false);
        Question savedQuestion = repository.save(question);
        log.info("Question created successfully id: {}", savedQuestion.getId());
        return mapper.toDto(savedQuestion);
    }

    @Override
    public QuestionDto updateQuestion(UUID id, QuestionUpdateDto dto) {
        log.info("Updating question: {}", dto);
        Optional<Question> questionOptional = repository.findById(id);
        if (questionOptional.isEmpty()){
            throw new NotFoundException("Question id: " + id + " not found");
        }
        Users user = getUser(dto.getUserId());

        //TODO: добавить проверку на тему после реализации

        Question question = questionOptional.get();
        question.setUser(user);
        question.setThemeId(dto.getThemeId());
        question.setIsAnonymous( dto.getIsAnonymous() );
        question.setIsJustExpertRespond(dto.getIsJustExpertRespond() );
        question.setQuestionText(dto.getQuestionText());
        question.setUpdatedAt(dto.getUpdatedAt());

        Question savedQuestion = repository.save(question);
        log.info("Question updated successfully id: {}", savedQuestion.getId());
        return mapper.toDto(savedQuestion);
    }

    @Override
    public void deleteQuestion(UUID id) {
        log.info("Deleting question: {}", id);
        Optional<Question> questionOptional = repository.findById(id);
        if (questionOptional.isPresent()){
            repository.deleteById(id);
            log.info("Question deleted successfully: {}", id);
        }
    }

    @Override
    public QuestionDto getQuestionById(UUID id) {
        log.info("Getting question: {}", id);
        Optional<Question> questionOptional = repository.findById(id);
        if (questionOptional.isEmpty()){
            log.info("Question id: {} not found", id);
            throw new NotFoundException("Question id: " + id + " not found");
        }
        Question question = questionOptional.get();
        log.info("Question found: {}", id);
        return mapper.toDto(question);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        log.info("Getting all questions");
        List<Question> questionList = repository.findAll();
        return questionList.stream().map(mapper::toDto).toList();
    }

    private Users getUser(UUID id) {
        log.info("Getting user: {}", id);
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isEmpty()) {
            log.info("User id: {} not found", id);
            throw new NotFoundException("User id: " + id + " not found");
        }
        Users user = usersOptional.get();
        log.info("User id: {} found", id);
        return user;
    }
}
