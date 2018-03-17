# Booking-System

The purpose of this project is to create a desktop based JavaFX application to manage
classroom bookings at IIITD. The application will read data from the csv file which holds
information about the time table of the semester. Time table will have information about the time
slot for the course, room allotted for that course, total capacity of that room, and intended
audience of the course. Your application will block all the predefined required classrooms as per
the timetable.<br />
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
are not aware of such courses (there are more than 400 courses in IIITD!).<br />
<br />
What an Admin can do:<br />
○ View the room booked / room availability.<br />
○ Cancel a room booking if required.<br />
○ Book a room if available.<br />
○ Accept or reject the request from the students for room booking.<br />
● Faculty<br />
○ View the room booked / room availability.<br />
○ Book a room if available.<br />
○ Cancel the room booking if not required.<br />
● Student<br />
○ View the room booked / room availability.<br />
○ Request for room booking.<br />
■ This request will contain information about the purpose of booking,
preferred room (optional), and required capacity.
■ Request will go to admin for approval, if approved by admin its should
show as booked.<br />
■ If admin doesn’t reply then the request will automatically get cancelled
after 5 days of the the request.<br />
● Admin and faculties both can book the room with same priority.<br />
● Information about prerequisite of the each course will be stored in the database.<br />
<br /><br />
The backend database used is MySql. <br />
The tables this database has:<br />
 -AllCourses <br />
| Field      | Type        | Null | Key | Default | Extra |<br />
+------------+-------------+------+-----+---------+-------+<br />
| number     | int(11)     | YES  |     | NULL    |       |<br />
| type       | varchar(50) | YES  |     | NULL    |       |<br />
| course     | varchar(50) | YES  |     | NULL    |       |<br />
| code       | varchar(20) | YES  |     | NULL    |       |<br />
| instructor | varchar(50) | YES  |     | NULL    |       |<br />
| credits    | int(11)     | YES  |     | NULL    |       |<br />
| short      | varchar(20) | YES  |     | NULL    |       |<br />
| mon_st     | time        | YES  |     | NULL    |       |<br />
| mon_ed     | time        | YES  |     | NULL    |       |<br />
| mon_room   | varchar(10) | YES  |     | NULL    |       |<br />
| tue_st     | time        | YES  |     | NULL    |       |<br />
| tue_ed     | time        | YES  |     | NULL    |       |<br />
| tue_room   | varchar(10) | YES  |     | NULL    |       |<br />
| wed_st     | time        | YES  |     | NULL    |       |<br />
| wed_ed     | time        | YES  |     | NULL    |       |<br />
| wed_room   | varchar(10) | YES  |     | NULL    |       |<br />
| thurs_st   | time        | YES  |     | NULL    |       |<br />
| thurs_ed   | time        | YES  |     | NULL    |       |<br />
| thurs_room | varchar(10) | YES  |     | NULL    |       |<br />
| fri_st     | time        | YES  |     | NULL    |       |<br />
| fri_ed     | time        | YES  |     | NULL    |       |<br />
| fri_room   | varchar(10) | YES  |     | NULL    |       |<br />
<br /><br />
 -CoursesTaken<br />
 | Field  | Type        | Null | Key | Default | Extra |<br />
+--------+-------------+------+-----+---------+-------+<br />
| course | varchar(50) | YES  |     | NULL    |       |<br />
| name   | varchar(50) | YES  |     | NULL    |       |<br />
| email  | varchar(50) | YES  |     | NULL    |       |<br />
 <br /><br />
 -FacultyCourse <br />
 | Field   | Type        | Null | Key | Default | Extra |<br />
+---------+-------------+------+-----+---------+-------+<br />
| course  | varchar(50) | NO   | PRI | NULL    |       |<br />
| email   | varchar(50) | YES  |     | NULL    |       |<br />
| name    | varchar(50) | YES  |     | NULL    |       |<br />
| result  | varchar(50) | YES  |     | NULL    |       |<br />
| details | varchar(50) | YES  |     | NULL    |       |<br />
| credits | int(11)     | YES  |     | NULL    |       |<br />
<br /><br />
 -Login <br />
 | Field    | Type        | Null | Key | Default | Extra          |<br />
+----------+-------------+------+-----+---------+----------------+<br />
| name     | varchar(50) | YES  |     | NULL    |                |<br />
| email    | varchar(50) | YES  | UNI | NULL    |                |<br />
| password | varchar(50) | YES  |     | NULL    |                |<br />
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |<br />
| type     | varchar(15) | YES  |     | NULL    |                |<br />
<br /><br />
 -Requests <br />
 | Field    | Type        | Null | Key | Default | Extra |<br />
+----------+-------------+------+-----+---------+-------+<br />
| number   | varchar(5)  | YES  |     | NULL    |       |<br />
| capacity | int(11)     | YES  |     | NULL    |       |<br />
| purpose  | varchar(50) | YES  |     | NULL    |       |<br />
| name     | varchar(50) | YES  |     | NULL    |       |<br />
| email    | varchar(50) | NO   |     | NULL    |       |<br />
| start_at | time        | YES  |     | NULL    |       |<br />
| end_at   | time        | YES  |     | NULL    |       |<br />
| day      | date        | YES  |     | NULL    |       |<br />
<br /><br />
 -RoomsBooked <br />
 | Field    | Type        | Null | Key | Default | Extra |<br />
+----------+-------------+------+-----+---------+-------+<br />
| number   | varchar(5)  | NO   |     | NULL    |       |<br />
| capacity | int(11)     | YES  |     | NULL    |       |<br />
| purpose  | varchar(50) | YES  |     | NULL    |       |<br />
| name     | varchar(50) | YES  |     | NULL    |       |<br />
| email    | varchar(50) | NO   |     | NULL    |       |<br />
| start_at | time        | YES  |     | NULL    |       |<br />
| end_at   | time        | YES  |     | NULL    |       |<br />
| day      | date        | YES  |     | NULL    |       |<br />



 
