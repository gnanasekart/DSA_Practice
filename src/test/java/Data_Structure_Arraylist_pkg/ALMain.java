package Data_Structure_Arraylist_pkg;
import java.util.ArrayList;
import java.util.List;

public class ALMain
{
public static void main(String[] args)
{
	ArrayList<Employee> emp = new ArrayList<>();
	
	emp.add(new Employee("gnana", "sekar", 123));
	emp.add(new Employee("gowri", "shankar", 345));
	emp.add(new Employee("mathan", "kumar", 456));
	
	/*for (int i=0; i<emp.length; i++)
	{
		System.out.println(Employee);
	}*/

    emp.forEach(employee -> System.out.println(emp));
}
}
