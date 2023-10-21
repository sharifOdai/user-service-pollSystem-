package com.UserService.repository;

import com.UserService.model.User;
import com.UserService.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user_table";
    private static final String USER_ANSWER_TABLE = "user_answer_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public Long createUser(User user) {


        String sql = "INSERT INTO " + USER_TABLE_NAME +
                " (first_name, last_name, email, age, address ) values (?,?,?,?,?)";

        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress()

        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, age=?, address=?  WHERE user_id=?";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getId()
        );
    }

    @Override
    public void deleteUserById(Long id) {
        String deleteAnswersSql = "DELETE " + USER_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(deleteAnswersSql, id);
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE user_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
    }

    @Override
    public User registerUser(Long userId) {
        User existingUser = getUserById(userId);
        if (existingUser != null){
            String sql = "UPDATE " + USER_TABLE_NAME + " SET status=?, joining_date=? WHERE user_id=?";
            jdbcTemplate.update(
                    sql,
                    true,
                    LocalDate.now(),
                    userId
            );
        }
        return existingUser;
    }
}
