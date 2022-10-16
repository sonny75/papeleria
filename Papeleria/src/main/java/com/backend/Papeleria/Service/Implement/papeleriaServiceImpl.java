package com.backend.Papeleria.Service.Implement;
import com.backend.Papeleria.Dao.papeleriaDao;
import com.backend.Papeleria.Models.papeleria;
import com.backend.Papeleria.Service.papeleriaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class papeleriaServiceImpl implements papeleriaService {
    @Autowired
    private papeleriaDao papeleriaDao;

    @Override
    @Transactional(readOnly=false)
    public papeleria save(papeleria papeleria) {
        return papeleriaDao.save(papeleria);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        papeleriaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public papeleria findById(Integer id) {
        return papeleriaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<papeleria> findByAll() {
        return (List<papeleria>) papeleriaDao.findAll();
    }
}



