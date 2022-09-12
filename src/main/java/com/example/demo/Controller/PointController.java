package com.example.demo.Controller;

import com.example.demo.Entity.Branch;
import com.example.demo.Entity.Point;
import com.example.demo.Service.BranchService;
import com.example.demo.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")//in data lên thành json
public class PointController {
    private final PointService pointService;
    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }
    @GetMapping("/point")
    public List<Point> listPoint(){
        return pointService.listPoint();

    }
    @GetMapping("/point/{id}")
    public ResponseEntity<Point> getByID(@PathVariable(value = "id") String id){
        try{
            Point point = pointService.getPoint(id);
            return new ResponseEntity<Point>(point, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Point>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/point/{id}")
    public void savePoint(@RequestBody Point point){
        pointService.savePoint(point);
    }
    @PutMapping("/point/{id}")
    public Point updatePoint(@PathVariable String id, @RequestBody Point point) {
        return pointService.updatePoint(id, point);
    }
    @DeleteMapping ( path = "/point/{id}" )
    public void deletePoint ( @PathVariable ( "id" ) String id ) {
        pointService.deletePoint(id); ;
    }
}
