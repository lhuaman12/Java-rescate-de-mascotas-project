package domain.Organizaciones.UsuariosOrg;

import domain.Usuarios.Administrador;
import domain.Usuarios.Voluntario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosOrganizacion {
    private List<Voluntario> voluntarios;
    private List<Administrador> administradores;

    public UsuariosOrganizacion() {
        this.voluntarios = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }

    public void agregarVoluntario(Voluntario voluntario) {
        this.voluntarios.add(voluntario);
    }

    public void agregarAdministrador(Administrador administrador) {
        this.administradores.add(administrador);
    }
    public void quitarVoluntario(Voluntario voluntario) {
        this.voluntarios.remove(voluntario);
    }

    public void quitarAdministrador(Administrador administrador) {
        this.administradores.remove(administrador);
    }
}
