package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivideUser {

	public boolean canDivide(List<User> users) {
		if (users == null || users.size() == 0)
			return true;
		Set<Long> group1 = new HashSet<Long>();
		Set<Long> group2 = new HashSet<Long>();
		Set<Long> visited = new HashSet<Long>();
		for (User user : users) {
			if (!canDivide(user, group1, group2, visited)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean canDivide(User user, Set<Long> group1, Set<Long> group2, Set<Long> visited) {
		if (visited.contains(user.id)) {
			if (group1.contains(user.id)) {
				return true;
			} else {
				return false;
			}
		}
		
		visited.add(user.id);
		group1.add(user.id);
		
		List<User> friends = user.friends;
		if (friends != null && !friends.isEmpty()) {
			for (User friend : friends) {
				if (!canDivide(friend, group2, group1, visited))
					return false;
			}
		}
		return true;
	}
	
	
	static class User {
		long id;
		List<User> friends;

		public User(long id) {
			this.id = id;
			this.friends = new ArrayList<User>();
		}
	}
}
