package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.categoria;
import java.util.List;

public interface categoriaService {
    public categoria save(categoria categoria);
    public void delete(Integer id);
    public categoria findById(Integer id);
    public List<categoria> findByAll();
    
}


