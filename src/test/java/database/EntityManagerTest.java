package database;

import db.EntityManagerHelper;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class EntityManagerTest {

    @Test
    public void persistirLoginTest() {
        Login login = new Login();
        login.setUsername("test");
        login.setPassword("123456");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(login);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperarLoginTest() {
        Login login = (Login) EntityManagerHelper.createQuery("from Login where username = 'test'").getSingleResult();
        Assert.assertEquals("test", login.getUsername());
    }

    @Test
    public void persistirUsuarioAlternativoTest() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("123456789");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
    }

}


