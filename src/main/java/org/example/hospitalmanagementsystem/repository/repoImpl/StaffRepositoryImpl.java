package org.example.hospitalmanagementsystem.repository.repoImpl;

import org.example.hospitalmanagementsystem.dbConfig.DbConfiguration;
import org.example.hospitalmanagementsystem.helper.ServiceHelper;
import org.example.hospitalmanagementsystem.model.*;
import org.example.hospitalmanagementsystem.repository.DeptRepository;
import org.example.hospitalmanagementsystem.repository.StaffRepository;
import org.example.hospitalmanagementsystem.repository.StaffRoleRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StaffRepositoryImpl extends DbConfiguration implements StaffRepository {

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setPassword(resultSet.getString("password"));

                int id=resultSet.getInt("r_id");

                StaffRole staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                Department department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staffList.add(staff);
            }
            return staffList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Staff> getAllStaffByDepartment(Department department) {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff where d_id=?");
            preparedStatement.setInt(1,department.getD_id());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setPassword(resultSet.getString("password"));
                StaffRoleRepository staffRoleRepository = new StaffRoleRepositoryImpl();
                int id=resultSet.getInt("r_id");

                StaffRole staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staffList.add(staff);
            }
            return staffList;
            }return null;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<Staff> getAllStaffByRole(StaffRole staffRole) {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff where r_id=?");
            preparedStatement.setInt(1,staffRole.getSr_id());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setPassword(resultSet.getString("password"));
                StaffRoleRepository staffRoleRepository = new StaffRoleRepositoryImpl();
                int id=resultSet.getInt("r_id");

                staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                Department department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);

                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));

                staffList.add(staff);
            }
            return staffList;}
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addStaff(Staff staff) {
        try{
            preparedStatement=connection.prepareStatement("insert into staff(s_name,s_gender,s_phone,s_address,d_id,r_id,s_status,join_date,s_email,password) values (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, String.valueOf(staff.getGender()));
            preparedStatement.setString(3, staff.getPhone());
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setInt(5,staff.getDepartment().getD_id());
            preparedStatement.setInt(6,staff.getStaffRole().getSr_id());
            preparedStatement.setString(7, String.valueOf(staff.getStatus()));
            preparedStatement.setDate(8, Date.valueOf(staff.getJoinDate()));
            preparedStatement.setString(9, staff.getEmail());
            preparedStatement.setString(10, staff.getPassword());


            return preparedStatement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        try {
            preparedStatement = connection.prepareStatement("update staff set s_name=?,s_gender=?,s_phone=?,s_address=?,d_id=?,r_id=?,s_status=?,join_date=? ,s_email=?,password=? where s_id=?");
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, String.valueOf(staff.getGender()));
            preparedStatement.setString(3, staff.getPhone());
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setInt(5,staff.getDepartment().getD_id());
            preparedStatement.setInt(6,staff.getStaffRole().getSr_id());
            preparedStatement.setString(7, String.valueOf(staff.getStatus()));
            preparedStatement.setDate(8, Date.valueOf(staff.getJoinDate()));
            preparedStatement.setString(10, staff.getPassword());
            preparedStatement.setString(9, staff.getEmail());
            preparedStatement.setInt(11, staff.getStaff_id());
            return preparedStatement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteStaff(int id) {
        try{
            preparedStatement=connection.prepareStatement("delete from staff where s_id=?");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Staff getStaffById(int id) {
        try{
            preparedStatement =connection.prepareStatement("select * from staff where s_id=?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Staff staff=new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                staff.setPassword(resultSet.getString("password"));
                int r_id=resultSet.getInt("r_id");
                staff.setStaffRole(ServiceHelper.staffRoleService.getStaffRoleById(r_id));
                int d_id=resultSet.getInt("d_id");
                staff.setDepartment(ServiceHelper.deptService.getDeptById(d_id));
                return staff;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Staff getStaffByName(String staffName) {
        try{
            preparedStatement =connection.prepareStatement("select * from staff where s_name=?");
            preparedStatement.setString(1,staffName);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Staff staff=new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staff.setPassword(resultSet.getString("password"));
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                int r_id=resultSet.getInt("r_id");
                staff.setStaffRole(ServiceHelper.staffRoleService.getStaffRoleById(r_id));
                int d_id=resultSet.getInt("d_id");
                staff.setDepartment(ServiceHelper.deptService.getDeptById(d_id));
                return staff;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getStaffNameById(int i) {
        try{
            preparedStatement =connection.prepareStatement("select * from staff where s_id="+i);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("s_name");
            }else {
                return "";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }

    }

    @Override
    public Staff checkStaff(String email, String password) {
        try{
            preparedStatement=connection.prepareStatement("select * from staff where s_email=? and password=?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet= preparedStatement.executeQuery();
            if(resultSet.next()) {
                Staff staff=new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setJoinDate(resultSet.getDate("join_date").toLocalDate());
                staff.setPassword(resultSet.getString("password"));
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                int r_id=resultSet.getInt("r_id");
                staff.setStaffRole(ServiceHelper.staffRoleService.getStaffRoleById(r_id));
                int d_id=resultSet.getInt("d_id");
                staff.setDepartment(ServiceHelper.deptService.getDeptById(d_id));
                return staff;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
