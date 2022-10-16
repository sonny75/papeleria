package com.backend.Papeleria.Dao;
import com.backend.Papeleria.Models.usuario;
import com.backend.Papeleria.Models.rol;
import org.springframework.data.repository.CrudRepository;

public interface usuarioDao extends CrudRepository<usuario, Integer> {
    
}


