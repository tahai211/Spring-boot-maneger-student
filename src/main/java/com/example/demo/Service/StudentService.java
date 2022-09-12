package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudents(){
        return studentRepository.findAll();//con co deleteall.... cho nay de tra data ve cho controller
    }



    //them sinh vien vao table
    public Student save(Student student){

        return studentRepository.save(student);
    }

    //lay student theo dang sinh vien
    public Student get(String id){
        return studentRepository.findById(id).get();
    }


    public Student update(String id, Student user) {
        Student fromDB = studentRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setEmail(user.getEmail());
        fromDB.setName(user.getName());
        fromDB.setAddress(user.getAddress());
        fromDB.setCccd(user.getCccd());
        fromDB.setGender(user.getGender());
        fromDB.setBirthDay(user.getBirthDay());
        fromDB.setEthnic(user.getEthnic());
        fromDB.setNganh(user.getNganh());
        fromDB.setPhone(user.getPhone());
        return studentRepository.save(fromDB);
    }
    //xoa sinh vien theo id
    public void deleteStudent(String id){
        boolean exists = studentRepository.existsById ( id ) ;
        if ( ! exists ) {
            throw new IllegalStateException (
                    " student with id " + id + " does not exists " );
        }
        studentRepository.deleteById ( id ) ;
    }
}
