package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.ventas;
import com.backend.Papeleria.Service.ventasService;
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
@RequestMapping("/ventas")
public class ventasController {
    @Autowired
    private ventasService ventasService;
    
    @PostMapping(value="/")
    public ResponseEntity<ventas> agregar(@RequestBody ventas ventas){ 
        ventas obj = ventasService.save(ventas);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<ventas> eliminar(@PathVariable Integer id){ 
        ventas obj = ventasService.findById(id); 
        if(obj!=null) 
            ventasService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<ventas> editar(@RequestBody ventas ventas){ 
        ventas obj = ventasService.findById(ventas.getIdventa()); 
        if(obj!=null) {
            obj.setFecharegistro(ventas.getFecharegistro());
            obj.setUsuario(ventas.getUsuario());
            obj.setPapeleria(ventas.getPapeleria());
            ventasService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<ventas> consultarTodo(){
        return ventasService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public ventas consultaPorId(@PathVariable Integer id){ 
        return ventasService.findById(id); 
    }
    
}
