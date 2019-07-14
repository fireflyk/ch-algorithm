package com.codinghero.oj.leetcode;

import java.util.LinkedList;

/**
 * start: 0; end: 1, 2, 3, 4<br/>
 * 0 --[/]--> 1<br/>
 * 1 --[/]--> 1<br/>
 * 1 --[char]--> 2<br/>
 * 1 --[.]--> 3<br/>
 * 2 --[char]--> 2<br/>
 * 3 --[/]--> 1<br/>
 * 3 --[char]--> 2<br/>
 * 3 --[.]--> 4<br/>
 * 4 --[/]--> 1<br/>
 * 4 --[.char]--> 1<br/>
 * 
 * @author Tong Liu
 * 
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		LinkedList<String> pathList = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		char[] arr = path.toCharArray();
		int state = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			// 0 --[/]--> 1
			if (state == 0) {
				if (c == '/') {
					state = 1;
				}
			} else if (state == 1) {
				if (c == '/') {
					state = 1;
				} else if (c == '.') {
					state = 3;
				} else {
					state = 2;
					sb.append(c);
				}
			} else if (state == 2) {
				if (c == '/') {
					state = 1;
					pathList.addLast(sb.toString());
					sb = new StringBuilder();
				} else {
					sb.append(c);
				}
			} else if (state == 3) {
				// '/./' nothing to do
				if (c == '/') {
					state = 1;
				}
				// '.'
				else if (c == '.') {
					state = 4;
				}
				// '.a'
				else {
					state = 2;
					sb.append(".");
					sb.append(c);
				}
			} else if (state == 4) {
				if (c == '/') {
					state = 1;
					if (!pathList.isEmpty()) {
						pathList.removeLast();
					}
				}
				// '...' OR '..a'
				else {
					state = 2;
					sb.append("..");
					sb.append(c);
				}
			}
		}
		
		if (state == 2) {
			pathList.addLast(sb.toString());
		} else if (state == 4) {
			if (!pathList.isEmpty()) {
				pathList.removeLast();
			}
		}
		
		sb = new StringBuilder();
		if (pathList.isEmpty()) {
			sb.append("/");
		} else {
			while (!pathList.isEmpty()) {
				sb.append("/");
				sb.append(pathList.removeFirst());
			}
		}
		
		return sb.toString();
	}
}
