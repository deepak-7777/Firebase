package com.example.firebase2;

public class vendor1 {
    public String name;
    public String age;

    public vendor1 () {

    }
    public vendor1 (String name, String age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getAge () {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
