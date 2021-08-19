package com.example.springDemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
//        return List.of(new Student(47448495L, "harish", "harish@gmail.com",
//                LocalDate.of(2020, Month.AUGUST, 5), 40));
    }

    public void addStudent(Student student){

        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());

        if(optionalStudent.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Boolean studentExists = studentRepository.existsById(studentId);
        if(!studentExists){
            throw new IllegalStateException("Student with Id:"+studentId+" does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudent(Long studentId, String name, String email){

        Student student = studentRepository.findById(studentId).orElseThrow(()->{
            throw new IllegalStateException("Student with Id:"+studentId+" does not exists");
        });

        if(name != null && name.length() > 0 &&  !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){

            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);

            if(optionalStudent.isPresent()){
                throw new IllegalStateException("Email already taken");
            }

            student.setEmail(email);

        }

        return student;


    }
}