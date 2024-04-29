package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.answerDto.AnswerDto;
import com.itgirls.psyhelper1.dto.answerDto.AnswerDto.AnswerDtoBuilder;
import com.itgirls.psyhelper1.model.Answer;
import com.itgirls.psyhelper1.model.Answer.AnswerBuilder;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.model.Users.UsersBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T15:23:44+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer toEntity(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        AnswerBuilder answer = Answer.builder();

        answer.userId( answerDtoToUsers( answerDto ) );
        answer.id( answerDto.getId() );
        answer.questionId( answerDto.getQuestionId() );
        answer.createdAt( answerDto.getCreatedAt() );
        answer.updatedAt( answerDto.getUpdatedAt() );
        answer.rating( answerDto.getRating() );
        answer.answerText( answerDto.getAnswerText() );

        return answer.build();
    }

    @Override
    public AnswerDto toDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDtoBuilder answerDto = AnswerDto.builder();

        answerDto.userId( map( answerUserIdId( answer ) ) );
        answerDto.id( answer.getId() );
        answerDto.questionId( answer.getQuestionId() );
        answerDto.createdAt( answer.getCreatedAt() );
        answerDto.updatedAt( answer.getUpdatedAt() );
        answerDto.rating( answer.getRating() );
        answerDto.answerText( answer.getAnswerText() );

        return answerDto.build();
    }

    protected Users answerDtoToUsers(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        UsersBuilder users = Users.builder();

        users.id( map( answerDto.getUserId() ) );

        return users.build();
    }

    private UUID answerUserIdId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Users userId = answer.getUserId();
        if ( userId == null ) {
            return null;
        }
        UUID id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
