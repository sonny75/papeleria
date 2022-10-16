package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.categoria;
import com.backend.Papeleria.Service.categoriaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class categoriaController {
    @Autowired
    private categoriaService categoriaService;
    
    @PostMapping(value="/")
    public ResponseEntity<categoria> agregar(@RequestBody categoria categoria){        
        categoria obj = categoriaService.save(categoria);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
   
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<categoria> eliminar(@PathVariable Integer id){ 
        categoria obj = categoriaService.findById(id); 
        if(obj!=null) 
            categoriaService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<categoria> editar(@RequestBody categoria categoria){ 
        categoria obj = categoriaService.findById(categoria.getIdCategoria()); 
        if(obj!=null) {
            obj.setNombre(categoria.getNombre());
            obj.setIdCategoria(categoria.getIdCategoria());
            categoriaService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<categoria> consultarTodo(){
        return categoriaService.findByAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public categoria consultaPorId(@PathVariable Integer id){ 
        return categoriaService.findById(id); 
    }
}


