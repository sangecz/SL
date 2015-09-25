package models.items;

/**
 * Created by sange on 25/09/15.
 */
public interface IItem {
    public long getId();

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public boolean isCrossed();

    public void setCrossed(boolean crossed);

    public long getListId();

    public void setListId(long listId);
}
