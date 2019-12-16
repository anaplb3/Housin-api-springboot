package com.dcx.pas.housinapi;

import com.dcx.pas.housinapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private List<User> users;

    public List<User> getUsers() {
        return this.users;
    }

    public User getUser(int id) {
        return findUser(id);
    }

    public boolean createUser(User user ) {
        if(findUser(user.getId()) == null) {
            return false;
        } else this.users.add(user); return true;

    }

    public boolean deleteUser(int id) {
        try {
            this.users.remove(findUser(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(User u) {
        User userOld = findUser(u.getId());
        this.users.remove(userOld);
        this.users.add(u);
        return true;
    }

    private User findUser(int id) {
        for(User u : this.users) {
            if(u.getId() == id) {
                return u;
            }
        }

        return null;
    }

}
