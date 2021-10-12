package cookingguide.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="customers")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;

    @Column(name="full_name")
    private String fullName;
    @Column(name="email")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="location")
    private String location;
    @Column(name="gender")
    private String gender;
    @Column(name="badge")
    private Badge badge;
    @Column(name="profile_image")
    private String imagePath;
    @Column(name = "countOfRecipes")
    private int recipeCount;


    public User(){
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialNonExpired=true;
        this.isEnabled=true;
        this.badge=Badge.NEWBIE;
        this.recipeCount =0;
    }

    public User(String fullName, String username, String password, String location,String gender) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialNonExpired=true;
        this.isEnabled=true;
        this.gender= gender;
        this.badge=Badge.NEWBIE;
        if (this.gender.equalsIgnoreCase("male")){
            this.imagePath = "/images/male-profile.png";
        }else{
            this.imagePath = "/images/female-profile.png";
        }
        this.recipeCount =0;

    }
    @OneToMany(
            targetEntity=Recipe.class, mappedBy="user",
            fetch = FetchType.LAZY)
    private Set<Recipe> recipes;


    @Transient
    private boolean accountNonExpired;
    @Transient
    private boolean accountNonLocked;
    @Transient
    private boolean credentialNonExpired;
    @Transient
    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBadge() {
        return badge.getBadgeWording();
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setRecipeCount(int recipeCount) {
        this.recipeCount = recipeCount;
    }

    public int getRecipeCount() {
        return recipeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", badge='" + badge + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialNonExpired=" + credentialNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
