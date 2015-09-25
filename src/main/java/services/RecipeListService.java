package services;

import models.lists.IList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sange on 16/09/15.
 */

@Stateless
public class RecipeListService  {

    @PersistenceContext
    private EntityManager em;

    public void addList(IList l) {
        em.persist(l);
    }

    public List<IList> getLists() {
        TypedQuery<IList> l = em.createNamedQuery("RecipeList.getAll", IList.class);
        return l.getResultList();
    }

    public Long numberOfItems(Integer listId) {
        TypedQuery<Long> l = em.createNamedQuery("RecipeList.countItems", Long.class);
        l.setParameter("id", listId);
        return l.getSingleResult();
    }

    public void deleteCrossedLists() {
        TypedQuery<Long> l = em.createNamedQuery("RecipeList.deleteCrossed", Long.class);
        l.executeUpdate();
    }

    public List<IList> getCrossedLists() {
        TypedQuery<IList> l = em.createNamedQuery("RecipeList.getCrossed", IList.class);
        return l.getResultList();
    }

    public void crossListById(long id, boolean crossed) {
        TypedQuery<Long> l = em.createNamedQuery("RecipeList.setCrossItem", Long.class);
        l.setParameter("id", id);
        l.setParameter("crossed", crossed);
        l.executeUpdate();
    }
}
