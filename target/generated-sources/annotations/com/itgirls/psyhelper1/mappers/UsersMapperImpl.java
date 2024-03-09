package com.itgirls.psyhelper1.mappers;

import com.itgirls.psyhelper1.dto.UsersDto;
import com.itgirls.psyhelper1.dto.UsersDto.UsersDtoBuilder;
import com.itgirls.psyhelper1.dto.UsersRegistrationDto;
import com.itgirls.psyhelper1.model.Users;
import com.itgirls.psyhelper1.model.Users.UsersBuilder;
import com.itgirls.psyhelper1.model.UsersRole;
import com.itgirls.psyhelper1.model.UsersRole.UsersRoleBuilder;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T13:32:08+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UsersDtoBuilder usersDto = UsersDto.builder();

        usersDto.usersRoleId( usersUsersRoleId( users ) );
        usersDto.id( users.getId() );
        usersDto.username( users.getUsername() );
        usersDto.email( users.getEmail() );
        usersDto.phone( users.getPhone() );
        usersDto.dateOfBirth( users.getDateOfBirth() );
        usersDto.city( users.getCity() );
        usersDto.aboutUser( users.getAboutUser() );
        usersDto.photoLink( users.getPhotoLink() );

        return usersDto.build();
    }

    @Override
    public Users toEntity(UsersDto usersDto) {
        if ( usersDto == null ) {
            return null;
        }

        UsersBuilder users = Users.builder();

        users.id( usersDto.getId() );
        users.username( usersDto.getUsername() );
        users.email( usersDto.getEmail() );
        users.phone( usersDto.getPhone() );
        users.dateOfBirth( usersDto.getDateOfBirth() );
        users.city( usersDto.getCity() );
        users.aboutUser( usersDto.getAboutUser() );
        users.photoLink( usersDto.getPhotoLink() );

        return users.build();
    }

    @Override
    public Users toEntity(UsersRegistrationDto usersRegistrationDto) {
        if ( usersRegistrationDto == null ) {
            return null;
        }

        UsersBuilder users = Users.builder();

        users.usersRole( usersRegistrationDtoToUsersRole( usersRegistrationDto ) );
        users.username( usersRegistrationDto.getUsername() );
        users.email( usersRegistrationDto.getEmail() );
        users.phone( usersRegistrationDto.getPhone() );
        users.password( usersRegistrationDto.getPassword() );
        users.dateOfBirth( usersRegistrationDto.getDateOfBirth() );
        users.city( usersRegistrationDto.getCity() );
        users.aboutUser( usersRegistrationDto.getAboutUser() );
        users.photoLink( usersRegistrationDto.getPhotoLink() );

        return users.build();
    }

    private UUID usersUsersRoleId(Users users) {
        if ( users == null ) {
            return null;
        }
        UsersRole usersRole = users.getUsersRole();
        if ( usersRole == null ) {
            return null;
        }
        UUID id = usersRole.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UsersRole usersRegistrationDtoToUsersRole(UsersRegistrationDto usersRegistrationDto) {
        if ( usersRegistrationDto == null ) {
            return null;
        }

        UsersRoleBuilder usersRole = UsersRole.builder();

        usersRole.id( usersRegistrationDto.getUsersRoleId() );

        return usersRole.build();
    }
}
