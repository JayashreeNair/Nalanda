package com.freezone.nalanda.infrastructure.persistence.jpaadaptor;

import com.freezone.nalanda.domain.model.User;
import com.freezone.nalanda.domain.ports.data.PersistenceOperations;
import com.freezone.nalanda.infrastructure.persistence.UserRepository;
import com.freezone.nalanda.infrastructure.persistence.transformers.DomainModelToInfrastructureModelTransformer;
import com.freezone.nalanda.infrastructure.persistence.transformers.InfrastructureModelToDomainModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H2UserRepository implements PersistenceOperations<User> {
    private UserRepository repository;

    @Autowired
    public H2UserRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public User save(User user) {
        com.freezone.nalanda.infrastructure.model.User entityUser = DomainModelToInfrastructureModelTransformer
                .transform.apply(user);

        com.freezone.nalanda.infrastructure.model.User savedEntity = this.repository.saveAndFlush(entityUser);

        return InfrastructureModelToDomainModelTransformer.transform.apply(savedEntity);
    }

    @Override
    public void saveAll(List<User> its) {

    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public User findByUserNameAndPassword(String username,String password){
        return InfrastructureModelToDomainModelTransformer.transform.apply((this.repository.findByUserNameAndPassword(username,password)));
    }

    public User findByUserName(String username) {
        return InfrastructureModelToDomainModelTransformer.transform.apply(this.repository.findByUserName(username));
    }
}
