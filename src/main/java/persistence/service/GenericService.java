package persistence.service;

import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

public class GenericService<T> implements Serializable {

    private GenericService<T> repository;

    private GenericService<T> getRepository() {
        return this.repository;
    }

    public void setRepository(final GenericService<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public void delete(final T object) {
        this.getRepository().delete(object);
    }

    @Transactional
    public void save(final T object) {
        this.getRepository().save(object);
    }

    @Transactional
    public void update(final T object) {
        this.getRepository().update(object);
    }

    @Transactional
    public T findById(Serializable id){
        return this.getRepository().findById(id);
    }

    @Transactional
    public void deleteAll(){
        this.getRepository().deleteAll();
    }

    @Transactional
    public T merge(final T object){
        return this.getRepository().merge(object);
    }
}
