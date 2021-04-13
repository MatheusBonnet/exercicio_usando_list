public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		int n = sc.nextInt();
		
		for(int contador=1; contador<=n; contador++) {		
			System.out.println();
			System.out.println("Employee #" + contador + ": ");	
			System.out.println("Id: ");
			Integer id = sc.nextInt();
			
			while(hasId(list, id)) {
				System.out.println("Id already taken! Try gain: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			Employee emp = new Employee(id,name, salary);
			list.add(emp);	
		}
		
		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();	
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);		
		if (emp == null) {
			System.out.println("This id does not exist! ");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		// PART 3 - LISTING EMPLOYEES:
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee empl : list) {
			System.out.println(empl);
		}
		
		
			sc.close();
		}
		
	public static boolean hasId(List<Employee> list, int id) {
			Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			return emp != null;
	}

}
