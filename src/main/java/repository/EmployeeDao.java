
package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Employee;
import hibernatecfg.HibernateUtil;

public class EmployeeDao {

	public void addEmployee(Employee employee)
	{
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the employee object
		session.save(employee);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
}
	//update employee
	public void updateEmployee(Employee employee)
	{
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.update(employee);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
}
	//search student by id
	public Employee searchEmployeeById(int id)
	{
		Transaction transaction = null;
		Employee employee= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			employee = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}
	
	
	//delete student

	public void deleteEmployee(int id)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Employee employee = session.get(Employee.class, id);
			if (employee!= null) {
				session.delete(employee);
				System.out.println("employee is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	//Display  ALL Student Details
		@SuppressWarnings("unchecked")
		public List<Employee> getAllEmployee() {

			Transaction transaction = null;
			List<Employee> listOfEmployee = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// get an user object
				
				listOfEmployee = session.createQuery("from Employee").getResultList();
				
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return listOfEmployee;
		}
		
	
}