package com.workflowReal.pocs.springbot.Persistence;

import com.workflowReal.pocs.springbot.Entities.Marca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yo on 29/5/2017.
 */
@Repository
public class MarcaDao extends AbstractDao<Marca>{
    List<Marca> list;
    static int LAST_ID = 0;


    public MarcaDao() {
        super();
        this.list = new ArrayList<Marca>();

    }

    public List<Marca> getAll() {
        return list;
    }

    public void save(Marca m ) {
        m.setId(++LAST_ID);
        list.add(m);
    }


    public Marca getById(int id) {
        for (Marca m : list) {
            if (id == m.getId())
                return m;
        }
        return null;
    }
}