package org.sample.ws.aixs2.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class RandomItem implements Serializable {

	private static final long serialVersionUID = -4557372327682956164L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rid")
	private long id;

	@Column(name = "rname")
	private String rname;

	@Column(name = "rtype")
	private String rtype;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	@Override
	public String toString() {
		return "RandomItem [id=" + id + ", rname=" + rname + ", rtype=" + rtype + "]";
	}
	
	
	

}
