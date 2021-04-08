package cookingguide.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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
    @Column(name="flocation")
    private String location;

    public User(){
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialNonExpired=true;
        this.isEnabled=true;
    }

    public User(String fullName, String username, String password, String location) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.accountNonExpired=true;
        this.accountNonLocked=true;
        this.credentialNonExpired=true;
        this.isEnabled=true;
    }


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
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialNonExpired=" + credentialNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
