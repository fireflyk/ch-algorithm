package com.codinghero.interview.facebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codinghero.interview.facebook.DivideUser.User;

public class DivideUser2 {

	public boolean canDivide(List<User> users) {
		System.out.println();
		System.out.println();
		sb = new StringBuilder();
		if (users == null || users.size() == 0)
			return true;
		Set<Long> group1 = new HashSet<Long>();
		group1.add(100L);
		Set<Long> group2 = new HashSet<Long>();
		group2.add(200L);
		Set<Long> visited = new HashSet<Long>();
		return canDivide(users, group1, group2, visited);
	}
	
	private StringBuilder sb = new StringBuilder();
	
	private boolean canDivide(List<User> users, Set<Long> group1, Set<Long> group2, Set<Long> visited) {
		if (users == null)
			return true;

		for (User user : users) {
			System.out.println(sb.toString()
					+ (group1.contains(100L) ? "100" : "200"));
			System.out.println(sb.toString() + user.id + " ");
			if (visited.contains(user.id)) {
				if (group2.contains(user.id))
					return false;
			} else {
				visited.add(user.id);
				group1.add(user.id);

				sb.append('\t');
				
				if (!canDivide(user.friends, group2, group1, visited))
					return false;

				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return true;
	}
}
