package com.homework.groupofstudents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface GroupDAO {

	default void saveGroup (Student[] group) {
		String id;
		id = "" + Math.random();
		File file = new File("" + id + ".csv");
		try {
		PrintWriter print = new PrintWriter(file);
		for (int i = 0; i < group.length;i++) {
			print.println(i);
		}
		print.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is not created");
			}

	
	}
	default Group loadGroup (String id) {
		Group group = new Group();
		return group;
	}
}
