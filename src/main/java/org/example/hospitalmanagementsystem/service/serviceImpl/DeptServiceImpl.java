package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.model.Department;
import org.example.hospitalmanagementsystem.repository.DeptRepository;
import org.example.hospitalmanagementsystem.repository.repoImpl.DeptRepositoryImpl;
import org.example.hospitalmanagementsystem.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {

	DeptRepository deptRepository = new DeptRepositoryImpl();
	@Override
	public boolean addDept(Department dept) {
		if(!(dept.getD_name()==null || dept.getD_name().equals("")))
		    return deptRepository.addDept(dept);
        return false;
	}

	@Override
	public List<Department> getAllDept() {
	
		return deptRepository.getAllDept();
	}

	@Override
	public boolean deleteDept(int deptId) {
		return deptRepository.deleteDept(deptId);
	}

	@Override
	public boolean updateDept(Department dept) {
		return deptRepository.updateDept(dept);
	}

    @Override
    public Department getDeptById(int deptId) {
        return deptRepository.getDeptById(deptId);
    }

    @Override
    public Department getDeptByName(String deptName) {
        return deptRepository.getDeptByName(deptName);
    }


}
