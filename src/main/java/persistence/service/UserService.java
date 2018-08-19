package persistence.service;

import persistence.repositories.UserRepository;

public class UserService {

    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
