package types.people;
public class Hygienist extends Partner {

    private final int appointmentLength = 20;

    /**
     * @param title
     * @param name
     * @param surname
     */
    public Hygienist(String title, String name, String surname) {
        super(title, name, surname);
    }

}
