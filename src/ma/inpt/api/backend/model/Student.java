package ma.inpt.api.backend.model;

public class Student {
	
	public static Long i = 1l;
	
	private Long id;
	
	private String name;
	
	private String city;

	public Student() {
		super();
	}

	public Student(String name, String city) {
		super();
		this.id = i++;
		this.name = name;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void copyFromStudent(Student studentParam) {
		this.name = studentParam.getName();
		this.city = studentParam.getCity();
	}
	
}
