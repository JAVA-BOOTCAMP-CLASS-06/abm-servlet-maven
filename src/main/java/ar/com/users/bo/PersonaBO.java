package ar.com.users.bo;

import ar.com.users.bean.Persona;
import ar.com.users.exceptions.DNIDuplicateBOException;
import ar.com.users.exceptions.NotFoundBOException;

import java.util.List;

public interface PersonaBO {
    List<Persona> getAll();

    Persona getByDni(Integer dni) throws NotFoundBOException;

    Persona save(Persona persona) throws DNIDuplicateBOException;

    int delete(Integer dni);
}
