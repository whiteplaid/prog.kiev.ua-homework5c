package com.homework.groupofstudents;

import java.io.*;
import java.util.Scanner;

public class DAO implements GroupDAO{
	private String id;
	private Group group;


	public DAO(String id, Group group) {
		super();
		this.id = id;
		this.group = group;
	}

	public DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}




	@Override
	public void saveGroup(Student[] group) {
		String id;
		id = "" + Math.random();
		File folder = new File("groups/");
		File file = new File(folder,"" + id + ".csv");
		
		try {
			folder.mkdirs();
			
		PrintWriter print = new PrintWriter(file);
		print.println(id);

		for (int i = 0; i < group.length;i++) {
			
			if (group[i] != null)
			print.println(group[i].getName() + " " + group[i].getSurename() + " " + group[i].getAge() + " " + group[i].isSex() + " " + group[i].getEyesColor() + " " + group[i].getHairColor());
		}
		
		print.close();
		} catch (IOException e) {
			System.out.println("File is not created");
			}
	}

	@Override
	public Group loadGroup(String id) {
		Group group = new Group();
		File folder = new File("groups/");
		File file = new File(folder,"" + id + ".csv");
				
		try {
			FileReader in = new FileReader(file);
			Scanner scan = new Scanner(in);
			String nextline = scan.nextLine();
			
			while (scan.hasNextLine()) {
				nextline = scan.nextLine();
				String[] str = nextline.split(" ");
				String name = str[0];
				String surename = str[1];
				int age = Integer.valueOf(str[2]);
				Boolean sex = Boolean.valueOf(str[3]);
				String eyesColor = str[4];
				String hairColor = str[5];
				Student tmp = new Student(sex, eyesColor, hairColor, name, surename, age);
				group.addStudent(tmp);
				
			}
			
			scan.close();
			
			} catch (IOException  e) {
				System.out.println("File not found");
			}

		return group;
	}


	

}
