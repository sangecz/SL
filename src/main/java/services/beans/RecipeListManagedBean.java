package services.beans;

import models.lists.RecipeList;
import services.DatabaseManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import java.util.ResourceBundle;

/**
 * Created by sange on 16/09/15.
 */

@ManagedBean(name = "recipeList")
@RequestScoped
public class RecipeListManagedBean {

    @NotNull
    private String name;
    @ManagedProperty("#{database}")
    private DatabaseManagedBean database;

    private ResourceBundle bundle = ResourceBundle.getBundle("navigation");

    public RecipeListManagedBean() {
    }

    public String add() {
        RecipeList l = new RecipeList(name);
        database.addList(l);
//        return "showShoppingLists";
        return bundle.getString("recipeLists");
    }

    public String cross(long id, boolean crossed){
        database.crossRecipeListById(id, crossed);
        return bundle.getString("recipeLists");
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
