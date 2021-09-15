package registration;
import enums.SubjectCode;
import java.util.LinkedList;


/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 * 
 * @author 
 */
public class Course {
    // TODO: add Course fields
    SubjectCode code;                  // - subject code (see SubjectCode)
    int courseNum;                     // - course number
    String courseName;                 // - course name
    int creditNum;                     // - credit number
    String courseIdentity;             // - courseIdentity is unique for a couse, combined by code-courseNum
    LinkedList<Course> prerequisites;  // - a collection of prerequisite course(s)

    /**
     * The class's constructor
     * @param code SubjectCode
     * @param courseNum Course Number
     * @param name Course Name
     * @param creditNum Course Number
     */
    public Course(SubjectCode code, int courseNum, String name, int creditNum) {
        // TODO: implement Course constructor
        this.code = code;
        this.courseNum = courseNum;
        this.courseName = name;
        this.creditNum = creditNum;
        this.courseIdentity = code + "-" + courseNum;
        prerequisites = new LinkedList<>();
    }

    /**
     * Add a prerequisite course into the prerequisites List
     * @param pre The prerequisite course
     */
    public void addPrerequisite(Course pre) {
        prerequisites.add(pre);
    }

    /**
     * According to homework required format,
     * lists information in the Course class,
     * and converts it to a string.
     * @return A string representing Course object
     */
    @Override
    public String toString(){
        String basicInfo =  "Course" +
                ": Name=" + this.courseIdentity +
                ": " + courseName +
                ", Credits=" + creditNum;
        String completeInfo = "";
        // If the course doesn't has any prerequisites
        if (prerequisites.size() == 0) {
            completeInfo = basicInfo + ", Prerequisites=[]";
        } else {
            // else adds its all prerequisites information
            completeInfo = basicInfo + ", Prerequisites=[" + prereqToString() + "]";
        }
        return completeInfo;
    }

    /**
     * According to required format,
     * lists this.prerequisites information,
     * and converts it to a string.
     * @return A string representing this.prerequisites
     */
    public String prereqToString(){
        StringBuffer prereqInfo = new StringBuffer();
        for(Course each: this.prerequisites) {
            prereqInfo.append(", Name=" + each.getCourseIdentity() + ": " + each.getCourseName());
        }
        return prereqInfo.substring(2);
    }

    public String getCourseName(){
        return this.courseName;
    }

    public String getCourseIdentity(){
        return this.courseIdentity;
    }
    
}

