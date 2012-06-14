package org.projekt.service;

import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.projekt.domain.Sklep;

@Stateful
@Named
public class SklepService {
    
    @PersistenceContext(unitName = "jaz8160_PU")
    private EntityManager em;
    
    public List<Sklep> getSklepy() {
        return em.createQuery("select s from Sklep s").getResultList();
    }
    
    public void delete(Sklep sklep) {
        sklep = em.merge(sklep);
        em.remove(sklep);
    }
 
    public void update(Sklep sklep) {
        em.merge(sklep);
    }
}
