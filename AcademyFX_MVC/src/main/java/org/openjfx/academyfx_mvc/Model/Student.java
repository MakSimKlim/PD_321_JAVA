package org.openjfx.academyfx_mvc.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

//import javax.print.

public class Student extends Human
{
    private final IntegerProperty group;

    public Student(Integer id, String lastName, String firstName, String middleName, Date birthDate, String groupName) {
        super(id, lastName, firstName, middleName, birthDate);
        this.group = new SimpleIntegerProperty(group);
        this.groupName = new SimpleStringProperty(groupName);
    }

    public IntegerProperty groupProperty()
    {
        return group;
    }
    public Integer getGroup()
    {
        return group.get();
    }
    public final void setGroup(Integer group)
    {
        this.group.set(group);
    }
    /// //////////////////////////////////////////////////////
    // Navigation properties:

    private final StringProperty groupName;
    public StringProperty groupNameProperty()
    {
        return groupName;
    }
    public final String getGroupName()
    {
        return groupName.get();
    }
    public final void setGroupName(String groupName)
    {
        this.groupName.set(groupName);
    }
}