# Booking-System

The purpose of this project is to create a desktop based JavaFX application to manage
classroom bookings at IIITD. The application will read data from the csv file which holds
information about the time table of the semester. Time table will have information about the time
slot for the course, room allotted for that course, total capacity of that room, and intended
audience of the course. Your application will block all the predefined required classrooms as per
the timetable.
Apart from booking the rooms, students should also be able to use this application to help them
choose courses based on the post-conditions hints specified by students. This feature should
only be available in a student login. Each courses in the database that are being offered for a
semester also contains the list of its post-conditions. The application provides a search bar in
which student can put keywords as a hint for post-conditions. Out of all the remaining courses
that the student hasn’t registered, the system will filter out a list of courses whose
post-conditions contains one or more of the keywords specified by the student. As an example,
if the student specifies the keyword “programming” in the search bar, then the system will
shortlist Foundations of Parallel Programming and GPU Computing as two of the courses,
provided its being offered in that semester. Apart from this, the system must also ensure that
the lecture timings of these shortlisted courses should not conflict with the timings of student’s
regular courses. It’s quite possible that two or more shortlisted courses are scheduled same
time. In that case student will select one of the course based on his interest. Once the student
chooses this course, it will then be added to their personalized time table. This feature will be
helpful for students who wants to attend (or audit) some course related to their interest area but
are not aware of such courses (there are more than 400 courses in IIITD!).

What an Admin can do:
○ View the room booked / room availability.
○ Cancel a room booking if required.
○ Book a room if available.
○ Accept or reject the request from the students for room booking.
● Faculty
○ View the room booked / room availability.
○ Book a room if available.
○ Cancel the room booking if not required.
● Student
○ View the room booked / room availability.
○ Request for room booking.
■ This request will contain information about the purpose of booking,
preferred room (optional), and required capacity.
■ Request will go to admin for approval, if approved by admin its should
show as booked.
■ If admin doesn’t reply then the request will automatically get cancelled
after 5 days of the the request.
● Admin and faculties both can book the room with same priority.
● Information about prerequisite of the each course will be stored in the database.

The backend database used is MySql. 
The tables this database has:
 -AllCourses 
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| number     | int(11)     | YES  |     | NULL    |       |
| type       | varchar(50) | YES  |     | NULL    |       |
| course     | varchar(50) | YES  |     | NULL    |       |
| code       | varchar(20) | YES  |     | NULL    |       |
| instructor | varchar(50) | YES  |     | NULL    |       |
| credits    | int(11)     | YES  |     | NULL    |       |
| short      | varchar(20) | YES  |     | NULL    |       |
| mon_st     | time        | YES  |     | NULL    |       |
| mon_ed     | time        | YES  |     | NULL    |       |
| mon_room   | varchar(10) | YES  |     | NULL    |       |
| tue_st     | time        | YES  |     | NULL    |       |
| tue_ed     | time        | YES  |     | NULL    |       |
| tue_room   | varchar(10) | YES  |     | NULL    |       |
| wed_st     | time        | YES  |     | NULL    |       |
| wed_ed     | time        | YES  |     | NULL    |       |
| wed_room   | varchar(10) | YES  |     | NULL    |       |
| thurs_st   | time        | YES  |     | NULL    |       |
| thurs_ed   | time        | YES  |     | NULL    |       |
| thurs_room | varchar(10) | YES  |     | NULL    |       |
| fri_st     | time        | YES  |     | NULL    |       |
| fri_ed     | time        | YES  |     | NULL    |       |
| fri_room   | varchar(10) | YES  |     | NULL    |       |

 -CoursesTaken
 | Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| course | varchar(50) | YES  |     | NULL    |       |
| name   | varchar(50) | YES  |     | NULL    |       |
| email  | varchar(50) | YES  |     | NULL    |       |
 
 -FacultyCourse 
 | Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| course  | varchar(50) | NO   | PRI | NULL    |       |
| email   | varchar(50) | YES  |     | NULL    |       |
| name    | varchar(50) | YES  |     | NULL    |       |
| result  | varchar(50) | YES  |     | NULL    |       |
| details | varchar(50) | YES  |     | NULL    |       |
| credits | int(11)     | YES  |     | NULL    |       |

 -Login 
 | Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| name     | varchar(50) | YES  |     | NULL    |                |
| email    | varchar(50) | YES  | UNI | NULL    |                |
| password | varchar(50) | YES  |     | NULL    |                |
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| type     | varchar(15) | YES  |     | NULL    |                |

 -Requests 
 | Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| number   | varchar(5)  | YES  |     | NULL    |       |
| capacity | int(11)     | YES  |     | NULL    |       |
| purpose  | varchar(50) | YES  |     | NULL    |       |
| name     | varchar(50) | YES  |     | NULL    |       |
| email    | varchar(50) | NO   |     | NULL    |       |
| start_at | time        | YES  |     | NULL    |       |
| end_at   | time        | YES  |     | NULL    |       |
| day      | date        | YES  |     | NULL    |       |

 -RoomsBooked 
 | Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| number   | varchar(5)  | NO   |     | NULL    |       |
| capacity | int(11)     | YES  |     | NULL    |       |
| purpose  | varchar(50) | YES  |     | NULL    |       |
| name     | varchar(50) | YES  |     | NULL    |       |
| email    | varchar(50) | NO   |     | NULL    |       |
| start_at | time        | YES  |     | NULL    |       |
| end_at   | time        | YES  |     | NULL    |       |
| day      | date        | YES  |     | NULL    |       |



 
