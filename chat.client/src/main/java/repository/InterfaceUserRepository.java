package repository;

import model.User;

public interface InterfaceUserRepository {

    void addUser(User user);

    User getUser(Integer id);
}
