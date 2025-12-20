package org.example.hospitalmanagementsystem.service;

import org.example.hospitalmanagementsystem.model.Attendance;

import java.util.List;

public interface AttendanceService {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
    Attendance getAttendanceById(int id);
}
