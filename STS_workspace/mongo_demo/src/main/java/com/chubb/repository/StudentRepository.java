package com.chubb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chubb.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{
}
