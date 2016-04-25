package tdm.miniproject.job;


import java.util.ArrayList;

public class Category extends ArrayList<Product> {
    private String code;
    private String name;
    private String description;
    private int categoryIcon;

    public int getCategoryIcon() {
        return categoryIcon;
    }



    public Category(String name,int categoryIcon) {
        this.name = name;
        this.categoryIcon=categoryIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
