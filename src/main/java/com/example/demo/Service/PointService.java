package com.example.demo.Service;

import com.example.demo.Entity.Point;
import com.example.demo.Entity.Subjects;
import com.example.demo.Repository.PointRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    private final PointRepository pointRepository;
    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }
    public List<Point> listPoint(){
        return pointRepository.findAll();
    }

    //them  vao table
    public Point savePoint(Point point){
        return pointRepository.save(point);
    }

    //lay  theo dang sinh vien
    public Point getPoint(String id){
        return pointRepository.findById(id).get();
    }
    public Point updatePoint(String id, Point point) {
        Point fromDB = pointRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setDiemCC(point.getDiemCC());
        fromDB.setTenMH(point.getTenMH());
        fromDB.setDiemGK(point.getDiemGK());
        fromDB.setDiemKTHP(point.getDiemKTHP());
        fromDB.setHocky(point.getHocky());
        fromDB.setLop(point.getLop());


        return pointRepository.save(fromDB);
    }

    //xoa  theo id
    public void deletePoint(String id){
        pointRepository.deleteById(id);
    }

}
