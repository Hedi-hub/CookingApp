package cookingguide.models;

import javax.persistence.*;

@Entity
@Table
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
