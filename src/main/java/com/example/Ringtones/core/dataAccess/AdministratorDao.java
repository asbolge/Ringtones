package com.example.Ringtones.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Ringtones.core.entities.Administrator;

public interface AdministratorDao extends JpaRepository<Administrator, Integer>{

}
