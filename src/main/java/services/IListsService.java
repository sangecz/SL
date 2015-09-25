package services;

import models.lists.IList;
import models.lists.ShoppingList;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sange on 23/09/15.
 */
public interface IListsService {

    public void addList(IList l);

    public List<IList> getLists();

    public Long numberOfItems(Integer listId);

    public void deleteCrossedLists();

    public List<IList> getCrossedShoppingLists();

    public void crossListById(long id, boolean crossed);
}
