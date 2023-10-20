package ar.com.users.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Persona {
    private int dni;
    private String apellido;
    private String nombre;
 }
