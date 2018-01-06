package types.people;
public class Dentist extends Partner {

    private final int appointmentType = 60;

    /**
     * @param title
     * @param name
     * @param surname
     */
    public Dentist(String title, String name, String surname) {
        super(title, name, surname);
    }

}
