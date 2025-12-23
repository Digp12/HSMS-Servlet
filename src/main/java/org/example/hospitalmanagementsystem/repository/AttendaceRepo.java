package org.example.hospitalmanagementsystem.repository;

import org.example.hospitalmanagementsystem.controller.attendance.LoadApproveLeave;
import org.example.hospitalmanagementsystem.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendaceRepo {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
    Attendance getAttendanceById(int id);
    Attendance getAttendanceMarked(int staff_id, LocalDate date);
    List<Integer> getAbsentStaffIds(LocalDate date);
}
