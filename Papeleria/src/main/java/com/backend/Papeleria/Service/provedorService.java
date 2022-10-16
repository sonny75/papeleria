package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.provedor;
import java.util.List;

public interface provedorService {
    public provedor save(provedor provedor);
    public void delete(Integer id);
    public provedor findById(Integer id);
    public List<provedor> findByAll();
    
}
