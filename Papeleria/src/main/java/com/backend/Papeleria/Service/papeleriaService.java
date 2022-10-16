package com.backend.Papeleria.Service;
import com.backend.Papeleria.Models.papeleria;
import java.util.List;

public interface papeleriaService {
    public papeleria save(papeleria papeleria);
    public void delete(Integer id);
    public papeleria findById(Integer id);
    public List<papeleria> findByAll();
    
}

