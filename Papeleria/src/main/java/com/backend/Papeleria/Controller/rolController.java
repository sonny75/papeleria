package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.rol;
import com.backend.Papeleria.Service.rolService;
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
@RequestMapping("/rol")
public class rolController {
    @Autowired
    private rolService rolService;
    
    @PostMapping(value="/")
    public ResponseEntity<rol> agregar(@RequestBody rol rol){ 
        rol obj = rolService.save(rol);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<rol> eliminar(@PathVariable Integer id){ 
        rol obj = rolService.findById(id); 
        if(obj!=null) 
            rolService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<rol> editar(@RequestBody rol rol){ 
        rol obj = rolService.findById(rol.getId()); 
        if(obj!=null) {
            obj.setNombre(rol.getNombre());
            rolService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<rol> consultarTodo(){
        return rolService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public rol consultaPorId(@PathVariable Integer id){ 
        return rolService.findById(id); 
    }
    
}
