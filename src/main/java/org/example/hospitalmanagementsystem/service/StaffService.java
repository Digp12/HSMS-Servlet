package org.example.hospitalmanagementsystem.service;

import org.example.hospitalmanagementsystem.model.Department;
import org.example.hospitalmanagementsystem.model.Staff;
import org.example.hospitalmanagementsystem.model.StaffRole;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();

    List<Staff> getAllStaffByDepartment(Department department);

    List<Staff> getAllStaffByRole(StaffRole staffRole);

    boolean addStaff(Staff staff);

    boolean updateStaff(Staff staff);

    boolean deleteStaff(int id);

    Staff getStaffById(int id);

    Staff getStaffByName(String staffName);

    String getStaffNameById(int i);

    Staff checkStaff(String email, String password);
}
