package domain.repositories.factories;

import config.Config;
import domain.entities.mascotas.Mascota;
import domain.repositories.RepositorioDeMascotas;
import domain.repositories.daos.DAO;
import domain.repositories.daos.DAOHibernate;
import domain.repositories.daos.DAOMemoria;
import domain.repositories.testMemoData.Data;

public class FactoryRepositorioMascotas {
    private static RepositorioDeMascotas repo;

    static {
        repo = null;
    }

    public static RepositorioDeMascotas get() {
        if(repo == null) {
            if(Config.useDataBase) {
                DAO<Mascota> dao = new DAOHibernate<>(Mascota.class);
                repo = new RepositorioDeMascotas(dao);
            }
            else {
                repo = new RepositorioDeMascotas(new DAOMemoria<>(Data.getData(Mascota.class)));
            }
        }
        return repo;
    }

}