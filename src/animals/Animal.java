package animals;

public class Animal {
    private String name_;
    private int age_;

    public String getName_() {
        return name_;
    }

    public int getAge_() {
        return age_;
    }

    public static final class Builder {
        private String name_;
        private int age_;

        public Builder name(String name) {
            this.name_ = name;
            return this;
        }

        public Builder age(int age) {
            this.age_ = age;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal();
            animal.name_ = this.name_;
            animal.age_ = this.age_;
            return animal;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name_ + '\'' +
                ", age=" + age_ +
                '}';
    }
}
