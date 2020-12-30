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
    @Column(name="amount")
    private double amount;
    @Column(name="unit_measurement")
    private UnitOfMeasurements unitOfMeasurements;

    public Ingredient(){}
    public Ingredient(String ingredientName, double amount, UnitOfMeasurements unitOfMeasurements) {
        IngredientName = ingredientName;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UnitOfMeasurements getUnitOfMeasurements() {
        return unitOfMeasurements;
    }

    public void setUnitOfMeasurements(UnitOfMeasurements unitOfMeasurements) {
        this.unitOfMeasurements = unitOfMeasurements;
    }
}
