package com.freezone.nalanda.infrastructure.persistence.transformers;

import com.googlecode.jmapper.JMapper;

import java.util.function.Function;

public class DomainModelToInfrastructureModelTransformer {

    public static Function<com.freezone.nalanda.domain.model.User, com.freezone.nalanda.infrastructure.model.User>
            transform = (user) -> {

//        JMapperAPI guruMapperAPI = new JMapperAPI();
//        guruMapperAPI
//                .add(mappedClass(com.freezone.nalanda.infrastructure.model.User.class)
//                    .add(attribute("id").value("id"))
//                    .add(attribute("firstName").value("fName"))
//                    .add(attribute("middleName").value("mName"))
//                    .add(attribute("lastName").value("lName")))
//                .add(mappedClass(com.freezone.nalanda.infrastructure.model.Guru.class)
//                     .add(attribute("subjects").value(new HashSet<Subject>())));

        JMapper<com.freezone.nalanda.infrastructure.model.User, com.freezone.nalanda.domain.model.User> mapper =
                new JMapper<>(com.freezone.nalanda.infrastructure.model.User.class,
                        com.freezone.nalanda.domain.model.User.class);

        com.freezone.nalanda.infrastructure.model.User result = mapper.getDestination(user);

        return result;
    };
}
