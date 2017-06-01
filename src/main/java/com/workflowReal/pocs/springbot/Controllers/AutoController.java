package com.workflowReal.pocs.springbot.Controllers;

import com.workflowReal.pocs.springbot.Entities.Auto;
import com.workflowReal.pocs.springbot.Services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yo on 1/6/2017.
 */
@RestController
public class AutoController{

    @Autowired
    AutoService autoService;

    @RequestMapping(value = "/autos/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Auto>> getAll(){
        if(autoService.getAll().size() > 0){
            return new ResponseEntity<List<Auto>>(autoService.getAll(), HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<List<Auto>>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/autos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Auto> getById(@PathVariable("id") int id){
        if( autoService.getAutoById(id) != null){
            return new ResponseEntity<Auto>(autoService.getAutoById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Auto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/autos" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Auto>> getByMarca(@RequestParam("marca") String mar){
        if( autoService.getAutosByMarca(mar).size() > 0){
            return new ResponseEntity<List<Auto>>(autoService.getAutosByMarca(mar), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Auto>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/autos/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newAuto(@RequestBody Auto a) {
        try {
            autoService.newAuto(a.getMarca(), a.getModelo(), a.getKilometros(), a.getPatente(), a.getAnio());
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}