package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.proveedor;
import java.util.List;

public interface proveedorService {
    public proveedor save(proveedor proveedor);
    public void delete(Integer id);
    public proveedor findById(Integer id);
    public List<proveedor> findByAll();
    
}
