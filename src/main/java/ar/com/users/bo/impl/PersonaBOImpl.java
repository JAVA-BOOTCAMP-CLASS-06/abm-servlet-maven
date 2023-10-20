package ar.com.users.bo.impl;

import ar.com.users.bean.Persona;
import ar.com.users.bo.PersonaBO;
import ar.com.users.dao.PersonaDAO;
import ar.com.users.dao.impl.PersonaDAOImpl;
import ar.com.users.exceptions.DAOException;
import ar.com.users.exceptions.DNIDuplicateBOException;
import ar.com.users.exceptions.NotFoundBOException;

import java.util.*;

public class PersonaBOImpl implements PersonaBO {

    private final PersonaDAO personaDAO;

    private final Map<Integer, Persona> personas;

    public PersonaBOImpl() {
        personaDAO = new PersonaDAOImpl();
        personas = new HashMap<>();
        this.initMap();
    }

    private void initMap() {
        personaDAO.getAll()
                .forEach(p -> personas.put(p.getDni(), p));
    }
    @Override
    public List<Persona> getAll() {
        return new ArrayList<>(personas.values());
    }

    @Override
    public Persona getByDni(Integer dni) throws NotFoundBOException {
        return Optional.of(personas)
                .filter(p -> p.containsKey(dni))
                .map(p -> p.get(dni))
                .orElseThrow(NotFoundBOException::new);
    }

    @Override
    public Persona save(Persona persona) throws DNIDuplicateBOException {
        return Optional.of(personas)
                .filter(p -> !p.containsKey(persona.getDni()))
                .map(mapPer -> addPersonToMap(persona))
                .orElseThrow(DNIDuplicateBOException::new);
    }

    @Override
    public int delete(Integer dni) {
        return Optional.of(personas)
                .filter(p -> p.containsKey(dni))
                .map(mapPer -> {
                    personas.remove(dni);
                    try {
                        personaDAO.persistAll(this.getAll());
                    } catch (DAOException e) {
                        throw new RuntimeException(e);
                    }
                    return  1;
                })
                .orElse(0);
    }


    private Persona addPersonToMap(Persona persona) {
        personas.put(persona.getDni(), persona);
        try {
            personaDAO.save(persona);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
        return persona;
    }
}
