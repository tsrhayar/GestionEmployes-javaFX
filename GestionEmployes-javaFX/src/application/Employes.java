package application;



public class Employes {
	
	private Integer id;
	private String typeEmp;
	private String firstname;
	private String lastname;
	private int age;
	private String dateEntrer;

	public Employes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employes(int id, String typeEmp, String firstname, String lastname, int age, String dateEntrer) {
		super();
		this.id = id;
		this.typeEmp = typeEmp;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.dateEntrer = dateEntrer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateEntrer() {
		return dateEntrer;
	}

	public void setDateEntrer(String dateEntrer) {
		this.dateEntrer = dateEntrer;
	}

	public String getTypeEmp() {
		return typeEmp;
	}

	public void setTypeEmp(String typeEmp) {
		this.typeEmp = typeEmp;
	}
	
	
	
}


	
	