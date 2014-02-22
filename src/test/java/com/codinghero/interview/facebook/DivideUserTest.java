package com.codinghero.interview.facebook;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.codinghero.interview.facebook.DivideUser.User;

public class DivideUserTest {
	
	private DivideUser instance = new DivideUser();
	
	@Test
	public void test1() {
		User user1 = new User(1L);
		User user2 = new User(2L);
		User user3 = new User(3L);
		User user4 = new User(4L);
		User user5 = new User(5L);
		User user6 = new User(6L);
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		
		user1.friends.add(user2);
		user1.friends.add(user3);
		user2.friends.add(user1);
		user2.friends.add(user5);
		user3.friends.add(user1);
		user4.friends.add(user5);
		user4.friends.add(user6);
		user5.friends.add(user2);
		user5.friends.add(user4);
		user6.friends.add(user4);
		
		Assert.assertTrue(instance.canDivide(users));
	}
}
