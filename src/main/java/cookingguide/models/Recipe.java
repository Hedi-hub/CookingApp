package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recipes")
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
    @Column(name="calories")
    private int calories;
    @Column(name="origin_description")
    private String originDescription;

    public Recipe(){}
    public Recipe(String name, List<Ingredient> list1, int portion, int calories, String originDescription) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.portion = portion;
        this.originDescription = originDescription;
        this.calories = calories;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getOriginDescription() {
        return originDescription;
    }

    public void setOriginDescription(String originDescription) {
        this.originDescription = originDescription;
    }
}
