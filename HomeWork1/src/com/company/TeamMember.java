package com.company;

public class TeamMember {
    final String name; // имя участника
    final String sex; // пол
    private int weight; // вес в кило
    private int height; // рост в см
    private int age; // возраст лет
    private float physicalCondition; // физические возможности
    private boolean result; // результат прохождения полосы

    TeamMember ( String name, String sex, int weight, int height, int age, int physicalCondition, boolean result ) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.physicalCondition = physicalCondition;
        this.result = result;
    }

    public void setPhysicalCondition(float physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }

    public float getPhysicalCondition() {
        return physicalCondition;
    }

    @Override
    public String toString () {
        return ("Name: " + name + "   Sex: " + sex + "   Weight: " + weight + "   Height: " + height
                + "   Age: " + age + "   Physical Condition (%): " + physicalCondition);
    }
}
