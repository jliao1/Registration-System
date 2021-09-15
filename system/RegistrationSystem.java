package system;
import enums.*;
import exception.*;
import person.Faculty;
import person.Student;
import registration.Course;
import registration.Section;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about the school, 
 * including the ability to add students, add faculty, add courses, and add prerequisite(s).</p>
 * 
 * @author Jun Liao
 */
public class RegistrationSystem {

    // TODO: add RegistrationSystem collections
    Map<String, Student> students;     // - student list
    Map<String, Faculty> faculties;    // - faculty list
    Map<String, SubjectCode> subjects; // - subject list
    Map<String, Course> courses;       // = course list
    Map<String, Section> sections;
    //
    // Note -- there is no list for prerequisites - these should be included
    // as part of the course list
    
    /**
     * The class's constructor
     * using HashMap structure to store information,
     * convenient for adding, checking if-contains(duplication), retrieving
     */
    public RegistrationSystem() {
        // TODO: implement RegistrationSystem constructor
        this.faculties = new HashMap<>();
        this.students = new HashMap<>();
        this.subjects = new HashMap<>();
        this.courses = new HashMap<>();
        this.sections = new HashMap<>() ;
    }



    /**
     * Add a student to the student list collection.
     * 
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program    
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName, StudentType type,
                           StudentProgram program, Quarter quarter, int year)
                            throws DuplicatePersonException {
        // TODO: implement addStudent method
        String stuName = firstName + " " + lastName;           // stuName as students hashmap key
        // If the student is already contained in students hashmap, throws DuplicatePersonException
        if(students.containsKey(stuName))
            throw new DuplicatePersonException();
        // If not contained, initializes a student instance with input parameters
        Student stu = new Student(firstName, lastName, type, program, quarter, year);
        // Pus it into the students hashmap
        students.put(stuName, stu);
    }
    /**
     * Retrieve a student with its name in the students hashmap
     * This method is written to test PersonNotFoundException in driver class
     * @param name Student Name
     * @return The student if found
     * @throws PersonNotFoundException
     */
    public Student retrieveStudentName(String name) throws PersonNotFoundException {
        if(!students.containsKey(name)){
            throw new PersonNotFoundException();
        }
        return students.get(name);
    }
    /**
     * Randomly assign a student a advisor from the faculty list,
     * This method is call by driver before the driver prints students' advisor names,
     * otherwise, the students' advisor names would be null.
     */
    public void assignAdvisorForAllStudents() {
        for (Student student: this.students.values()) {
            String advisorName = getRandomFacultyName();
            student.setAdvisor(faculties.get(advisorName));
        }
    }
    /**
     * Randomly get a advisor name from the faculty list,
     * @return the advisor name
     */
    private String getRandomFacultyName() {
        Random generator = new Random();
        Object[] facultyNames = faculties.keySet().toArray();
        return (String)facultyNames[generator.nextInt(facultyNames.length)];
    }



