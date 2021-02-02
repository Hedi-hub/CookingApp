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
//    @Column(name="ingredient")
//    private ArrayList<Ingredient> ingredients;
    @Column(name="portion")
    private int portion;
    @Column(name="calories")
    private int calories;
    @Column(name="origin_description")
    private String originDescription;
    // *** add the description here ***
    //private String imagePath;

    //Added @OneToMany Annotation for the list of ingredient
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Column(name="ingredients")
    private List<Ingredient> ingredientList = new ArrayList<>();


    public Recipe(){}
    public Recipe(String name, int portion, int calories, String originDescription) {
        this.name = name;
        this.ingredientList = new ArrayList<Ingredient>();
        this.portion = portion;
        this.originDescription = originDescription;
        this.calories = calories;
        //this.imagePath = imagePath;
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


// ***I should chang my ingredient to ingredientList to match the @OneToMany Annotation***
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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

//    public String getImagePath() {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
}
