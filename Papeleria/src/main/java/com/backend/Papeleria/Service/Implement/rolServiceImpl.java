package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.rolDao;
import com.backend.Papeleria.Models.rol;
import com.backend.Papeleria.Service.rolService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class rolServiceImpl implements rolService {
    @Autowired
    private rolDao rolDao;

    @Override
    @Transactional(readOnly=false)
    public rol save(rol rol) {
        return rolDao.save(rol);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<rol> findByAll() {
        return (List<rol>) rolDao.findAll();
    }
}


