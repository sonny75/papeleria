package com.backend.Papeleria.Dao;
import com.backend.Papeleria.Models.producto;
import com.backend.Papeleria.Models.categoria;
import com.backend.Papeleria.Models.proveedor;
import org.springframework.data.repository.CrudRepository;

public interface productoDao extends CrudRepository<producto, Integer> {
    
}


