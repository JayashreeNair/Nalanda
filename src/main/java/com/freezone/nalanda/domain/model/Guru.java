package com.freezone.nalanda.domain.model;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
public class Guru extends User {

    @JMap
    private Set<Subject> classes;

    public void teaches(Set<Subject> classes) {
        this.classes = classes;
    }

    public static class GuruBuilder {
        private Guru instance;

        public GuruBuilder() {
            this.instance = new Guru();
        }

//        public GuruBuilder FirstName(String fName){
//            this.instance.setFName(fName);
//            return this;
//        }
//
//        public GuruBuilder MiddleName(String mName){
//            this.instance.setMName(mName);
//            return this;
//        }
//
//        public GuruBuilder LastName(String lName){
//            this.instance.setLName(lName);
//            return this;
//        }

        public Guru build(){
            return instance;
        }
    }
}
