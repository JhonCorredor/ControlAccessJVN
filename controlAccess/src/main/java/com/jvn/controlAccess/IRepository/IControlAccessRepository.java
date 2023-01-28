package com.jvn.controlAccess.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvn.controlAccess.Collection.ControlAccess;

public interface IControlAccessRepository extends JpaRepository<ControlAccess, Integer> {

}