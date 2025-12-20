package org.example.hospitalmanagementsystem.repository;

import org.example.hospitalmanagementsystem.model.Department;

import java.util.List;

public interface DeptRepository {
	boolean addDept(Department dept);
	List<Department> getAllDept();
	boolean deleteDept(int deptId);
	boolean updateDept(Department dept);
    Department getDeptById(int deptId);
    Department getDeptByName(String deptName);

}
