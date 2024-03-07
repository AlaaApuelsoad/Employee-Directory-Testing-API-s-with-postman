package com.qnetemployee.qnetdemo.repository;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnetEmployeeRepository extends JpaRepository<QnetEmployee,Integer> {

}
