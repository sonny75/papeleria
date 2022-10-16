package com.backend.Papeleria.Service;

import com.backend.Papeleria.Models.ventas;
import java.util.List;

public interface ventasService {
    public ventas save(ventas ventas);
    public void delete(Integer id);
    public ventas findById(Integer id);
    public List<ventas> findByAll();
    
}
