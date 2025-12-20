package org.example.hospitalmanagementsystem.repository;

import org.example.hospitalmanagementsystem.model.Attendance;

import java.util.List;

public interface AttendaceRepo {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
    Attendance getAttendanceById(int id);
}
