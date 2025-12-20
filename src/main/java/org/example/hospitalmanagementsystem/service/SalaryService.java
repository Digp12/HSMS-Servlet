package org.example.hospitalmanagementsystem.service;

import org.example.hospitalmanagementsystem.model.Salary;

import java.time.YearMonth;
import java.util.List;

public interface SalaryService {
    boolean addSalary(Salary s);
    boolean updateSalary(Salary s);
    boolean deleteSalary(int sid);
    List<Salary> viewSalary();
    int findHolidayReduction(int id);
    Salary getSalaryById(int salId);
    boolean checkAlreadyAssignedOrNot(int staffId, YearMonth yearMonth);
}
