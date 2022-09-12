package com.example.demo.Controller;


import com.example.demo.Service.StudentService;
import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")//in data lên thành json
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student")
    public List<Student> getStudents(){
        return studentService.getStudents();

    }
    @PostMapping("/student/{ id }")
    public void registerNewStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @PutMapping("/student/{ id }")
    public Student update(@PathVariable String id, @RequestBody Student user) {
        return studentService.update(id, user);
    }
    @GetMapping("/student/{ id }")
    public ResponseEntity<Student> getByID(@PathVariable(value = "id") String id){
        try{
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ( path = " /student/{ id } " )
    public void deleteStudent ( @PathVariable ( " id " ) String id ) {
        studentService.deleteStudent( id ) ;
    }
}
