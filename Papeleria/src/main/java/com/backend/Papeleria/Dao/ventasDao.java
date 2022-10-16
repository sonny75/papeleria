package com.backend.Papeleria.Dao;
import com.backend.Papeleria.Models.ventas;
import com.backend.Papeleria.Models.papeleria;
import com.backend.Papeleria.Models.usuario;
import org.springframework.data.repository.CrudRepository;

public interface ventasDao extends CrudRepository<ventas, Integer> {
    
}


