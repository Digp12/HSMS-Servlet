package org.example.hospitalmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Shifts {
    private int shiftId;
    private Staff staff;
    private LocalDate shiftDate;
    private ShiftType ShiftType;
    private LocalTime startTime;
    private LocalTime endTime;
}
