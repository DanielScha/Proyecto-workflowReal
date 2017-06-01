package com.workflowReal.pocs.springbot.Services;

import com.workflowReal.pocs.springbot.Entities.Auto;
import com.workflowReal.pocs.springbot.Entities.Marca;
import com.workflowReal.pocs.springbot.Persistence.AutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yo on 1/6/2017.
 */
@Service
public class AutoService {
    private AutoDao autoDao;

    @Autowired
    public AutoService(AutoDao aD){
        autoDao = aD;
    }

    public List<Auto>getAll(){
        return autoDao.getAll();
    }

    public Auto getAutoById(int id){
        return autoDao.getById(id);
    }
    public Auto getAutoByPatente(String p){
        return autoDao.getByPatente(p);
    }
    public List<Auto> getAutosByMarca(String m){
        return autoDao.getByMarca(m);
    }

    public void newAuto(Marca ma, String mo, int k, String p, int a){
        Auto au = new Auto();
        au.setMarca(ma);
        au.setModelo(mo);
        au.setKilometros(k);
        au.setPatente(p);
        au.setAnio(a);
        autoDao.save(au);
    }

}
