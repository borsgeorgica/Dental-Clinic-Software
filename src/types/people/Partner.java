package types.people;
public class Partner {

    private String title;
    private String name;
    private String surname;
    private int id;


    /**
     * @param title
     * @param name
     * @param surname
     */
    public Partner(String title, String name, String surname) {

        this.title = title;
        this.name = name;
        this.surname = surname;
    }
    
    public Partner(int id,String title, String name, String surname) {

        this(title,name, surname);
        this.id = id;
        
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname
     *            the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
