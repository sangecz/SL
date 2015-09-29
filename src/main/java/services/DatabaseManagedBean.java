package services;

import models.User;
import models.items.IItem;
import models.items.Item;
import models.lists.IList;
import models.lists.RecipeList;
import models.lists.ShoppingList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sange on 16/09/15.
 */
@ManagedBean(name = "database")
@SessionScoped
public class DatabaseManagedBean implements Serializable {

    @EJB
    private ShoppingListService shoppingListService;
    @EJB
    private ItemService itemService;
    @EJB
    private RecipeListService recipeListService;
    @EJB
    private UserService userManager;

    public DatabaseManagedBean() {
    }

    public List<User> getAllUsers(){
        return userManager.getAll();
    }

    // SHOPPING LIST
    public void addList(IList l) {
        if(l instanceof  ShoppingList) {
            shoppingListService.addList(l);
        } else if (l instanceof RecipeList){
            recipeListService.addList(l);
        }
    }

    public List<IList> getShoppingLists() {
        return shoppingListService.getLists();
    }

    public List<IList> getCrossedShoppingLists() {
        return shoppingListService.getCrossedLists();
    }

    public Long numberOfItemsShoppingList(Integer groupId) {
        return shoppingListService.numberOfItems(groupId);
    }

    public void deleteCrossedShoppingLists() {
        shoppingListService.deleteCrossedLists();
    }

    public void crossShoppingListById(long id, boolean crossed) {
        shoppingListService.crossListById(id, crossed);
    }

    public void getItemsSL(long listId) {
        itemService.getItemsSL(listId);
    }

    public void addItemSL(IItem i) {
        if(i instanceof  Item) {
            itemService.addItem(i);
        }
//        else if (l instanceof RecipeList){
//            recipeListService.addList(l);
//        }
    }

    // RECIPE LIST

    public List<IList> getRecipeLists() {
        return recipeListService.getLists();
    }

    public List<IList> getCrossedRecipeLists() {
        return recipeListService.getCrossedLists();
    }

    public Long numberOfItemsRecipeList(Integer groupId) {
        return recipeListService.numberOfItems(groupId);
    }

    public void deleteCrossedRecipeLists() {
        recipeListService.deleteCrossedLists();
    }

    public void crossRecipeListById(long id, boolean crossed) {
        recipeListService.crossListById(id, crossed);
    }



}