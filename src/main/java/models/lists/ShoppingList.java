package models.lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sange on 16/09/15.
 */
@Entity
@Table(name = "shop_list")
@NamedQueries({
    @NamedQuery(name = "ShoppingList.getAll", query = "SELECT l FROM ShoppingList l WHERE l.crossed = false"),
    @NamedQuery(name = "ShoppingList.getCrossed", query = "SELECT l FROM ShoppingList l WHERE l.crossed = true"),
//    @NamedQuery(name = "ShoppingList.findListMembers", query = "SELECT l FROM ShoppingList l WHERE l.id = :id"),
    @NamedQuery(name = "ShoppingList.countItems", query = "SELECT count(l) FROM ShoppingList l WHERE l.id = :id"),
    @NamedQuery(name = "ShoppingList.deleteItem", query = "DELETE FROM ShoppingList l WHERE l.id = :id"),
    @NamedQuery(name = "ShoppingList.deleteCrossed", query = "DELETE FROM ShoppingList l WHERE l.crossed = true"),
    @NamedQuery(name = "ShoppingList.setCrossItem", query = "UPDATE ShoppingList l SET l.crossed = :crossed WHERE l.id = :id")
})
public class ShoppingList implements IList {

//    privateivate List<Item> items;
//    private List<Item> crossedItems;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "crossed")
    private boolean crossed;

    public ShoppingList(String name) {
        this.name = name;
        this.crossed = false;
    }

    public ShoppingList() {
    }

    public boolean isCrossed() {
        return crossed;
    }

    public void setCrossed(boolean crossed) {
        this.crossed = crossed;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Item> getItemsSL() {
//        return items;
//    }
//
//    public List<Item> getCrossedItems() {
//        return crossedItems;
//    }
//
//    public void crossItem(Item item) {
//        crossedItems.add(item);
//        items.remove(item);
//    }
//
//    public void uncrossItem(Item item) {
//        items.add(item);
//        crossedItems.remove(item);
//    }
//
//    public void sortList() {
//
//    }
//
//    public void clearCrossedList() {
//        crossedItems.clear();
//    }

}
