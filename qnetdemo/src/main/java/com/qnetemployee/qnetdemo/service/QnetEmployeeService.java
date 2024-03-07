package com.qnetemployee.qnetdemo.service;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;

import java.util.List;

public interface QnetEmployeeService {

    List<QnetEmployee> findAll();
    QnetEmployee findById(int theId);
    QnetEmployee Save(QnetEmployee qnetEmployee);
    void deleteById(int theId);

}
