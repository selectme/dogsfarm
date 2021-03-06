package by.leverx.learn.mudrahelau.model.dog;

/**
 * @author Viktar on 10.05.2020
 */
public class Dog {

    private String name;
    private double age;
    private boolean isHealthy;
    private boolean isFed;
    private boolean isTrained;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        isFed = fed;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (Double.compare(dog.age, age) != 0) return false;
        return name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(age);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
