package cookingguide.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String IngredientName;
    private double amount;
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
