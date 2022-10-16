package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.productoDao;
import com.backend.Papeleria.Models.producto;
import com.backend.Papeleria.Service.productoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class productoServiceImpl implements productoService {
    @Autowired
    private productoDao productoDao;

    @Override
    @Transactional(readOnly=false)
    public producto save(producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public producto findById(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<producto> findByAll() {
        return (List<producto>) productoDao.findAll();
    }
}


