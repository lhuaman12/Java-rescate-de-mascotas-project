package domain.repositories;

import domain.entities.mascotas.Mascota;
import domain.repositories.daos.DAO;

public class RepositorioDeMascotas extends Repositorio<Mascota> {
    public RepositorioDeMascotas(DAO<Mascota> dao) {
        super(dao);
    }



}
