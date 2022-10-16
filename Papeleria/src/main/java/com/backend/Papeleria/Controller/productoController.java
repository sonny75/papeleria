package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.producto;
import com.backend.Papeleria.Service.productoService;
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
@RequestMapping("/producto")
public class productoController {
    @Autowired
    private productoService productoService;
    
    @PostMapping(value="/")
    public ResponseEntity<producto> agregar(@RequestBody producto producto){ 
        producto obj = productoService.save(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<producto> eliminar(@PathVariable Integer id){ 
        producto obj = productoService.findById(id); 
        if(obj!=null) 
            productoService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<producto> editar(@RequestBody producto producto){ 
        producto obj = productoService.findById(producto.getIdproducto()); 
        if(obj!=null) {
            obj.setProvedor(producto.getProvedor());
            obj.setCategoria(producto.getCategoria());
            obj.setDescripcionproducto(producto.getDescripcionproducto());
            productoService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<producto> consultarTodo(){
        return productoService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public producto consultaPorId(@PathVariable Integer id){ 
        return productoService.findById(id); 
    }
    
}