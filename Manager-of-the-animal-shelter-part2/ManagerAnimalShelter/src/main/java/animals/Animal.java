package animals;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="Animal")
public class Animal {
	@Id
	@GeneratedValue
	private int id;
    private String name_ = null;
    private int age_ = 0;
   
    public Animal() {
    
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal(String name_, int age_) {
		this.name_ = name_;
		this.age_ = age_;
	}

    @XmlAttribute(name="name")
	public String getName_() {
		return name_;
	}


	public void setName_(String name_) {
		this.name_ = name_;
	}

	@XmlAttribute(name="age")
	public int getAge_() {
		return age_;
	}


	public void setAge_(int age_) {
		this.age_ = age_;
	}


	@Override
    public String toString() {
        return "Animal{" +
                "name='" + name_ + '\'' +
                ", age=" + age_ +
                '}';
    }
}
