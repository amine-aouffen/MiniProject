package tdm.miniproject.job;


import tdm.miniproject.support.ListeProduits;

public class Category extends ListeProduits {
    private String code;
    private String name;
    private String description;
    private String categoryIcon;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
