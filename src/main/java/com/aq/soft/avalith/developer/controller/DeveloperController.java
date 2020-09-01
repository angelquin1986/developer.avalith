package com.aq.soft.avalith.developer.controller;

import com.aq.soft.avalith.developer.dto.DeveloperDTO;
import com.aq.soft.avalith.developer.entity.DeveloperEntity;
import com.aq.soft.avalith.developer.servicio.DeveloperService;
import com.aq.soft.avalith.developer.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author aquingaluisa
 * Constrollador api Rest
 */
@RestController
@RequestMapping("/developers")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    /**
     * Editamos el registro
     *
     * @param id
     * @return
     * @throws Exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> editDeveloper(@PathVariable Integer id, @RequestBody DeveloperDTO developerDTO) throws Exception {
        DeveloperEntity developerEntity = ConstantesUtil.getInstance().armarObjetoDeveloper(developerDTO, id);
        this.developerService.save(developerEntity);
        return new ResponseEntity<>("Modificado", HttpStatus.OK);
    }

    /**
     * crear un nuevo registro
     *
     * @return
     * @throws Exception
     */
    @PostMapping()
    public ResponseEntity<Object> saveDeveloper(@RequestBody DeveloperDTO developerDTO) throws Exception {
        DeveloperEntity developerEntity = ConstantesUtil.getInstance().armarObjetoDeveloper(developerDTO, null);
        this.developerService.save(developerEntity);
        return new ResponseEntity<>("Creado", HttpStatus.OK);
    }

    /**
     * Listar todos los developer
     *
     * @return
     * @throws Exception
     */
    @GetMapping()
    public ResponseEntity<Object> listAllDeveloper() throws Exception {
        return new ResponseEntity<>(this.developerService.findAllDeveloperList(), HttpStatus.OK);
    }


    /**
     * eliminar un developer por id
     *
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDeveloper(@PathVariable Integer id) throws Exception {
        this.developerService.delete(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

}
