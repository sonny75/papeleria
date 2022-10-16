package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.provedor;
import com.backend.Papeleria.Service.provedorService;
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
@RequestMapping("/provedor")
public class provedorController {
    @Autowired
    private provedorService provedorService;
    
    @PostMapping(value="/")
    public ResponseEntity<provedor> agregar(@RequestBody provedor provedor){ 
        provedor obj = provedorService.save(provedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<provedor> eliminar(@PathVariable Integer id){ 
        provedor obj = provedorService.findById(id); 
        if(obj!=null) 
            provedorService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<provedor> editar(@RequestBody provedor provedor){ 
        provedor obj = provedorService.findById(provedor.getIdproveedor()); 
        if(obj!=null) {
            obj.setNombrevendedor(provedor.getNombrevendedor());
            obj.setDireccionempresa(provedor.getDireccionempresa());
            obj.setEmailproveedor(provedor.getEmailproveedor());
            obj.setCelularproveedor(provedor.getCelularproveedor());
            obj.setEmpresa(provedor.getEmpresa());
            provedorService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<provedor> consultarTodo(){
        return provedorService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public provedor consultaPorId(@PathVariable Integer id){ 
        return provedorService.findById(id); 
    }
    
}

