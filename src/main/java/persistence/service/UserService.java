package persistence.service;

import model.User;
import persistence.repositories.UserRepository;

public class UserService extends GenericService<User>{

    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
