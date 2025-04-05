public class Human
{
    String lastName;
    String firstName;
    int age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        System.out.println("HConstructor:\t"+Integer.toHexString(this.hashCode()));
    }

    @Override
    public String toString() {
        return super.toString() + ":" +
                lastName + ' ' +
                firstName + ' ' +
                age;
    }
}
