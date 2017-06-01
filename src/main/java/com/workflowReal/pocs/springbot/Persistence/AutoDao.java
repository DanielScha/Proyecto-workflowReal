package com.workflowReal.pocs.springbot.Persistence;

import com.workflowReal.pocs.springbot.Entities.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yo on 1/6/2017.
 */
@Repository
public class AutoDao extends AbstractDao<Auto> {

    private List<Auto> list;
    private static int LAST_ID = 0;

    public AutoDao(){
        super();
        this.list = new ArrayList<Auto>();
    }
    public List<Auto> getAll() {
        return list;
    }
    public Auto getById(int id) {
        for(Auto a : list){
            if (id == a.getId()){
                return a;
            }
        }
        return null;
    }
    public Auto getByPatente(String p) {
        for(Auto a : list){
            if (a.getPatente().equals(p)){
                return a;
            }
        }
        return null;
    }
    public List<Auto> getByMarca(String desMar) {
        List<Auto> result = new ArrayList<Auto>();
        for (Auto a : list) {
            if (desMar.equals(a.getMarca().getDescripcion()))
                result.add(a);
        }
        return result;
    }

    public void save(Auto auto) {
        auto.setId(++LAST_ID);
        list.add(auto);
    }
}
