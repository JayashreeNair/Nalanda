package com.freezone.nalanda.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubjectTest {

    @Test
    public void test1() {
        Subject.SubjectBuilder a = new Subject.SubjectBuilder();
        Subject result = a.Code("Code").AcedemicYear(2020).Name("Biology").Room("A-101").build();
        assertNotNull(a);
        assertNotNull(result);
        assertEquals(result.getCode(),"Code");
        assertEquals(result.getAcademicYear(),2020);
        assertEquals(result.getName(),"Biology");
        assertEquals(result.getRoom(),"A-101");
    }


}
