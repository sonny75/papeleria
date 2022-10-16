package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.producto;
import java.util.List;

public interface productoService {
    public producto save(producto prodcuto);
    public void delete(Integer id);
    public producto findById(Integer id);
    public List<producto> findByAll();
    
}