package org.openjfx.academyfx_mvc.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Direction {
    private final IntegerProperty directionId;
    private final StringProperty directionName;

    public Direction(Integer direction_id, String direction_name) {
        this.directionId = new SimpleIntegerProperty(direction_id);
        this.directionName = new SimpleStringProperty(direction_name);
    }

    public IntegerProperty directionIdProperty() {
        return directionId;
    }
    public final Integer getDirectionId()
    {
        return directionId.get();
    }
    public final void setDirectionId(Integer directionId)
    {
        this.directionId.set(directionId);
    }

    public StringProperty directionNameProperty()
    {
        return directionName;
    }
    public final String getDirectionName()
    {
        return directionName.get()  ;
    }
    public final void setDirectionName(String direction_name)
    {
        this.directionName.set(direction_name);
    }
}