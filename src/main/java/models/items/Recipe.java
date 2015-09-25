package models.items;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sange on 25/09/15.
 */

@Entity
@Table(name = "recipe")
public class Recipe implements IItem     {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "crossed")
    private boolean crossed;

    @NotNull
    @Column(name = "list_id")
    private long listId;


    public Recipe(String name, String description, boolean crossed, long listId) {
        this.name = name;
        this.description = description;
        this.crossed = crossed;
        this.listId = listId;
    }

    public Recipe() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCrossed() {
        return crossed;
    }

    public void setCrossed(boolean crossed) {
        this.crossed = crossed;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }
}