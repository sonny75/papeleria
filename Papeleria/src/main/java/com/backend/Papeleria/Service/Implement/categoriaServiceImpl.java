package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.categoriaDao;
import com.backend.Papeleria.Models.categoria;
import com.backend.Papeleria.Service.categoriaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class categoriaServiceImpl implements categoriaService {
    @Autowired
    private categoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=false)
    public categoria save(categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        categoriaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public categoria findById(Integer id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<categoria> findByAll() {
        return (List<categoria>) categoriaDao.findAll();
    }
}

