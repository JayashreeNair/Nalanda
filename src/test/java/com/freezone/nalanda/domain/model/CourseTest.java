package com.freezone.nalanda.domain.model;

import com.freezone.nalanda.domain.model.Course;
import com.freezone.nalanda.domain.model.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    public void test1(){
        Course.CourseBuilder builder = new Course.CourseBuilder();
        assertNotNull(builder);

        Course result = builder
                .Code("C-101")
                .Subjects(new Subject[10]) // Should this also build the contents of the array?
                .build();

        assertNotNull(result);
        assertEquals(result.getCode(),"C-101");
        assertEquals(result.getSubjects().length,10);

    }

}
