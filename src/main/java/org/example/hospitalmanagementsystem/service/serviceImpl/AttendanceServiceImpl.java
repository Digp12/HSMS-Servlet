package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.model.Attendance;
import org.example.hospitalmanagementsystem.repository.AttendaceRepo;
import org.example.hospitalmanagementsystem.repository.repoImpl.AttendaceRepoImpl;
import org.example.hospitalmanagementsystem.service.AttendanceService;

import java.time.LocalDate;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {

    private AttendaceRepo attendaceRepo = new AttendaceRepoImpl();

    @Override
    public boolean addAttendance(Attendance a) {
        return attendaceRepo.addAttendance(a);
    }

    @Override
    public boolean updateAttendance(Attendance a) {
        return attendaceRepo.updateAttendance(a);
    }

    @Override
    public boolean deleteAttendance(int id) {
        return attendaceRepo.deleteAttendance(id);
    }

    @Override
    public List<Attendance> showAllAttendance() {
        return attendaceRepo.showAllAttendance();
    }

    @Override
    public Attendance getAttendanceById(int id) {
        return attendaceRepo.getAttendanceById(id);
    }

    @Override
    public Attendance getAttendanceMarked(int staff_id ) {
        LocalDate date=LocalDate.now();
        return attendaceRepo.getAttendanceMarked(staff_id,date);
    }
}
