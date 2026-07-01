package com.employees.leavetracker.controller;

import com.employees.leavetracker.dto.LeaveRequestDto;
import com.employees.leavetracker.dto.LeaveResponseDto;
import com.employees.leavetracker.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveRequestService leaveRequestService;

    @GetMapping("/users/{userId}/balance")
//    public Integer leave(@PathVariable Integer userId){
//    }

    @PostMapping("/api/leaves/apply")
    public ResponseEntity<LeaveResponseDto> applyLeave(@Valid @RequestBody LeaveRequestDto leaveRequestDto){
        LeaveResponseDto leaveResponseDto = leaveRequestService.applyForLeave(leaveRequestDto);
        return ResponseEntity.ok().body(leaveResponseDto);
    }
}
