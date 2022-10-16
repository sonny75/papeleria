package com.backend.Papeleria.Service;

import com.backend.Papeleria.Models.usuario;
import java.util.List;

public interface usuarioService {
    public usuario save(usuario usuario);
    public void delete(Integer id);
    public usuario findById(Integer id);
    public List<usuario> findByAll();
    
}