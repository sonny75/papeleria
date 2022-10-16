package com.backend.Papeleria.Service;

import com.backend.Papeleria.Models.rol;
import java.util.List;

public interface rolService {
    public rol save(rol rol);
    public void delete(Integer id);
    public rol findById(Integer id);
    public List<rol> findByAll();
    
}
