package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Models.proveedor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;
import com.backend.Papeleria.Dao.proveedorDao;
import com.backend.Papeleria.Service.proveedorService;

@Service
public class proveedorServiceImpl implements proveedorService {
    @Autowired
    private proveedorDao proveedorDao;

    @Override
    @Transactional(readOnly=false)
    public proveedor save(proveedor proveedor) {
        return proveedorDao.save(proveedor);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        proveedorDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public proveedor findById(Integer id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<proveedor> findByAll() {
        return (List<proveedor>) proveedorDao.findAll();
    }
}


