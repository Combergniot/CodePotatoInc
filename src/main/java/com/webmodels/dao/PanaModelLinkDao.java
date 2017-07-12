package com.webmodels.dao;

import com.webmodels.data.PanaModelLinksCollectorForDb;
import com.webmodels.model.PanaModelLink;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PanaModelLinkDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    EntityManager em;

    @Transactional
    public void persistPanaModelLink(PanaModelLink panaModelLink) {
        em.persist(panaModelLink);
    }

    public void getPanaModelLinkById(Long id) {
    }

    @Transactional
    public boolean truncateLinks() {
        boolean success = false;
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaDelete<PanaModelLink> query = builder.createCriteriaDelete(PanaModelLink.class);
            query.from(PanaModelLink.class);
            em.createQuery(query).executeUpdate();
            success = true;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            success = false;
        }
        return success;
    }

    @Transactional
    public void persistLinks(List<PanaModelLink> links) {
        for (PanaModelLink link : links) {
            persistPanaModelLink(link);
        }
    }

    public List<String> getAllModelSymbols() {
        List<String> symbolList = new ArrayList<>();
        TypedQuery<String> query = em.createQuery("select DISTINCT (p.modelSymbol) from PanaModelLink p ORDER BY p.modelSymbol", String.class);
        symbolList = query.getResultList();
        System.out.println(symbolList);
        System.out.println("Symboli w bazie: " + symbolList.size());
        //  try {
        //      TypedQuery<PanaModelLink> query = em.createQuery("select p from PanaModelLink p", PanaModelLink.class );
        //   System.out.println(query.getResultList());

        //   } catch (Exception e) {
        //  e.printStackTrace();
        //   }
        return symbolList;
    }

    public List<PanaModelLink> getLinksFromModelSymbol(String symbol) {
        TypedQuery<PanaModelLink> query = em.createQuery("select  p from PanaModelLink p WHERE p.modelSymbol = :symbol ORDER BY p.countryId", PanaModelLink.class);
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }

    @Transactional
    public boolean reloadDb() {
        boolean success = false;
        PanaModelLinksCollectorForDb pmlc = new PanaModelLinksCollectorForDb();
        try {
            List<PanaModelLink> links = pmlc.collectAllLinks();
            for (PanaModelLink link : links) {
                persistPanaModelLink(link);
            }
            success = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Zjebalo sie w reloadDB");
            success = false;
        }

        return success;
    }

}
