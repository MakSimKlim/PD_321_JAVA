package org.openjfx.academyfx_mvc.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

public class Student extends Human
{
    private final IntegerProperty group;

    public Student(Integer id, String lastName, String firstName, String middleName, Date birthDate, Integer group) {
        super(id, lastName, firstName, middleName, birthDate);
        this.group = new SimpleIntegerProperty(group);
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
}