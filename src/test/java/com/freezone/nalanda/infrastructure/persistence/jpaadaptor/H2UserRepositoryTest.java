package com.freezone.nalanda.infrastructure.persistence.jpaadaptor;

import com.freezone.nalanda.domain.model.Guru;
import com.freezone.nalanda.domain.model.User;
import com.freezone.nalanda.infrastructure.persistence.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class H2UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    H2UserRepository subject;

    @Before
    public void setUp() {
        subject = new H2UserRepository(userRepository);
    }

    @Test()
    public void test1() {
        User domainUser = new Guru.GuruBuilder().FirstName("fName").LastName("lName").build();

        User savedUser = subject.save(domainUser);
        assertNotNull(savedUser);

        System.out.println("Saved User Id => " + savedUser.getId());
    }
}
