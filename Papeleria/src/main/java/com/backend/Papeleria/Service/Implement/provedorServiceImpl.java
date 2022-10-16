package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.provedorDao;
import com.backend.Papeleria.Models.provedor;
import com.backend.Papeleria.Service.provedorService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class provedorServiceImpl implements provedorService {
    @Autowired
    private provedorDao provedorDao;

    @Override
    @Transactional(readOnly=false)
    public provedor save(provedor provedor) {
        return provedorDao.save(provedor);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        provedorDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public provedor findById(Integer id) {
        return provedorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<provedor> findByAll() {
        return (List<provedor>) provedorDao.findAll();
    }
}