    /**
     * Add a faculty to the faculty list collection.
     * 
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                            FacultyType type, Building bldg, int room, String email) 
                            throws DuplicatePersonException {
        // TODO: implement addFaculty method
        String facultyName = firstName + " " + lastName;  // facultyName as faculties hashmap key
        // If the faculty is already contained in faculties hashmap, throws DuplicatePersonException
        if(faculties.containsKey(facultyName))
            throw new DuplicatePersonException();
        // If not contained, initializes a faculty instance with input parameters
        Faculty faculty = new Faculty(firstName, lastName, type, bldg, room, email);
        // Puts it into the faculties hashmap
        faculties.put(facultyName, faculty);
    }
    /**
     * Retrieve a faculty with its name in the faculties hashmap
     * This method is written to test PersonNotFoundException in driver class
     * @param name Faculty Name
     * @return The faculty if found
     * @throws PersonNotFoundException
     */
    public Faculty retrieveFacultyName(String name) throws PersonNotFoundException {
        if(!faculties.containsKey(name)){
            throw new PersonNotFoundException();
        }
        return faculties.get(name);
    }



    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     * 
     * @param code    The subject code
     * @param desc    The subject description
     * 
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc)
                            throws DuplicateSubjectException {
        // TODO: implement addSubject method
        // If the subject is already contained in subjects hashmap, throws DuplicateSubjectException
        if(subjects.containsKey(desc)){                 // desc is subjects hashmap key, code is the value
            throw new DuplicateSubjectException();
        }
        // If not contained, put it into the subjects hashmap
        subjects.put(desc, code);
    }



    /**
     * Adds a course to the course list collection.
     * 
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system 
     */
    public void addCourse(SubjectCode code, int num, String name, int creditNum)
                            throws DuplicateCourseException {
        // TODO: implement addCourse method
        // Code+num as a course unique identity, also as the courses hashmap key
        String courseIdentity = "" + code + num;
        // If the course is already contained in courses hashmap, throws DuplicateCourseException
        if(courses.containsKey(courseIdentity)){
            throw new DuplicateCourseException();
        }
        // If not contained, initializes a course instance with input parameters
        Course course = new Course(code, num, name, creditNum);
        // Put it into courses hashmap
        courses.put(courseIdentity, course);
    }
    /**
     * Retrieve a course with its code and number
     * This method is written to test CourseNotFoundException in driver class
     * @param code SubjectCode
     * @param num Code number
     * @return The course if found
     * @throws CourseNotFoundException
     */
    public Course retrieveCourseCodeAndNumber(SubjectCode code, int num)
                            throws CourseNotFoundException {
        String courseIdentity = "" + code + num;
        if(!courses.containsKey(courseIdentity)){
            throw new CourseNotFoundException();
        }
        return courses.get(courseIdentity);
    }


    
    /**
     * Adds a prerequisite to an existing course in the course list collection.
     * First finds the target existing course (if existed)
     * Then finds the prerequisite course (if existed)
     * Last adds the prerequisite to target course to be one of target course's prerequisites
     *
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num, 
                            SubjectCode prereqCode, int prereqNum) 
                            throws CourseNotFoundException {
        
        // TODO: implement addPrerequisite method

        // Finding the target course from the courses hashmap
        String targetCoureIdentity = "" + code + num;       // Generates the target course identity (combined by code+num)
        Course targetCourse;
        // If the target course existed, get the targetCourse
        if (courses.containsKey(targetCoureIdentity)) {
            targetCourse = courses.get(targetCoureIdentity);
        }else {
            // If not existed, throws CourseNotFoundException
            throw new CourseNotFoundException();
        }

        // Finding the prerequisite course from the courses hashmap
        String prereqCourseIdentity = "" +  prereqCode + prereqNum;// Generates the prerequisite course identity (combined by code+num)
        Course prereqCourse;
        // If the prerequisite course existed, get the prerequisite course
        if (courses.containsKey(prereqCourseIdentity)) {
            prereqCourse = courses.get(prereqCourseIdentity);
        }else {
            // If not existed, throws CourseNotFoundException
            throw new CourseNotFoundException();
        }

        // Finally, adds prerequisite to target course
        targetCourse.addPrerequisite(prereqCourse);
    }



    /**
     * Adds a section to the section list collection.
     * 
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum, String firstName, String lastName,
                           Quarter quarter, int year, int cap, Building bldg, int room)
                            throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {
        // TODO: implement addSection method

        // A course unique identity is combined by code+courseNum+sectionNum, also as the courses hashmap key
        String sectionIdentity = "" + code + courseNum + sectionNum;
        // If the section is already contained in sections hashmap, throws DuplicateSectionException
        if(sections.containsKey(sectionIdentity))
                throw new DuplicateSectionException();

        // Finding the course that is going to be added into a section
        // If found, get the course; if no, throws CourseNotFoundException
        String courseIdentity = "" + code + courseNum;
        if(!courses.containsKey(courseIdentity)){
            throw new CourseNotFoundException();
        }
        Course course = courses.get(courseIdentity);

        // Finding the instructor who is going to be added into a section
        // If found, get the instructor faculty; If no, throws PersonNotFoundException
        String instructorName = firstName+ " " + lastName;
        if(!faculties.containsKey(instructorName)){
            throw new PersonNotFoundException();
        }
        Faculty instructor = faculties.get(instructorName);

        // Initializes a section instance with input parameters
        // And puts it into sections hashmap
        Section section = new Section(course, sectionNum, instructor, quarter, year, cap, bldg, room);
        sections.put(sectionIdentity, section);
    }
    /**
     * Retrieve a section with course code，course number, section number
     * This method is written to test SectionNotFoundException in driver class
     * @param code SubjectCode
     * @param courseNum Course number
     * @param sectionNum Section number
     * @return The section if found
     * @throws SectionNotFoundException
     */
    public Section retrieveSection(SubjectCode code, int courseNum, int sectionNum) throws SectionNotFoundException {
        String sectionIdentity = "" + code + courseNum + sectionNum;
        if(!sections.containsKey(sectionIdentity)){
            throw new SectionNotFoundException();
        }
        return sections.get(sectionIdentity);
    }



    /**
     * According to homework required format,
     * lists all fields information in the RegistrationSystem class,
     * and converts it to a string.
     * Set it as public method cuz it may be flexibly called by driver (though this time doesn't)
     * @return a string representing RegistrationSystem object
     */
    @Override
    public String toString() {
       return facultiesToString()
               + studentsToString()
               + subjectsToString()
               + coursesToString()
               + sectionsToString();
    }
    /**
     * According to required format,
     * lists all faculty members in this.faculties hashmap,
     * and converts it to a string.
     * Set it as public method cuz it may be flexibly called by driver (though this time doesn't)
     * @return a string representing this.faculties
     */
    public String facultiesToString(){
        StringBuffer result = new StringBuffer();
        result.append("-- FACULTY LIST --\n");
        // get all faculty names
        Set<String> facultyNames = faculties.keySet();
        // Iterates each facultyName
        for(String each: facultyNames) {
            // get each faculty
            Faculty faculty = faculties.get(each);
            // Concatenates each faculty object information
            result.append(faculty.toString() + "\n");
        }
        result.append("\n");
        return result.toString();
    }
    /**
     * According to required format,
     * lists all student members in this.students hashmap,
     * and converts it to a string.
     * Set it as public method cuz it may be flexibly called by driver (though this time doesn't)
     * @return a string representing this.students
     */
    public String studentsToString(){
        StringBuffer result = new StringBuffer();
        result.append("-- STUDENT LIST --\n");
        // get all student names
        Set<String> studentNames = students.keySet();
        // Iterates each studentName
        for(String each: studentNames) {
            // get each student
            Student student = students.get(each);
            // Concatenates each student object information
            result.append(student.toString() + "\n");
        }
        result.append("\n");
        return result.toString();
    }
    /**
     * According to required format,
     * lists all subject members in this.subjects hashmap,
     * and converts it to a string.
     * Set it as public method cuz it may be flexibly called by driver (though this time doesn't)
     * @return a string representing this.subjects
     */
    public String subjectsToString(){
        StringBuffer result = new StringBuffer();
        result.append("-- SUBJECT LIST --\n");
        // get all subject names
        Set<String> subjectNames = subjects.keySet();
        // Iterates each subject
        for(Object each: subjectNames) {
            // Concatenates each subject
            result.append("Subject: " + each + " (" + subjects.get(each) + ")\n");
        }
        result.append("\n");
        return result.toString();
    }
    /**
     * According to required format,
     * lists all course members in this.courses hashmap
     * and converts it to a string
     * Set it as public, convenient for driver if driver wants to read collection instances.
     * @return a string representing this.courses
     */
    public String coursesToString(){
        StringBuffer result = new StringBuffer();
        result.append("-- COURSE LIST --\n");
        // get all course names
        Set<String> courseNames = courses.keySet();
        // Iterates each courseName
        for(String each: courseNames) {
            // get each course
            Course course = courses.get(each);
            // Concatenates each course object information
            result.append(course.toString() + "\n");
        }
        result.append("\n");
        return result.toString();
    }
    /**
     * According to required format,
     * lists all section members in this.sections hashmap
     * and converts it to a string
     * Set it as public, convenient for driver if driver wants to read collection instances.
     * @return a string representing this.sections
     */
    public String sectionsToString(){
        StringBuffer result = new StringBuffer();
        result.append("-- SECTION LIST --\n");
        // get all section names
        Set<String> sectionNames = sections.keySet();
        // Iterates each sectionName
        for(String each: sectionNames) {
            // get each course
            Section section = sections.get(each);
            // Concatenates each section object information
            result.append(section.toString() + "\n");
        }
        result.append("\n");
        return result.toString();
    }


}
