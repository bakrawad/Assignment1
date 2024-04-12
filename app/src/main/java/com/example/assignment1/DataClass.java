package com.example.assignment1;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
    List<ClassLevel> levelList = new ArrayList<>();
    public DataClass(){
        Course Arabic = new Course("Arabic","The subject refers to the noun (person, place, or thing) " +
                "that performs an action or possesses specific attributes");
        Course English = new Course("English"," the study of English language, literature, society, culture, and people");
        //level 1
        Course Math = new Course("Math","deals with numbers, shapes, logic, quantity and arrangements");
        Course History = new Course("History","History is an academic discipline which uses a narrative to " +
                "describe, examine, question, and analyze past events");
        //level 2
        Course Physics = new Course("Physics","Physics can, at base, be defined as the science of matter, motion, " +
                "and energy. Its laws are typically expressed with economy");
        //level 3
        ClassLevel level1 = new ClassLevel(1);
        level1.addCourse(Arabic);
        level1.addCourse(English);

        ClassLevel level2 = new ClassLevel(2);
        level2.addCourse(Math);
        level2.addCourse(History);

        ClassLevel level3 = new ClassLevel(3);
        level3.addCourse(Physics);

        levelList.add(level1);
        levelList.add(level2);
        levelList.add(level3);
    }
    public List<Course>getCourse(int level){
        List<Course> res = new ArrayList<>();
        for(int i = 0 ; i < levelList.size();i++){
            if (levelList.get(i).level== level){
                res = levelList.get(i).course;
            }
        }
        return res;
    }

//    public List<String> getSubject(int level,Course course){
//        List<String> res = new ArrayList<>();
//        for(int i = 0 ; i < levelList.size();i++){
//            if (levelList.get(i).level== level){
////                res = levelList.get(i).course;
//                for (int j = 0 ; i < levelList.get(i).course.size() ;j++){
//                    if (levelList.get(i).course.get(j).equals(course)){
//                        res.add(course.name);
//                        res.add(course.subject);
//                    }
//                }
//            }
//        }
//        return res;
//    }


}
