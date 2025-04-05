public class Teacher extends Human
{
    String speciality;
    int experience;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Teacher(String lastName, String firstName, int age, String speciality, int experience) {
        super(lastName, firstName, age);
        this.speciality = speciality;
        this.experience = experience;
        System.out.println("TConstructor:\t" + Integer.toHexString(this.hashCode()));
    }

    @Override
    public String toString() {
        return super.toString() + ' ' +
                speciality + ' ' +
                experience;
    }
}
