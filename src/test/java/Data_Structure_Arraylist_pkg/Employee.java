package Data_Structure_Arraylist_pkg;

public class Employee
{
private String firstname;
private String lastname;
private int id;

public Employee(String firstname, String lastname, int id)
{
	this. firstname = firstname;
	this.lastname = lastname;
	this.id= id;
}
public String getFirstName()
{
	return firstname;
}
public void setFirstName(String firstname)
{
	this.firstname = firstname;
}

public void setLastName(String lastname)
{
this.lastname=lastname;
}
public String getLastName()
{
	return lastname;
}
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id = id;
}

public String toString()
{
	return "Employee{" + firstname + '\''+ ", lastname=' "+lastname + '\''+
	", id =" + id + 
	'}';
}
}