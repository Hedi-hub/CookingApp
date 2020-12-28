package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="recipe_name")
    private String name;
    @Column(name="ingredient")
    private ArrayList<Ingredient> ingredients;
    @Column(name="portion")
    private int portion;
    @Column(name="origin_description")
    private String originDescription;

    public Recipe(){}
    public Recipe(String name, int portion, String originDescription) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.portion = portion;
        this.originDescription = originDescription;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public String getOriginDescription() {
        return originDescription;
    }

    public void setOriginDescription(String originDescription) {
        this.originDescription = originDescription;
    }
}
