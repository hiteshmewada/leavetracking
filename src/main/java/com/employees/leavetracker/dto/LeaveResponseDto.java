package com.employees.leavetracker.dto;

import com.employees.leavetracker.enums.LeaveRequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class LeaveResponseDto {
    private Long leaveId; // The unique ID of the leave request
    private Long userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    private String reason;
    private String employeeName;
    private String leaveType;
    private double numberOfLeaves;
    private LeaveRequestStatus status;
//    private String managerRemark; -> will think afterwards
}
