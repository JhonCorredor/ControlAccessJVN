package com.jvn.controlAccess.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvn.controlAccess.Collection.Pais;

public interface IPaisRepository extends JpaRepository<Pais, Integer> {

}