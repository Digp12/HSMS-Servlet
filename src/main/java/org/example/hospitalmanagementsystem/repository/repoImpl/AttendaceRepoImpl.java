package org.example.hospitalmanagementsystem.repository.repoImpl;

import org.example.hospitalmanagementsystem.dbConfig.DbConfiguration;
import org.example.hospitalmanagementsystem.model.Attendance;
import org.example.hospitalmanagementsystem.repository.AttendaceRepo;

import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendaceRepoImpl extends DbConfiguration implements AttendaceRepo {
    @Override
    public boolean addAttendance(Attendance a) {
        try{
            System.out.println(a);
            preparedStatement = connection.prepareStatement("insert into attendance(a_id,s_id,att_date,in_time,out_time,status) values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,a.getStaff_id());
            preparedStatement.setString(3, String.valueOf(a.getDate()));
            if (a.getIn_time() == null) {
                preparedStatement.setNull(4, Types.TIME);
            } else {
                preparedStatement.setString(4, String.valueOf(a.getIn_time()));
            }
            if (a.getOut_time() == null) {
                preparedStatement.setNull(5, Types.TIME);
            } else {
                preparedStatement.setString(5, String.valueOf(a.getIn_time()));
            }
            preparedStatement.setString(6,a.getStatus());
            int value = preparedStatement.executeUpdate();
            return value >= 1;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateAttendance(Attendance a) {
        try{
            preparedStatement = connection.prepareStatement("update attendance set s_id=?, att_date=? ,in_time=?, out_time=?, status=? where a_id=?");
            preparedStatement.setInt(1,a.getStaff_id());
            preparedStatement.setString(2, String.valueOf(a.getDate()));
            preparedStatement.setString(3,String.valueOf(a.getIn_time()));
            preparedStatement.setString(4,String.valueOf(a.getOut_time()));
            preparedStatement.setString(5,a.getStatus());
            preparedStatement.setInt(6, a.getId());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAttendance(int id) {
        try{
            preparedStatement = connection.prepareStatement("delete from attendance where a_id = ?");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Attendance> showAllAttendance() {
        List<Attendance> atlist = new ArrayList<>();
         try{
            preparedStatement = connection.prepareStatement("select * from attendance");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               Attendance a = new Attendance();
               a.setId(resultSet.getInt(1));
               a.setStaff_id(resultSet.getInt(2));
               a.setDate(resultSet.getDate(3).toLocalDate());
               a.setIn_time(resultSet.getTime(4).toLocalTime());
               a.setOut_time(resultSet.getTime(5).toLocalTime());
               a.setStatus(resultSet.getString(6));
               atlist.add(a);
            }
            return atlist;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Attendance getAttendanceById(int id) {
        try{
            preparedStatement = connection.prepareStatement("select * from attendance where a_id = "+id);
            resultSet = preparedStatement.executeQuery();
            Attendance a = new Attendance();
            while (resultSet.next()){
                a.setId(resultSet.getInt(1));
                a.setStaff_id(resultSet.getInt(2));
                a.setDate(resultSet.getDate(3).toLocalDate());
                a.setIn_time(resultSet.getTime(4).toLocalTime());
                a.setOut_time(resultSet.getTime(5).toLocalTime());
                a.setStatus(resultSet.getString(6));
            }
            return a;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Attendance getAttendanceMarked(int staff_id, LocalDate date) {
        try {
            preparedStatement = connection.prepareStatement("select * from attendance where s_id=? and att_date=?");
            preparedStatement.setInt(1, staff_id);
            preparedStatement.setString(2, String.valueOf(date));
            resultSet = preparedStatement.executeQuery();
            Attendance a = new Attendance();
            if (resultSet.next()){
                a.setId(resultSet.getInt(1));
                a.setStaff_id(resultSet.getInt(2));
                a.setDate(resultSet.getDate(3).toLocalDate());
                a.setIn_time(resultSet.getTime(4).toLocalTime());
                if(resultSet.getTime(5)!=null){
                a.setOut_time(resultSet.getTime(5).toLocalTime());}
                a.setStatus(resultSet.getString(6));
                return a;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
