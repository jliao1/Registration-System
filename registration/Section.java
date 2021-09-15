package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 * 
 * @author Jun Liao
 */
public class Section {
    // TODO: add Section fields including:
    Course course;              // - course
    int section;                // - section
    Faculty instructor;         // - instructor
    String term;                // - term (see Quarter)
    int cap;                    // - capacity
    String location;            // - location (see Building)
    
    /**
     * The class's constructor
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter, 
                    int year, int cap, Building bldg, int room) {
        // TODO: implement Section constructor
        this.course = course;
        this.section = section;
        this.instructor = instructor;
        this.term = quarter + " " + year;
        this.cap = cap;
        this.location = bldg + " " + room;
    }

    /**
     * All information a section has
     * @return A string as the homework required output format
     */
    @Override
    public String toString(){
        String info =  "Section:" +
                " Course=" + this.course.getCourseIdentity() + "-0" + this.section +
                ": " + this.course.getCourseName() +
                ", Faculty=" + instructor.getName() +
                ", Term=" + this.term +
                ", Capacity=" + this.cap +
                ", Room=" + this.location;
        return info;
    }


}
