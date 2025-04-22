package org.openjfx.academyfx_mvc.Model;

import javafx.beans.property.*;

import java.util.Date;

public class Human {
    private final IntegerProperty id;
    private final StringProperty lastName;
    private final StringProperty firstName;
    private final StringProperty middleName;
    private final ObjectProperty<Date> birthDate;

    public Human(Integer id, String lastName, String firstName, String middleName, Date birthDate)
    {
        this.id = new SimpleIntegerProperty(id);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.birthDate = new SimpleObjectProperty<>(birthDate);
    }
    public IntegerProperty idProperty()
    {
        return id;
    }
    public  StringProperty lastNameProperty()
    {
        return lastName;
    }
    public  StringProperty firstNameProperty()
    {
        return firstName;
    }
    public  StringProperty middleNameProperty()
    {
        return middleName;
    }
    public ObjectProperty<Date> birthDateProperty()
    {
        return birthDate;
    }

    public final Integer getId()
    {
        return id.get();
    }
    public final String getLastName()
    {
        return lastName.get();
    }
    public final String getFirstName()
    {
        return firstName.get();
    }
    public final String getMiddleName()
    {
        return middleName.get();
    }
    public final Date getBirthDate()
    {
        return birthDate.get();
    }
    public final void setId(Integer id)
    {
        this.id.set(id);
    }
    public final  void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }
    public final  void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }
    public final void setMiddleName(String middleName)
    {
        this.middleName.set(middleName);
    }
    public final void setBirthDate(Date birthDate)
    {
        this.birthDate.set(birthDate);
    }
}