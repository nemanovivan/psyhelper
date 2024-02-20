package com.itgirls.psyhelper1.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperBean {
    @Bean
    public UsersMapper usersMapper() {return Mappers.getMapper(UsersMapper.class);}
}
