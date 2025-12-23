package org.example.hospitalmanagementsystem.service;

import org.example.hospitalmanagementsystem.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
    Attendance getAttendanceById(int id);
    Attendance getAttendanceMarked(int staff_id);
    List<Integer> getAbsentStaffIds(LocalDate date);
}
