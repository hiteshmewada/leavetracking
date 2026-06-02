package com.employees.leavetracker.service.impl;

import com.employees.leavetracker.dto.LeaveRequestDto;
import com.employees.leavetracker.dto.LeaveResponseDto;
import com.employees.leavetracker.entity.LeaveRequest;
import com.employees.leavetracker.entity.LeaveType;
import com.employees.leavetracker.entity.User;
import com.employees.leavetracker.enums.LeaveRequestStatus;
import com.employees.leavetracker.repository.LeaveRepository;
import com.employees.leavetracker.repository.LeaveTypeRepository;
import com.employees.leavetracker.repository.UserRepository;
import com.employees.leavetracker.service.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRepository leaveRepository;
    private final UserRepository userRepository;
    private final LeaveTypeRepository leaveTypeRepository;

//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public LeaveResponseDto applyForLeave(LeaveRequestDto leaveRequestDto) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(leaveRequestDto.getStartDate());
        leaveRequest.setEndDate(leaveRequestDto.getEndDate());
        leaveRequest.setReason(leaveRequestDto.getLeaveReason());
        leaveRequest.setStatus(LeaveRequestStatus.PENDING);

        User user = userRepository.findById(leaveRequestDto.getUserId()).orElse(null);
        leaveRequest.setUser(user);

        LeaveType leaveType = leaveTypeRepository.findById(leaveRequestDto.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave Type Not Found"));

        leaveRequest.setLeaveType(leaveType);
        LeaveRequest savedLeave = leaveRepository.save(leaveRequest);

        double leaveDays = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;

        String employeeName = user!=null ? user.getFullName() : "Anonymous";

        return new LeaveResponseDto(savedLeave.getLeaveId(), savedLeave.getUser().getId(),
                savedLeave.getStartDate(),
                savedLeave.getEndDate(), savedLeave.getReason(),
                employeeName, savedLeave.getLeaveType().getLeaveName(), leaveDays, savedLeave.getStatus());
    }
}
