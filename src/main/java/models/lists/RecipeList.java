package models.lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sange on 23/09/15.
 */
@Entity
@Table(name = "recipe_list")
@NamedQueries({
        @NamedQuery(name = "RecipeList.getAll", query = "SELECT l FROM RecipeList l WHERE l.crossed = false"),
        @NamedQuery(name = "RecipeList.getCrossed", query = "SELECT l FROM RecipeList l WHERE l.crossed = true"),
//    @NamedQuery(name = "RecipeList.findListMembers", query = "SELECT l FROM RecipeList l WHERE l.id = :id"),
        @NamedQuery(name = "RecipeList.countItems", query = "SELECT count(l) FROM RecipeList l WHERE l.id = :id"),
        @NamedQuery(name = "RecipeList.deleteItem", query = "DELETE FROM RecipeList l WHERE l.id = :id"),
        @NamedQuery(name = "RecipeList.deleteCrossed", query = "DELETE FROM RecipeList l WHERE l.crossed = true"),
        @NamedQuery(name = "RecipeList.setCrossItem", query = "UPDATE RecipeList l SET l.crossed = :crossed WHERE l.id = :id")
})
public class RecipeList implements IList {

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
//    private static int sequence = 2;

    public RecipeList(String name) {
        this.name = name;
        this.crossed = false;
    }

    public RecipeList() {
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

    public boolean isCrossed() {
        return crossed;
    }

    public void setCrossed(boolean crossed) {
        this.crossed = crossed;
    }
}
