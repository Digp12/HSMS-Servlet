package org.example.hospitalmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    private int id;
    private Staff staff;
    private LocalDate date;
    private LocalTime in_time;
    private LocalTime out_time;
    private String status;
}
