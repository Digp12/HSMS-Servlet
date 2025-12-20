package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.model.StaffRole;
import org.example.hospitalmanagementsystem.repository.StaffRoleRepository;
import org.example.hospitalmanagementsystem.repository.repoImpl.StaffRoleRepositoryImpl;
import org.example.hospitalmanagementsystem.service.StaffRoleService;

import java.util.List;

public class StaffRoleServiceImpl implements StaffRoleService {

    private StaffRoleRepository staffRoleRepository=new StaffRoleRepositoryImpl();
    @Override
    public List<StaffRole> getAllStaffRoles() {
        return staffRoleRepository.getAllStaffRoles();
    }

    @Override
    public StaffRole getStaffRoleById(int id) {
        return staffRoleRepository.getStaffRoleById(id);
    }

    @Override
    public boolean addStaffRole(StaffRole staffRole) {
        return staffRoleRepository.addStaffRole(staffRole);
    }

    @Override
    public boolean updateStaffRole(StaffRole staffRole) {
        return staffRoleRepository.updateStaffRole(staffRole);
    }

    @Override
    public boolean deleteStaffRole(int id) {
        return staffRoleRepository.deleteStaffRole(id);
    }

    public StaffRole getStaffRoleByName(String name){
        return staffRoleRepository.getStaffRoleByName(name);
    }

}
