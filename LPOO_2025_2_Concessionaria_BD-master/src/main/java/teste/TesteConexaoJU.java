package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConexaoJU {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_concessionaria");
        EntityManager em = emf.createEntityManager();

        if (em.isOpen()) {
            System.out.println("✅ Conexão aberta com sucesso!");
        } else {
            System.out.println("❌ Falha ao abrir conexão.");
        }

        em.close();
        emf.close();
    }
}
