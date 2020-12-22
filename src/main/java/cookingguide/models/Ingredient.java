package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="ingredient_name")
    private String IngredientName;
    @Column(name="calories")
    private int calories;
    @@Column(name="amount")
    private int amount;
    @Column(name="unit_measurement")
    private UnitOfMeasurements unitOfMeasurements;

    public Ingredient(String ingredientName, int calories, int amount, UnitOfMeasurements unitOfMeasurements) {
        IngredientName = ingredientName;
        this.calories = calories;
        this.amount = amount;
        this.unitOfMeasurements = unitOfMeasurements;
    }

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UnitOfMeasurements getUnitOfMeasurements() {
        return unitOfMeasurements;
    }

    public void setUnitOfMeasurements(UnitOfMeasurements unitOfMeasurements) {
        this.unitOfMeasurements = unitOfMeasurements;
    }
}
