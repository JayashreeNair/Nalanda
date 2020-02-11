package com.freezone.nalanda.infrastructure.persistence.transformers;
import com.freezone.nalanda.infrastructure.model.User;
import com.googlecode.jmapper.JMapper;

import java.util.function.Function;


public class InfrastructureModelToDomainModelTransformer {

    public static Function<com.freezone.nalanda.infrastructure.model.User, com.freezone.nalanda.domain.model.User> transform = (user) ->{

        JMapper<com.freezone.nalanda.domain.model.User, User > mapper =
                new JMapper<>(com.freezone.nalanda.domain.model.User.class,
                        com.freezone.nalanda.infrastructure.model.User.class);

        com.freezone.nalanda.domain.model.User result = mapper.getDestination(user);

        return result;
    };
}
