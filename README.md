# HW4: Registration System

Is your solution fully working or not?
Yes

Justify any additional classes you included in your solution.
I add a "Person" class under "person" file, used to inherited by "Faculty" and "Student" because they are all person.


Did you work on the extra credit problem? Briefly describe any issues or explain any assumptions made.
Yes, using drawio to draw diagram. I uploaded it under root file.

How much time did you spend on the assignment?
20 hours

Any feedback on the assignment?
Hope can have sample solutions after grading so that I have a full picture about the code structure. 




In HW 4, we will begin to implement a simple course registration system for a university.

The ```RegistrationSystem``` will hold information (in collections) on university students, faculty, courses, their prerequisites, and course sections. Complete the implementations for the following operations supplied in the ```RegistrationSystem``` class:

1. Constructor: initialize all fields and ensure that the ```RegistrationSystem``` object is in a valid initial state.
1. ```addStudent``` : Add student to the student collection. Throw appropriate exceptions.
1. ```addFaculty``` : Add faculty to the faculty collection. Throw appropriate exceptions.
1. ```addCourse``` : Add course to the faculty collection. Throw appropriate exceptions.
1. ```addPrerequisite``` : Add prerequisite to an existing course in the course collection. Throw appropriate exceptions.
1. ```addSection``` : Add a section for an existing course in the course collection. Throw appropriate exceptions.

In addition, you will need to implement functionality and add fields in the following classes:

1. ```Faculty``` : Implement the constructor and add the following fields:
   * first name: the first name of the faculty
   * last name: the last name of the faculty
   * suid: the school (i.e. SU) identification number -- must be unique
   * status: the status of the faculty (see ```PersonStatus``` enum)
   * faculty type: the type of faculty (see ```FacultyType``` enum)
   * office: includes building (i.e. ENGR) and room number (i.e 504)
   * phone: the faculty office phone number
   * email: the school (i.e. SU) email address
