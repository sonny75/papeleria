package com.backend.Papeleria.Service.Implement;

import com.backend.Papeleria.Dao.usuarioDao;
import com.backend.Papeleria.Models.usuario;
import com.backend.Papeleria.Service.usuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class usuarioServiceImpl implements usuarioService {
    @Autowired
    private usuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=false)
    public usuario save(usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<usuario> findByAll() {
        return (List<usuario>) usuarioDao.findAll();
    }
}

