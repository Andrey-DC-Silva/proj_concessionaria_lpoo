package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Veiculo;

public class VeiculoDAO extends PersistenciaJPA {

    public List<Veiculo> listaVeiculos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Veiculo> query
                    = em.createQuery("SELECT v FROM Veiculo v", Veiculo.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Veiculo> query = em.createQuery(
                    "SELECT v FROM Veiculo v WHERE v.placa = :placa", Veiculo.class);
            query.setParameter("placa", placa);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
}
