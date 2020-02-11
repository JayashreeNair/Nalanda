package com.freezone.nalanda.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private String code;
    private Subject subjects[];

    public static class CourseBuilder {
        private Course instance;

        public CourseBuilder() {
            this.instance = new Course();
        }

        public CourseBuilder Code(String code) {
            this.instance.code = code;
            return this;
        }

        public CourseBuilder Subjects(Subject subjects[]) {
            this.instance.subjects = subjects;
            return this;
        }

        public Course build() {
            return instance;
        }
    }
}
