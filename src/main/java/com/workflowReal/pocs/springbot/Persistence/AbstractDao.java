package com.workflowReal.pocs.springbot.Persistence;

import java.util.List;

/**
 * Created by yo on 29/5/2017.
 */
public abstract class AbstractDao<K> {
    public AbstractDao() {

    }
    abstract List<K> getAll();
    abstract K getById(int id);
    abstract void save(K value);
}