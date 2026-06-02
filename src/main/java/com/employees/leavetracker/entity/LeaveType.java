package com.employees.leavetracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "leave_types")
@Getter
@Setter
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaveName; // e.g., "SICK_LEAVE", "VACATION"
    private int maxDaysPerYear;
    private boolean isPaid;
}
