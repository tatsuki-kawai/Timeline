package model;

import java.io.Serializable;

public class Action implements Serializable{
	private String when;
	private String what;

	public Action() {

	}
	public Action(String when, String what) {
		this.when = when;
		this.what = what;
	}

	public String getWhen() {
		return this.when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public String getWhat() {
		return this.what;
	}
	public void setWhat(String what) {
		this.what = what;
	}

}
