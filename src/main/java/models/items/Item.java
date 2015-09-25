package models.items;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sange on 16/09/15.
 */
@Entity
@Table(name = "item")
public class Item implements  IItem  {

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

    public Item() {
    }

    public Item(String name, long listId, String description, boolean crossed) {
        this.name = name;
        this.listId = listId;
        this.description = description;
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
