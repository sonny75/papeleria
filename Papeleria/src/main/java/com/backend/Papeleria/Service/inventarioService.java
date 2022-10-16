package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.inventario;
import java.util.List;

public interface inventarioService {
    public inventario save(inventario inventario);
    public void delete(Integer id);
    public inventario findById(Integer id);
    public List<inventario> findByAll();
    
}


