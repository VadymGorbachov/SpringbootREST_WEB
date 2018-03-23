package com.gmail.vadym.gorbachov.dao;

import com.gmail.vadym.gorbachov.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository //@Component
@Qualifier("fakeData")
public class FakeUserDaoImpl implements UserDao {
    private static Map<Integer, User> users;
    static {
        users = new HashMap<Integer, User>(){
            {
                put(1,new User(1,"Login","Password","FirstName","LastName"));
                put(2,new User(2,"Login2","Password2","FirstName2","LastName2"));
                put(3,new User(3,"Login3","Password3","FirstName3","LastName3"));
                put(4,new User(4,"Login4","Password4","FirstName4","LastName4"));
                put(5,new User(5,"Login5","Password5","FirstName5","LastName5"));
            }
        };
    }
@Override
public Collection<User> getAllUsers(){
        return this.users.values();
}
@Override
public User getUserById(int id){
        return this.users.get(id);
}
@Override
public void removeUserById(int id){
        this.users.remove(id);
}
@Override
public void updateUser(User user){
     User u = users.get(user.getId());
     u.setLogin(user.getLogin());
     u.setPassword(u.getPassword());
     u.setFirstname(u.getFirstname());
     u.setLastname(u.getLastname());
     users.put(user.getId(),user);
}

    @Override
    public void insertUserToDb(User user) {
        this.users.put(user.getId(),user);
    }
}
