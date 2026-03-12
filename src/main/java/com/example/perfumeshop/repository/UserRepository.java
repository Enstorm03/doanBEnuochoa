package com.example.perfumeshop.repository;

import com.example.perfumeshop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    // Spring Data JPA đã tự động cung cấp các hàm như save(), findAll(), findById(), deleteById()...
    // Bạn có thể định nghĩa thêm các hàm tìm kiếm tùy chỉnh ở đây nếu cần, ví dụ:
    // boolean existsByName(String name);
}