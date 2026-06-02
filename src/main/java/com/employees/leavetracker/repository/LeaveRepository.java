package com.employees.leavetracker.repository;

import com.employees.leavetracker.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {
//    List<LeaveRequest> findByUserId(Long userId);
}
