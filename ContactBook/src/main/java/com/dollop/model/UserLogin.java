package com.dollop.model;

public class UserLogin {
		int id;
		String name;
		String password;

		
		public UserLogin(int id, String name, String password) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
		}
		
		
		
		public UserLogin(String name, String password) {
			super();
			this.name = name;
			this.password = password;
		}



		public UserLogin() {
			super();
			// TODO Auto-generated constructor stub
		}



		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "UserLogin [id=" + id + ", name=" + name + ", password=" + password + "]";
		}
		
}
