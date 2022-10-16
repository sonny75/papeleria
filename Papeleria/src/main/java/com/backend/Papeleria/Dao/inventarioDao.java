package com.backend.Papeleria.Dao;

import com.backend.Papeleria.Models.inventario;
import com.backend.Papeleria.Models.producto;
import com.backend.Papeleria.Models.provedor;
import com.backend.Papeleria.Models.ventas;
import org.springframework.data.repository.CrudRepository;

public interface inventarioDao extends CrudRepository<inventario, Integer> {
    
}
