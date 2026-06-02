package com.employees.leavetracker.service;

import com.employees.leavetracker.dto.LeaveRequestDto;
import com.employees.leavetracker.dto.LeaveResponseDto;
import com.employees.leavetracker.entity.LeaveRequest;

public interface LeaveRequestService {
    LeaveResponseDto applyForLeave(LeaveRequestDto leaveRequestDto);
}
