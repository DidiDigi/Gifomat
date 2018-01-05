package cz.czechitas.gifomat;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    public String jmeno;
    public String surname;
    public Integer age;

    public Adresa adresa;

    public User(String name) {
        this.jmeno = name;
    }
}
