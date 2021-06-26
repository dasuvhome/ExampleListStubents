package sample.db;

import sample.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DB {


     public List<Student> getStudents(){
     List<Student> students = new ArrayList<>();
         students.add(new Student("Атос", "Атосов", 32));
         students.add(new Student("Партос", "Партосов", 32));
         students.add(new Student("Арамис", "Арамисов", 31));
         students.add(new Student("Дартаньян", "ДАртаньянов", 27));

     return students;
     }



}
