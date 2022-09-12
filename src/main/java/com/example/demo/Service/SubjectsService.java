package com.example.demo.Service;

import com.example.demo.Entity.Point;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subjects;
import com.example.demo.Repository.PointRepository;
import com.example.demo.Repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {
    private final SubjectsRepository subjectsRepository;
    @Autowired
    public SubjectsService(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }
    public List<Subjects> listSubjects(){
        return subjectsRepository.findAll();
    }
    //them  vao table
    public Subjects saveSubject(Subjects subjects){
        return subjectsRepository.save(subjects);
    }

    //lay
    public Subjects getSubject(String maMH){
        return subjectsRepository.findById(maMH).get();
    }
    public Subjects updateSubject(String maMH, Subjects subjects) {
        Subjects fromDB = subjectsRepository.findById(maMH).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setTenNganh(subjects.getTenNganh());
        fromDB.setTenMH(subjects.getTenMH());
        fromDB.setDvht(subjects.getDvht());

        return subjectsRepository.save(fromDB);
    }

    //xoa  theo maMH
    public void deleteSubject(String maMH){
        boolean exists = subjectsRepository.existsById (maMH) ;
        if ( ! exists ) {
            throw new IllegalStateException (
                    " student with id " + maMH + " does not exists " );
        }
        subjectsRepository.deleteById(maMH);
    }
}
