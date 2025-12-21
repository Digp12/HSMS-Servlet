package org.example.hospitalmanagementsystem.helper;

import org.example.hospitalmanagementsystem.service.*;
import org.example.hospitalmanagementsystem.service.serviceImpl.*;

public class ServiceHelper {
   public static DeptService deptService = new DeptServiceImpl();
   public static StaffRoleService staffRoleService = new StaffRoleServiceImpl();
    public static AttendanceService attendanceService = new AttendanceServiceImpl();
    public static StaffService staffService = new StaffServiceImpl();
    public static ShiftsService shiftsService = new ShiftsServiceImpl();
    public static SalaryService salaryService = new SalaryServiceImpl();
    public static AdminLoginService adminLoginService = new AdminLoginServiceImpl();

}
