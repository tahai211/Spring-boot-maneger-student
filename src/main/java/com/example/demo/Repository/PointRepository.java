package com.example.demo.Repository;

import com.example.demo.Entity.Point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point,String> {
}
