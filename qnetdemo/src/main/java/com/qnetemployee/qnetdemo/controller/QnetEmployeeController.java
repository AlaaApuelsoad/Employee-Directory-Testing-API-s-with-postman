package com.qnetemployee.qnetdemo.controller;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;
import com.qnetemployee.qnetdemo.service.QnetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class QnetEmployeeController {

    private QnetEmployeeService qnetEmployeeService;

    @Autowired
    public QnetEmployeeController(QnetEmployeeService qnetEmployeeService) {
        this.qnetEmployeeService = qnetEmployeeService;
    }

    @GetMapping("/list")
    public List<QnetEmployee> findAll(){
       return qnetEmployeeService.findAll();
    }

    @GetMapping("/list/{employeeId}")
    public QnetEmployee getEmployee(@PathVariable int employeeId){
        QnetEmployee qnetEmployee = (QnetEmployee) qnetEmployeeService.findById(employeeId);
        return qnetEmployee;
    }

    //add mapping for add new employee
    @PostMapping("/list")
    public QnetEmployee addEmployee(@RequestBody QnetEmployee qnetEmployee){
        qnetEmployee.setId(0);
        QnetEmployee dbEmployee = qnetEmployeeService.Save(qnetEmployee);
        return dbEmployee;
    }

    //add mapping for update employee
    @PutMapping("/list")
    public QnetEmployee updateEmployee(@RequestBody QnetEmployee qnetEmployee){
        QnetEmployee theEmployee = qnetEmployeeService.Save(qnetEmployee);
        return theEmployee;
    }

    //add mapping for delete employee
    @DeleteMapping("/list/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        qnetEmployeeService.deleteById(employeeId);
        return "Employee id - "+employeeId+" has been deleted";
    }
}
