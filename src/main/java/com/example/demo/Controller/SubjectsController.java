package com.example.demo.Controller;

import com.example.demo.Entity.Subjects;
import com.example.demo.Service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")//in data lên thành json
public class SubjectsController {
    private final SubjectsService subjectsService;
    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }
    @GetMapping("/subject")
    public List<Subjects> listSubjects(){
        return subjectsService.listSubjects();

    }
    @GetMapping("/subject/{MaMH}")
    public ResponseEntity<Subjects> getByID(@PathVariable(value = "MaMH") String maMH){
        try{
            Subjects subjects = subjectsService.getSubject(maMH);
            return new ResponseEntity<Subjects>(subjects, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Subjects>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/subject/{MaMH}")
    public void saveSubject(@RequestBody Subjects subjects){
        subjectsService.saveSubject(subjects);
    }
    @PutMapping("/subject/{MaMH}")
    public Subjects updateSubject(@PathVariable String maMH, @RequestBody Subjects subjects) {
        return subjectsService.updateSubject(maMH, subjects);
    }
    @DeleteMapping ( path = "/subject/{MaMH}" )
    public void deleteSubject ( @PathVariable ( "MaMH" ) String maMH ) {
        subjectsService.deleteSubject(maMH); ;
    }


}
