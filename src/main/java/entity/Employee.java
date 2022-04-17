package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="employee")
	public class Employee {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="lastName")
		private String lastName;
		
		@Column(name="password")
		private String password;
		
		@Column(name="address")
		private String address;
		
		@Column(name="contact")
		private String contact;

		public Employee() {
			super();
		}

		public Employee(String firstName, String lastName, String password, String address, String contact) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.address = address;
			this.contact = contact;
		}

		public Employee(int id, String firstName, String lastName, String password, String address, String contact) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.address = address;
			this.contact = contact;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}
		
	

}
