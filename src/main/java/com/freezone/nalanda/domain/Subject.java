package com.freezone.nalanda.domain;

import lombok.Getter;

@Getter
public class Subject {
    private String code;
    private int academicYear;
    private String name;
    private String room;

    public Subject() {
        System.out.println("Creating instance of Subject");
    }


    public static class SubjectBuilder {
        private Subject instance;

        public SubjectBuilder() {
            this.instance = new Subject();
        }

        public SubjectBuilder Code(String code) {
            this.instance.code = code;
            return this;
        }

        public SubjectBuilder AcedemicYear(int year) {
            this.instance.academicYear = year;
            return this;
        }

        public SubjectBuilder Name(String name) {
            this.instance.name  = name;
            return this;
        }

        public SubjectBuilder Room(String room) {
            this.instance.room  = room;
            return this;
        }


        public Subject build() {
            return instance;
        }
    }
}
