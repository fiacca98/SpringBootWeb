package org.its.dl.dataaccess;

import org.its.dl.entity.UtenteDL;

import java.util.List;

public interface UserDL {
    List<UtenteDL> getAll();

    UtenteDL add(UtenteDL utenteDL);

    boolean delete(Integer id);

    boolean update(UtenteDL utenteDL) throws Exception;

    UtenteDL getById(Integer id);
}
