package org.example.hospitalmanagementsystem.service;

import org.example.hospitalmanagementsystem.model.Shifts;
import org.example.hospitalmanagementsystem.model.Staff;

import java.time.LocalDate;
import java.util.List;

public interface ShiftsService {
     boolean assignShifts(Shifts shifts);
     List<Shifts> getAllShifts();
     Shifts getShiftById(int id);
     boolean deleteShiftById(int id);
     Shifts getShiftByStaffAndDate(Staff staff, LocalDate date);
     boolean deleteShiftByStaff(Staff staff);
     List<Shifts> getAllShiftsByDate(LocalDate date);
     boolean updateShiftById(Shifts shifts);
}
