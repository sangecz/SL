package services;

import models.items.IItem;
import models.items.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sange on 29/09/15.
 */
@Stateless
public class ItemService {

    @PersistenceContext
    private EntityManager em;


    public void addItem(IItem i) {
        em.persist(i);
    }

    public List<IItem> getItemsSL(long listId) {
        TypedQuery<IItem> l = em.createNamedQuery("Item.getItemsFromList", IItem.class);
        l.setParameter("listId", listId);
        return l.getResultList();
    }
}
