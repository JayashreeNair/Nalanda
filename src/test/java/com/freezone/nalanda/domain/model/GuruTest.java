package com.freezone.nalanda.domain.model;

import com.freezone.nalanda.domain.model.Guru;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GuruTest {

    @Test
    public void test1() {
        Guru.GuruBuilder guruBuilder = new Guru.GuruBuilder();
        Guru instance = guruBuilder
                .FirstName("firstName")
                .MiddleName("")
                .LastName("LastName")
                .build();

        assertNotNull(instance);
        assertEquals(instance.getFName(),"firstName");
        assertEquals(instance.getMName(),"");
        assertEquals(instance.getLName(),"LastName");
    }

}
