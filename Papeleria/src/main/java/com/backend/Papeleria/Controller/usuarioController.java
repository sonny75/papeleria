package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.usuario;
import com.backend.Papeleria.Service.usuarioService;
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
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    private usuarioService usuarioService;
    
    @PostMapping(value="/")
    public ResponseEntity<usuario> agregar(@RequestBody usuario usuario){ 
        usuario obj = usuarioService.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<usuario> eliminar(@PathVariable Integer id){ 
        usuario obj = usuarioService.findById(id); 
        if(obj!=null) 
            usuarioService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<usuario> editar(@RequestBody usuario usuario){ 
        usuario obj = usuarioService.findById(usuario.getIdusuario()); 
        if(obj!=null) {
            obj.setRol(usuario.getRol());
            obj.setNombreuno(usuario.getNombreuno());
            obj.setNombredos(usuario.getNombredos());
            obj.setApellidouno(usuario.getApellidouno());
            obj.setApellidodos(usuario.getApellidodos());
            obj.setEmail(usuario.getEmail());
            obj.setDireccion(usuario.getDireccion());
            obj.setCelular(usuario.getCelular());
           usuarioService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<usuario> consultarTodo(){
        return usuarioService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public usuario consultaPorId(@PathVariable Integer id){ 
        return usuarioService.findById(id); 
    }
    
}
