package com.cisc181.core;

import java.util.*;
public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID Section;
	private int RoomID;
	
	public Section(UUID courseID, UUID semesterID, int roomID) {
		super();
		CourseID = courseID;
		SemesterID = semesterID;
		Section = UUID.randomUUID();
		RoomID = roomID;
	}
	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public UUID getSemesterID() {
		return SemesterID;
	}
	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}
	public UUID getSection() {
		return Section;
	}
	public void setSection(UUID section) {
		Section = section;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
}
