package com.backend.Papeleria.Controller;
import com.backend.Papeleria.Models.proveedor;
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
import com.backend.Papeleria.Service.proveedorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/proveedor")
public class proveedorController {
    @Autowired
    private proveedorService proveedorService;
    
    @PostMapping(value="/")
    public ResponseEntity<proveedor> agregar(@RequestBody proveedor proveedor){ 
        proveedor obj = proveedorService.save(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<proveedor> eliminar(@PathVariable Integer id){ 
        proveedor obj = proveedorService.findById(id); 
        if(obj!=null) 
            proveedorService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @PutMapping(value="/") 
    public ResponseEntity<proveedor> editar(@RequestBody proveedor proveedor){ 
        proveedor obj = proveedorService.findById(proveedor.getIdproveedor()); 
        if(obj!=null) {
            obj.setNombrevendedor(proveedor.getNombrevendedor());
            obj.setDireccionempresa(proveedor.getDireccionempresa());
            obj.setEmailproveedor(proveedor.getEmailproveedor());
            obj.setCelularproveedor(proveedor.getCelularproveedor());
            obj.setEmpresa(proveedor.getEmpresa());
            proveedorService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    @GetMapping("/list")
    public List<proveedor> consultarTodo(){
        return proveedorService.findByAll(); 
    } 
    @GetMapping("/list/{id}") 
    public proveedor consultaPorId(@PathVariable Integer id){ 
        return proveedorService.findById(id); 
    }
    
}

