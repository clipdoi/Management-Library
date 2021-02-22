package entities;

import java.util.Date;

public class Librarian {
	private int id;
	private String username, password, name, sec_q, answer;
	private Date created;

	public Librarian() {
		super();
	}
	public Librarian(int id, String username, String password, String name, String sec_q, String answer, Date created) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sec_q = sec_q;
		this.answer = answer;
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSec_q() {
		return sec_q;
	}
	public void setSec_q(String sec_q) {
		this.sec_q = sec_q;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
