package persistence.repositories;

import model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
        extends HibernateGenericDAO<User>
        implements GenericRepository<User> {


    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }
}
