package Interfaces;

import Modelo.Persona;
import java.util.List;

public interface CRUD {
    
    public List listar();
    public Persona list(int id_doc);
    public void add(Persona per);
    public void edit(Persona per);
    public void eliminar(int id_doc);
    
}
