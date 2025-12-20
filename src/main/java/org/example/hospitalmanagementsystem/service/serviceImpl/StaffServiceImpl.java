package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.model.Department;
import org.example.hospitalmanagementsystem.model.Staff;
import org.example.hospitalmanagementsystem.model.StaffRole;
import org.example.hospitalmanagementsystem.repository.StaffRepository;
import org.example.hospitalmanagementsystem.repository.repoImpl.StaffRepositoryImpl;
import org.example.hospitalmanagementsystem.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository = new StaffRepositoryImpl();

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public List<Staff> getAllStaffByDepartment(Department department) {
        return staffRepository.getAllStaffByDepartment(department);
    }

    @Override
    public List<Staff> getAllStaffByRole(StaffRole staffRole) {
        return staffRepository.getAllStaffByRole(staffRole);
    }

    @Override
    public boolean addStaff(Staff staff) {
        if (isStaffValid(staff)) {
            return staffRepository.addStaff(staff);
        }
        return false;
    }

    private boolean isStaffValid(Staff staff) {
        return staff.getStaffRole() != null &&
                staff.getName() != null &&
                staff.getEmail() != null &&
                staff.getPhone() != null &&
                staff.getDepartment() != null &&
                staff.getJoinDate() != null &&
                staff.getAddress() != null &&
                staff.getGender() != null &&
                staff.getStatus() != null;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return staffRepository.updateStaff(staff);
    }

    @Override
    public boolean deleteStaff(int id) {
        return staffRepository.deleteStaff(id);
    }

    @Override
    public Staff getStaffById(int id) {
        return staffRepository.getStaffById(id);
    }

    @Override
    public Staff getStaffByName(String staffName) {
        return staffRepository.getStaffByName(staffName);
    }

    @Override
    public String getStaffNameById(int i) {
        return staffRepository.getStaffNameById(i);
    }
}
