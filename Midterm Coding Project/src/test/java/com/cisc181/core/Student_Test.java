package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;

public class Student_Test {
	static ArrayList<Section> sections;
	static ArrayList<Semester> semesters;
	static ArrayList<Course> courses;
	static ArrayList<Student> students;

	@BeforeClass
	public static void setup() throws PersonException {
		Course course1 = new Course("Physics 1", 3, eMajor.PHYSICS);
		Course course2 = new Course("Physics 2", 4, eMajor.PHYSICS);
		Course course3 = new Course("Physics 1", 3, eMajor.PHYSICS);
		courses= new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		Date date = new Date(2016, 05,15);
		Semester Fall = new Semester(date,date);
		Semester Spring = new Semester(date,date);
		semesters= new ArrayList<Semester>();
		semesters.add(Fall);
		semesters.add(Spring);
		
		Section section1 = new Section(courses.get(0).getCourseID(), semesters.get(0).getSemesterID(),1);
		Section section2 = new Section(courses.get(1).getCourseID(), semesters.get(1).getSemesterID(),1);
		Section section3 = new Section(courses.get(2).getCourseID(), semesters.get(0).getSemesterID(),1);
		Section section4 = new Section(courses.get(0).getCourseID(), semesters.get(1).getSemesterID(),1);
		Section section5 = new Section(courses.get(1).getCourseID(), semesters.get(0).getSemesterID(),1);
		Section section6 = new Section(courses.get(2).getCourseID(), semesters.get(1).getSemesterID(),1);
		sections = new ArrayList<Section>();
		sections.add(section1);
		sections.add(section2);
		sections.add(section3);
		sections.add(section4);
		sections.add(section5);
		sections.add(section6);
		
		int i = 1;
		students = new ArrayList<Student>();
		while(i <11){
			Student student = new Student("B", "A", "Z", new Date(), eMajor.PHYSICS, "Deffinetly not", "(610)-504-2012",
					"bazank@gmail.com");
			students.add(student);
			i++;
		}

		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws PersonException {
		ArrayList<Enrolment> enrolments = new ArrayList<Enrolment>();
		for(Student s : students){
			for(Section se : sections){
				Enrolment e = new Enrolment(se.getSection(), s.getStudentID());
				enrolments.add(e);
			}
		}
		
		double grade = 1;
		for(Enrolment e : enrolments){
			if(grade > 6){
				grade = 1;
			}
			e.setGrade(grade);
			grade++;
		}
		int i = 1;
		double gp = 0;
		for(Enrolment e : enrolments){
			gp = gp + e.getGrade();
			//System.out.println(e.getGrade());
			if (i == 6){
				double gpa = gp/6;
				DecimalFormat df = new DecimalFormat("#.#");
				df.format(gpa);
				//System.out.println(gpa);
				//assertEquals(gpa,3.5);
				i = 0;
				gp = 0;
			}
			i++;
		}
		
		double num = 1.0;
		for(int n=0; n<6; n++){
			for(Enrolment e : enrolments){
				if(e.getSectionID() == enrolments.get(i).getSectionID()){
					gp = gp + e.getGrade();
				}
			}
			double agp = gp/20;
			
			//System.out.println(agp);
			//assertEquals(agp,num);
			num = num + 1.0;
		}
		
		//Changing a major
		students.get(0).setMajor(eMajor.CHEM);
		
	}
}