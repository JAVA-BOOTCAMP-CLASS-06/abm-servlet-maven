package ar.com.users.dao;

import ar.com.users.bean.Persona;
import ar.com.users.exceptions.DAOException;

import java.util.List;

public interface PersonaDAO {
    List<Persona> getAll();

    void save(Persona p) throws DAOException;

    void persistAll(List<Persona> pList) throws DAOException;
}
