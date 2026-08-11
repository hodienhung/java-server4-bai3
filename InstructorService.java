package com.example.service;

import com.example.dto.InstructorCreateRequest;
import com.example.model.Instructor;
import com.example.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // 1. Tìm giảng viên theo ID
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
    }

    // 2. Lấy danh sách tất cả giảng viên
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    // 3. Tạo mới giảng viên
    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();
        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());
        
        return instructorRepository.save(instructor);
    }
}
