package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.model.Salary;
import org.example.hospitalmanagementsystem.repository.SalaryRepo;
import org.example.hospitalmanagementsystem.repository.repoImpl.SalaryRepoImpl;
import org.example.hospitalmanagementsystem.service.SalaryService;

import java.time.YearMonth;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {

    SalaryRepo salaryRepo = new SalaryRepoImpl();
    @Override
    public boolean addSalary(Salary s) {
        return salaryRepo.addSalary(s);
    }

    @Override
    public boolean updateSalary(Salary s) {
        return salaryRepo.updateSalary(s);
    }

    @Override
    public boolean deleteSalary(int sid) {
        return salaryRepo.deleteSalary(sid);
    }

    @Override
    public List<Salary> viewSalary() {
        return salaryRepo.viewSalary();
    }

    @Override
    public int findHolidayReduction(int id) {
        return salaryRepo.findHolidayReduction(id);
    }

    @Override
    public Salary getSalaryById(int salId) {
        return salaryRepo.getSalaryById(salId);
    }

    @Override
    public boolean checkAlreadyAssignedOrNot(int staffId, YearMonth yearMonth) {
        String yearMonth2 = yearMonth.toString();
        return salaryRepo.checkAlreadyAssignedOrNot(staffId,yearMonth2);
    }
}
