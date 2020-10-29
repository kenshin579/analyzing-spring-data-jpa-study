package me.freelife.springjpaprograming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Freelife {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
