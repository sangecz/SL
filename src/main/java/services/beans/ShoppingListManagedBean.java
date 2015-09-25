package services.beans;

import models.lists.ShoppingList;
import services.DatabaseManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import java.util.ResourceBundle;

/**
 * Created by sange on 16/09/15.
 */

@ManagedBean(name = "shoppingList")
@RequestScoped
public class ShoppingListManagedBean {

    @NotNull
    private String name;
    @ManagedProperty("#{database}")
    private DatabaseManagedBean database;

    private ResourceBundle bundle = ResourceBundle.getBundle("navigation");

    public ShoppingListManagedBean() {
    }

    public String add() {
        ShoppingList l = new ShoppingList(name);
        database.addList(l);
//        return "showShoppingLists";
        return bundle.getString("shoppingLists");
    }

    public String cross(long id, boolean crossed){
        database.crossShoppingListById(id, crossed);
        return bundle.getString("shoppingLists");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDatabase(DatabaseManagedBean database) {
        this.database = database;
    }
}