1. Student : Implement the constructor and add the following fields:
   * first name: the first name of the student
   * last name: the last name of the student
   * suid: the school (i.e. SU) identification number -- must be unique
   * status: the status of the student (see ```PersonStatus``` enum)
   * student type: a student can only be assigned a single student type (see ```StudentType``` enum)
   * student program: a student can only be assigned to a single program at a point of time, but can switch from one program to another (i.e. when they've graduated from a program (see ```StudentProgram``` enum)
   * student year: only relevant for undergraduates (see ```StudentYear``` enum)
   * faculty advisor: students are assigned a faculty advisor, but may switch advisors (i.e. faculty leaves or on sabbatical); may not be assigned an advisor for a period of time when first enrolled as a student
   * start term: associated with the quarter and year a student starts a particular program; for example, a single student may start the CERT in RQ17 and then continue the MSCS in FQ18 (see Quarter enum)
   * email: the school (i.e. SU) email address
1. Course : Implement the constructor and add the following fields:
   * For example, CPSC 5011: Object-Oriented Concepts
      * subject code: CPSC
      * course number: 5011
      * course name: Object-Oriented Concepts
      * credit number: 3
      * prerequisite(s): CPSC 5003 (can have multiple prerequisites or none)
1. Section : Implement the constructor and add the following fields:
   * For example, CPSC 5011-02: Object-Oriented Concepts
      * course: CPSC 5011
      * section: 02
      * instructor: Scott McMaster
      * quarter/year: FQ18
      * capacity: 30
      * building/room: LEML 122
#### Notes:

* You may include additional classes to promote good design. 
* You may include additional public functionality in ```RegistrationSystem```, ```Faculty```, ```Student```, ```Course```, and ```Section``` classes. Do not include any functionality that is not necessary.
* Feel free to add private helper function(s) to the ```RegistrationSystem```, ```Faculty```, ```Student```, ```Course```, and ```Section``` classes; however, please confirm with the instructor before attempting to add any fields not specified in these classes.
#### Class Requirements
1. Accept the assignment from Github Classroom to create your private repository.
   * Additional documentation on classes may be found on the provided starter code.
1. No changes should be made to the ```Driver``` (except the TODO) or any classes in ```enums/``` or ```exception/.```
1. Implement all 17 TODOs in the ```RegistrationSystem```, ```Faculty```, ```Student```, ```Course```, and ```Section``` classes.
1. You will only be throwing exceptions in the non-```Driver``` classes you create. The driver will be responsible for handling (i.e. catching) exceptions. You may create additional exceptions, if necessary. If included, be sure to include the throws keyword and the exception name in the function signature. 
1. Your project MUST have the following structure:

```
HW4 
–> src 
–> [su_username]_hw4 
–> driver 
–> enums 
–> exceptions
–> person
–> registration
–> system 
–> HW4_class_diagram.pdf (if you do EC)
–> README.md
```
#####Driver Requirements
Driver.java has been given. Do not make any changes to this file beyond the TODO (though you can create helper method(s) to help print the RegistrationSystem collections).

### Sample Output
```
-- FACULTY LIST --
Faculty: Name=Roshanak Roshandel, SUID=100015, Email=roshanak@seattleu.edu, Status=ACTIVE, Type=ASSOCPROF, Office=ENGR 508
Faculty: Name=James Obare, SUID=100012, Email=obarej@seattleu.edu, Status=ACTIVE, Type=INSTRUCT, Office=ENGR 502
Faculty: Name=Kevin Lundeen, SUID=100009, Email=lundeenk@seattleu.edu, Status=ACTIVE, Type=INSTRUCT, Office=ENGR 519
Faculty: Name=Jason Wong, SUID=100016, Email=wongja@seattleu.edu, Status=ACTIVE, Type=INSTRUCT, Office=ENGR 526
Faculty: Name=Susan Reeder, SUID=100014, Email=sreeder@seattleu.edu, Status=ACTIVE, Type=SEN_INSTRUCT, Office=ENGR 505
Faculty: Name=Michael McKee, SUID=100010, Email=mckeem@seattleu.edu, Status=ACTIVE, Type=LECTURE, Office=ENGR 519
Faculty: Name=Aditya Mishra, SUID=100011, Email=mishraa@seattleu.edu, Status=ACTIVE, Type=ASSTPROF, Office=ENGR 507
Faculty: Name=Pejman Khadivi, SUID=100003, Email=khadivip@seattleu.edu, Status=ACTIVE, Type=ASSTPROF, Office=ENGR 521
Faculty: Name=Richard LeBlanc, SUID=100006, Email=leblanc@seattleu.edu, Status=ACTIVE, Type=PROF, Office=ENGR 527
Faculty: Name=Lin Li, SUID=100007, Email=lil@seattleu.edu, Status=ACTIVE, Type=ASSTPROF, Office=ENGR 529
Faculty: Name=Eric Larson, SUID=100005, Email=elarson@seattleu.edu, Status=ACTIVE, Type=PROF, Office=ENGR 528
Faculty: Name=David Lillethun, SUID=100008, Email=lillethd@seattleu.edu, Status=ACTIVE, Type=ASSTPROF, Office=ENGR 506
Faculty: Name=Adair Dingle, SUID=100001, Email=dingle@seattleu.edu, Status=ACTIVE, Type=PROF, Office=ENGR 531
Faculty: Name=Steven Hanks, SUID=100002, Email=hankssteven@seattleu.edu, Status=ACTIVE, Type=LECTURE, Office=ENGR 511
Faculty: Name=Michael Koenig, SUID=100004, Email=koenigm@seattleu.edu, Status=ACTIVE, Type=LECTURE, Office=ENGR 520
Faculty: Name=Yingwu Zhu, SUID=100017, Email=zhuy@seattleu.edu, Status=ACTIVE, Type=ASSOCPROF, Office=ENGR 530
Faculty: Name=Sheila Oh, SUID=100013, Email=ohsh@seattleu.edu, Status=ACTIVE, Type=SEN_INSTRUCT, Office=ENGR 504


-- STUDENT LIST --
Student: Name=Katherine Johnson, SUID=100031, Email=katherinejohnson@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=MSCS, Term=FQ 2018, Advisor=Aditya Mishra
Student: Name=Maeby Funke, SUID=100024, Email=maebyfunke@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BSCS, Term=SQ 2017, Advisor=Roshanak Roshandel, Year=JUNIOR
Student: Name=Marie Curie, SUID=100029, Email=mariecurie@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=CERT, Term=FQ 2017, Advisor=Michael McKee
Student: Name=Alan Turing, SUID=100030, Email=alanturing@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=CERT, Term=RQ 2017, Advisor=Richard LeBlanc
Student: Name=Buster Bluth, SUID=100020, Email=busterbluth@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BSCS, Term=WQ 2018, Advisor=Michael McKee, Year=SOPHOMORE
Student: Name=Gob Bluth, SUID=100019, Email=gobbluth@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BACS, Term=SQ 2018, Advisor=David Lillethun, Year=SOPHOMORE
Student: Name=Lindsay Funke, SUID=100022, Email=lindsayfunke@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BACS, Term=FQ 2018, Advisor=Adair Dingle, Year=SOPHOMORE
Student: Name=Kitty Sanchez, SUID=100025, Email=kittysanchez@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=UNDECIDED, Term=FQ 2018, Advisor=Adair Dingle, Year=SOPHOMORE
Student: Name=Lucille Bluth, SUID=100021, Email=lucillebluth@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BSCS, Term=WQ 2017, Advisor=Susan Reeder, Year=JUNIOR
Student: Name=Edsger Dijkstra, SUID=100026, Email=edsgerdijkstra@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=CERT, Term=RQ 2018, Advisor=David Lillethun
Student: Name=Michael Bluth, SUID=100018, Email=michaelbluth@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BSCS, Term=FQ 2018, Advisor=Jason Wong, Year=SOPHOMORE
Student: Name=Ada Lovelace, SUID=100027, Email=adalovelace@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=CERT, Term=FQ 2018, Advisor=Michael Koenig
Student: Name=Grace Hopper, SUID=100028, Email=gracehopper@seattleu.edu, Status=ACTIVE, Type=GRAD, Program=MSCS, Term=WQ 2017, Advisor=Adair Dingle
Student: Name=Tobias Funke, SUID=100023, Email=tobiasfunke@seattleu.edu, Status=ACTIVE, Type=UNDERGRAD, Program=BACS, Term=FQ 2017, Advisor=Susan Reeder, Year=JUNIOR


-- SUBJECT LIST --
Subject: Biology (BIOL)
Subject: Chemistry (CHEM)
Subject: Mathematics (MATH)
Subject: Computer Science (CPSC)


-- COURSE LIST --
Course: Name=CPSC-2600: Foundations of Computer Science, Credits=5, Prerequisites=[Name=CPSC-1430: Programming and Problem Solving II]
Course: Name=CPSC-5800: Ethics and Professional Issues in Computing, Credits=2, Prerequisites=[]
Course: Name=CPSC-5610: Artificial Intelligence, Credits=5, Prerequisites=[Name=CPSC-5031: Data Structures and Algorithms]
Course: Name=CPSC-3500: Computing Systems, Credits=5, Prerequisites=[Name=CPSC-2430: Data Structures, Name=CPSC-2500: Computer Organization]
Course: Name=CPSC-5600: Parallel Computing, Credits=5, Prerequisites=[Name=CPSC-5031: Data Structures and Algorithms, Name=CPSC-5042: Computing Systems Principles II]
Course: Name=CPSC-3300: Fundamentals of Databases, Credits=5, Prerequisites=[Name=CPSC-2430: Data Structures]
Course: Name=CPSC-5031: Data Structures and Algorithms, Credits=3, Prerequisites=[]
Course: Name=CPSC-5240: Software as a Service, Credits=5, Prerequisites=[Name=CPSC-5042: Computing Systems Principles II]
Course: Name=CPSC-5051: Fundamentals of Software Engineering, Credits=3, Prerequisites=[]
Course: Name=CPSC-2430: Data Structures, Credits=5, Prerequisites=[Name=CPSC-1430: Programming and Problem Solving II]
Course: Name=CPSC-5041: Computing Systems Principles I, Credits=3, Prerequisites=[]
Course: Name=CPSC-5042: Computing Systems Principles II, Credits=3, Prerequisites=[Name=CPSC-5041: Computing Systems Principles I]
Course: Name=CPSC-5300: Physical Database Design & Optimization, Credits=5, Prerequisites=[Name=CPSC-5021: Database Systems]
Course: Name=CPSC-5001: Programming Boot Camp I, Credits=3, Prerequisites=[]
Course: Name=CPSC-3400: Languages and Computation, Credits=5, Prerequisites=[Name=CPSC-2430: Data Structures, Name=CPSC-2600: Foundations of Computer Science]
Course: Name=CPSC-5003: Programming Boot Camp III, Credits=3, Prerequisites=[Name=CPSC-5002: Programming Boot Camp II]
Course: Name=CPSC-5002: Programming Boot Camp II, Credits=3, Prerequisites=[Name=CPSC-5001: Programming Boot Camp I]
Course: Name=CPSC-1420: Programming and Problem Solving I, Credits=5, Prerequisites=[]
Course: Name=CPSC-3200: Object-Oriented Development, Credits=5, Prerequisites=[Name=CPSC-2430: Data Structures]
Course: Name=CPSC-5250: Mobile Software Development, Credits=5, Prerequisites=[Name=CPSC-5011: Object-Oriented Concepts]
Course: Name=CPSC-2500: Computer Organization, Credits=5, Prerequisites=[Name=CPSC-1430: Programming and Problem Solving II]
Course: Name=CPSC-4100: Design and Analysis of Algorithms, Credits=5, Prerequisites=[Name=CPSC-2430: Data Structures, Name=CPSC-2600: Foundations of Computer Science]
Course: Name=CPSC-5700: Computer Graphics, Credits=5, Prerequisites=[Name=CPSC-5031: Data Structures and Algorithms]
Course: Name=CPSC-5510: Computer Networks, Credits=5, Prerequisites=[Name=CPSC-5042: Computing Systems Principles II]
Course: Name=CPSC-5400: Complier Principles and Techniques, Credits=5, Prerequisites=[]
Course: Name=CPSC-5021: Database Systems, Credits=3, Prerequisites=[Name=CPSC-5003: Programming Boot Camp III]
Course: Name=CPSC-5200: Software Architecture and Design, Credits=5, Prerequisites=[Name=CPSC-5011: Object-Oriented Concepts, Name=CPSC-5051: Fundamentals of Software Engineering]
Course: Name=CPSC-5520: Distributed Systems, Credits=5, Prerequisites=[Name=CPSC-5042: Computing Systems Principles II]
Course: Name=CPSC-5011: Object-Oriented Concepts, Credits=3, Prerequisites=[Name=CPSC-5003: Programming Boot Camp III]
Course: Name=CPSC-1430: Programming and Problem Solving II, Credits=5, Prerequisites=[Name=CPSC-1420: Programming and Problem Solving I]


-- SECTION LIST --
Section: Course=CPSC-2430-02: Data Structures, Faculty=Adair Dingle, Term=FQ 2018, Capacity=30, Room=PIGT 207
Section: Course=CPSC-5021-01: Database Systems, Faculty=Michael McKee, Term=FQ 2018, Capacity=36, Room=BANN 401
Section: Course=CPSC-5021-02: Database Systems, Faculty=Michael McKee, Term=FQ 2018, Capacity=30, Room=LEML 122
Section: Course=CPSC-2430-01: Data Structures, Faculty=Susan Reeder, Term=FQ 2018, Capacity=15, Room=PIGT 207
Section: Course=CPSC-5600-02: Parallel Computing, Faculty=Kevin Lundeen, Term=FQ 2018, Capacity=20, Room=BANN 402
Section: Course=CPSC-5011-01: Object-Oriented Concepts, Faculty=Steven Hanks, Term=FQ 2018, Capacity=20, Room=ADMN 203
Section: Course=CPSC-5510-01: Computer Networks, Faculty=David Lillethun, Term=FQ 2018, Capacity=30, Room=ENGR 304
Section: Course=CPSC-4100-01: Design and Analysis of Algorithms, Faculty=Yingwu Zhu, Term=FQ 2018, Capacity=34, Room=PIGT 102
Section: Course=CPSC-5011-02: Object-Oriented Concepts, Faculty=Sheila Oh, Term=FQ 2018, Capacity=30, Room=LEML 122
Section: Course=CPSC-2600-01: Foundations of Computer Science, Faculty=Sheila Oh, Term=FQ 2018, Capacity=30, Room=LEML 122
```
###Extra Credit
_Extra Credit assignments will not be graded unless you receive at least an 85% on the regular assignment._

Create a class diagram for the RegistrationSystem. You only need to include class names and relationships (including cardinality). Fields and operations do not need to be included in the class diagram. Use Visio or draw.io (Links to an external site.) to create a PDF of your class diagram.

### Notes:

* Explain any assumptions made or issues with the extra credit in the README.
* You may receive at most 4 extra credit points. 
### Submission
* Push the code to your Github Classroom repo.
* Follow the directory structure outline above.
* Don't submit .idea, .project, etc. files from the IDE.
* Don't submit out/, classes/, or other locations with compiled .class files.
* Please edit the README.md file to include informal comments
   * Is your solution fully working or not? 
   * Justify any additional classes you included in your solution.
   * Did you work on the extra credit problem? Briefly describe any issues or explain any assumptions made.
   * How much time did you spend on the assignment?
   * Any feedback on the assignment?