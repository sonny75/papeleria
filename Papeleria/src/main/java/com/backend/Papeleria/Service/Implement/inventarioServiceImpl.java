package com.backend.Papeleria.Service.Implement;
import com.backend.Papeleria.Dao.inventarioDao;
import com.backend.Papeleria.Models.inventario;
import com.backend.Papeleria.Service.inventarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class inventarioServiceImpl implements inventarioService {
    @Autowired
    private inventarioDao inventarioDao;

    @Override
    @Transactional(readOnly=false)
    public inventario save(inventario inventario) {
        return inventarioDao.save(inventario);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        inventarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public inventario findById(Integer id) {
        return (inventario) inventarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<inventario> findByAll() {
        return (List<inventario>) inventarioDao.findAll();
    }
}



