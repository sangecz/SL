package models.lists;

/**
 * Created by sange on 29/09/15.
 */
public interface IList {

    public long getId();

    public String getName();

    public void setName(String name);

    public boolean isCrossed();

    public void setCrossed(boolean crossed);
}


