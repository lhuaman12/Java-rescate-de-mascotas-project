package domain.controllers;

import domain.entities.mascotas.MascotaBasica;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;

public class MascotaController {

    private Repositorio<MascotaBasica> repositorio;

    public MascotaController() {
        this.repositorio = FactoryRepositorio.get(MascotaBasica.class);
    }
}
