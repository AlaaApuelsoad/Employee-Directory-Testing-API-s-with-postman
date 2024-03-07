package com.qnetemployee.qnetdemo.service;

import com.qnetemployee.qnetdemo.entity.QnetEmployee;
import com.qnetemployee.qnetdemo.repository.QnetEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QnetEmployeeServiceImp implements QnetEmployeeService{

    //add QnetEmployeeRepository and inject using constructor injection
    private QnetEmployeeRepository qnetEmployeeRepository;

    public QnetEmployeeServiceImp(QnetEmployeeRepository qnetEmployeeRepository) {
        this.qnetEmployeeRepository = qnetEmployeeRepository;
    }

    @Override
    public List<QnetEmployee> findAll() {
        return qnetEmployeeRepository.findAll();
    }

    @Override
    public QnetEmployee  findById(int theId) {
        Optional<QnetEmployee> result = qnetEmployeeRepository.findById(theId);

        QnetEmployee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;

    }

    @Override
    public QnetEmployee Save(QnetEmployee qnetEmployee) {
    qnetEmployeeRepository.save(qnetEmployee);
        return qnetEmployee;
    }

    @Override
    public void deleteById(int theId) {
        qnetEmployeeRepository.deleteById(theId);
        System.out.println("Delete employee id -"+theId);
    }
}
