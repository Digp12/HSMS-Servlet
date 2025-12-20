package org.example.hospitalmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    int salary_id;
    Staff staff;
    double basic_salary;
    double Hra;
    double Da ;
    double Pf;
    YearMonth month_year;
    double net_salary;
}
