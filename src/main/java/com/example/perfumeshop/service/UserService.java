package com.example.perfumeshop.service;

import com.example.perfumeshop.entity.Users;
import com.example.perfumeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Lấy danh sách tất cả người dùng
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // Lấy người dùng theo ID
    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Tạo mới người dùng
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    // Cập nhật người dùng
    public Users updateUser(Integer id, Users userDetails) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userDetails.getName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy User với ID: " + id));
    }

    // Xóa người dùng
    public void deleteUser(Integer id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy User với ID: " + id);
        }
    }
}