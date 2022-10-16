package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.ventasDao;
import com.backend.Papeleria.Models.ventas;
import com.backend.Papeleria.Service.ventasService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class ventasServiceImpl implements ventasService {
    @Autowired
    private ventasDao ventasDao;

    @Override
    @Transactional(readOnly=false)
    public ventas save(ventas ventas) {
        return ventasDao.save(ventas);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        ventasDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public ventas findById(Integer id) {
        return ventasDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<ventas> findByAll() {
        return (List<ventas>) ventasDao.findAll();
    }
}


