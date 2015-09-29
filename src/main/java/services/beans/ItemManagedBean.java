package services.beans;

import models.items.Item;
import services.DatabaseManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.util.ResourceBundle;

/**
 * Created by sange on 29/09/15.
 */
@ManagedBean(name = "item")
@ViewScoped
public class ItemManagedBean {

    @NotNull
    private String name;
    @ManagedProperty("#{database}")
    private DatabaseManagedBean database;

//    @ManagedProperty(value = "#{param.listId}")
    private long listId;

    private ResourceBundle bundle = ResourceBundle.getBundle("navigation");

    public ItemManagedBean() {
    }

    public String add(long listId) {
        System.out.println("XXXlistId: " + listId);
        Item i = new Item(name, listId, null, false);
        database.addItemSL(i);
        return bundle.getString("items");
    }
    public String add() {
        System.out.println("YYYlistId: " + listId);
        Item i = new Item(name, listId, null, false);
        database.addItemSL(i);
        return bundle.getString("items");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatabaseManagedBean getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseManagedBean database) {
        this.database = database;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        System.out.println("AAA=" + listId);
        this.listId = listId;
    }
}
