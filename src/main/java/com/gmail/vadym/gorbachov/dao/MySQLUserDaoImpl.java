package com.gmail.vadym.gorbachov.dao;

import com.gmail.vadym.gorbachov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("mySqlData")
public class MySQLUserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            return user;
        }
    }

    @Override
    public Collection<User> getAllUsers() {
      final String sql = "SELECT id, login, password, firstname,lastname from Users";
        Collection<User> users =  jdbcTemplate.query(sql, new UserRowMapper());
    return users;
    }

    @Override
    public User getUserById(int id) {
        final String sql = "SELECT id, login, password, firstname,lastname from Users where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return user;
    }

    @Override
    public void removeUserById(int id) {
        final String sql = "DELETE FROM users where id = ?";
    jdbcTemplate.update(sql, id);
    }



    @Override
    public void updateUser(User user) {
        final String sql = "UPDATE users set login = ?, password = ?, firstname = ?, lastname = ? where id = ?";
        int id = user.getId();
        String login = user.getLogin();
        String password = user.getPassword();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        jdbcTemplate.update(sql, new Object[] {login, password, firstname, lastname, id});
    }

    @Override
    public void insertUserToDb(User user) {
        final String sql = "INSERT INTO users (login, password, firstname, lastname) VALUES (?,?,?,?)";
        String login = user.getLogin();
        String password = user.getPassword();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        jdbcTemplate.update(sql, new Object[] {login, password, firstname, lastname});
    }
}

