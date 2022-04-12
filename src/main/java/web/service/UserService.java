package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public void delete(int id);
    public void update(User updatedUser);
    public void save(User user);
    public User show(int id);
    public List<User> index();
}
