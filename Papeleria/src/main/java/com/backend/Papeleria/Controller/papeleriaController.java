
package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.papeleria;
import com.backend.Papeleria.Service.papeleriaService;
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
@RequestMapping("/papeleria")
public class papeleriaController {
    @Autowired
    private papeleriaService papeleriaService;
    
    @PostMapping(value="/")
    public ResponseEntity<papeleria> agregar(@RequestBody papeleria papeleria){ 
        papeleria obj = papeleriaService.save(papeleria);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<papeleria> eliminar(@PathVariable Integer id){ 
        papeleria obj = papeleriaService.findById(id); 
        if(obj!=null) 
            papeleriaService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<papeleria> editar(@RequestBody papeleria papeleria){ 
        papeleria obj = papeleriaService.findById(papeleria.getIdpapeleria()); 
        if(obj!=null) {
            obj.setDireccionpapeleria(papeleria.getDireccionpapeleria());
            obj.setCelularpapeleria(papeleria.getCelularpapeleria());
            obj.setNombrepapeleria(papeleria.getNombrepapeleria());
            papeleriaService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<papeleria> consultarTodo(){
        return papeleriaService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public papeleria consultaPorId(@PathVariable Integer id){ 
        return papeleriaService.findById(id); 
    }
    
}