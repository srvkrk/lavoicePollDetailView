package com.lavoice.bean;

public class LoggedInSession {
    private String id;
	private String username;
    private String firstname;
    private String lastname;
    private String emailVerified;
    
    public LoggedInSession(String id, String username, String firstname, String lastname, String emailVerified) {
    	this.setId(id);
        this.setUsername(username);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setEmailVerified(emailVerified);
    }
    
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}
	
	@Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Id:- " + getId() + ", Username:- " + getUsername()
        +"Firstname" + getFirstname()+ "lastname" + getLastname());
        return str.toString();
    }

}
