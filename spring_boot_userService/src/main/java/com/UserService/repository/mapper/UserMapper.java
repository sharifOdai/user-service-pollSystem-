package com.UserService.repository.mapper;
import com.UserService.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
@Component


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long userId = rs.getLong("user_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        Integer age = rs.getInt("age");
        String address = rs.getString("address");
        Boolean status = rs.getBoolean("status");
        LocalDate joiningDate = (rs.getDate("joining_date") != null) ? rs.getDate("joining_date").toLocalDate() : null;

        User user = new User(userId, firstName, lastName, email, age, address, status, joiningDate);
        return user;
    }



}