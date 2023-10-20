package ar.com.users.dao.impl;

import ar.com.users.bean.Persona;
import ar.com.users.dao.PersonaDAO;
import ar.com.users.exceptions.DAOException;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonaDAOImpl implements PersonaDAO {

    private final Function<Persona, String> personToLine = p -> System.getProperty("line.separator") +
            p.getDni() +
            ";" +
            p.getApellido() +
            ";" +
            p.getNombre();
    @SneakyThrows
    private Path getPathFile() {
        return Paths.get(Objects.requireNonNull(this.getClass().getResource("/personas.txt")).toURI());
    }

    @SneakyThrows
    public List<Persona> getAll() {
        Function<String, Persona> lineToPerson = l -> Optional.of(l.split(";"))
                                                            .map(arr -> Persona.builder()
                                                            .dni(Integer.parseInt(arr[0]))
                                                            .apellido(arr[1])
                                                            .nombre(arr[2])
                                                            .build())
                                                            .orElse(null);


        return Files.lines(this.getPathFile())
                     .map(lineToPerson)
                     .collect(Collectors.toList());

    }

    public void save(Persona persona) throws DAOException {
        try {
            Files.writeString(this.getPathFile(), personToLine.apply(persona), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void persistAll(List<Persona> pList) throws DAOException {
        Function<List<Persona>, String> listPersonToLine = lPerson -> lPerson.stream()
                .map(personToLine)
                .reduce("", String::concat);

        try {
            Files.writeString(this.getPathFile(), listPersonToLine.apply(pList), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
