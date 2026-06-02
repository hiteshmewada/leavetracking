package com.employees.leavetracker.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveRequestDto {

    @NotNull(message = "User id cannot be null")
    private Long userId;

    @NotNull(message = "Leave Type Id is required")
    private Long leaveTypeId;

    @NotBlank(message = "Please provide reason for your leave")
    private String leaveReason;

    @NotNull(message = "Start Date is required")
    @FutureOrPresent(message = "Start date must be today or in future")
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    private LocalDate endDate;
}
