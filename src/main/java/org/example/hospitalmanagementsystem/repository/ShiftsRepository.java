package org.example.hospitalmanagementsystem.repository;

import org.example.hospitalmanagementsystem.model.Shifts;
import org.example.hospitalmanagementsystem.model.Staff;

import java.time.LocalDate;
import java.util.List;

public interface ShiftsRepository {
     boolean assignShifts(Shifts shifts);
     List<Shifts> getAllShifts();
     Shifts getShiftById(int id);
     boolean deleteShiftById(int id);
     Shifts getShiftByStaffAndDate(Staff staff, LocalDate date);
     boolean deleteShiftByStaff(Staff staff);
     List<Shifts> getAllShiftsByDate(LocalDate date);
     boolean updateShiftById(Shifts shifts);
}
