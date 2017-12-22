package com.neo.gyl.domain.privilege;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.neo.gyl.domain.basedata.User;

public class Role implements Serializable {

	private Integer rid;
	private Integer pid;
	private String name;
	private Boolean isParent;
	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privileges = new HashSet<Privilege>();

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
