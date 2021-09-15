package person;

import enums.*;

import java.util.HashMap;
import java.util.Locale;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @Jun Liao
 */
public class Student extends Person{
    // TODO: add Student fields
    private StudentType stuType;          // - student type (see StudentType)
    private StudentProgram stuProgram;    // - student program (see StudentProgram)
    private StudentYear stuYear;          // - student year (see StudentYear; only if undergrad––default to freshman)
    private String startTerm;             // - start term (see Quarter)
    private Faculty advisor;              // - faculty advisor
    private static int uniqueID = 100018; // starts from 100018, increment every time after a student type object was created

    /**
     * The class's constructor
     * @param firstName
     * @param lastName
     * @param type StudentType (see StudentType)
     * @param program StudentProgram name (see StudentProgram)
     * @param quarter The quarter a student start his/her program (see StudentProgram))
     * @param year The year a student start his/her program
     */
    public Student(String firstName, String lastName,
                   StudentType type, StudentProgram program,
                   Quarter quarter, int year) {
        // TODO: implement Student constructor
        this(firstName, lastName);
        this.stuType = type;
        this.stuProgram = program;
        this.startTerm = quarter + " " + year;
        this.stuYear = autoGenerateStuYear(year);
    }
    /**
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     */
    public Student(String firstName, String lastName) {
        // TODO: implement Faculty constructor
        super(firstName, lastName, uniqueID);     // uniqueID passed into "super(firstName, lastName, uniqueID)" to set SUID
        // "uniqueID" starts from 100001,
        // auto increments every time after a Faculty instance was created,
        uniqueID ++;
    }

    /**
     * According to homework required format,
     * lists information in the Student class,
     * and converts it to a string.
     * @return A string representing Student object
     */
    @Override
    public String toString(){
        String basicInfo = "Student" +
                ": Name=" + super.getName() +
                ", SUID=" + super.getSUID() +
                ", Email=" + super.getEmail() +
                ", Status=" + super.getStatus() +
                ", Type=" + stuType +
                ", Program=" + stuProgram +
                ", Term=" + startTerm +
                ", Advisor=" + advisor.getName()
                ;
        // If the student is UNDERGRAD, print his/her student year
        // else just print his/her basic information (not including student year)
        if (this.stuType == StudentType.UNDERGRAD) {
            String info = basicInfo + ", Year=" + this.stuYear;
            return info;
        }else return basicInfo;
    }


    /**
     * Auto generates the student year according to the year he/she starts program
     * @param year The year a student start his/her program
     * @return StudentYear type student year
     */
    private StudentYear autoGenerateStuYear(int year) {
        int toCurr = 2021 - year;
        if (toCurr == 0) return StudentYear.FRESHMAN;
        if (toCurr == 1) return StudentYear.SOPHOMORE;
        if (toCurr == 2) return StudentYear.JUNIOR;
        if (toCurr == 3) return StudentYear.SENIOR;
        return StudentYear.SENIOR;
    }

    /**
     * Set the student's advisor
     * @param advisor A faculty
     */
    public void setAdvisor(Faculty advisor){
        this.advisor = advisor;
    }

}
