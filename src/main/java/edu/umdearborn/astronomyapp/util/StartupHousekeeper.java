package edu.umdearborn.astronomyapp.util;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.Assert;

import edu.umdearborn.astronomyapp.config.annotation.Dev;

@Dev
@Configuration
@Transactional
public class StartupHousekeeper {
  // private static final Logger logger = LoggerFactory.getLogger(StartupHousekeeper.class);

  // private static final Logger logger = LoggerFactory.getLogger(StartupHousekeeper.class);

  private EntityManager em;

  private static final String SQL = "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('admin1', 'admin1name@umich.edu', 'admin1name', true, true, true, true, 'admin1name', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('admin2', 'admin2name@umich.edu', 'admin2name', true, true, true, true, 'admin2name', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('adminstructor1', 'adminstructor1@umich.edu', 'admininst1', true, true, true, true, 'admininst1', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('adminstructor2', 'adminstructor2@umich.edu', 'admininst2', true, true, true, true, 'admininst2', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('instructor3', 'instructor3@umich.edu', '', true, true, true, true, '', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('instructor4', 'instructor4@umich.edu', 'instructor4fname', true, true, true, true, 'instructor4lname', 'password');\r\n"
      + "\r\n" + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User1', 'User1@umich.edu', 'User1fname', true, true, true, true, 'User1lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User2', 'User2@umich.edu', 'User2fname', true, true, true, true, 'User2lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User3', 'User3@umich.edu', 'User3fname', true, true, true, true, 'User3lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User4', 'User4@umich.edu', 'User4fname', true, true, true, true, 'User4lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User5', 'User5@umich.edu', 'User5fname', true, true, true, true, 'User5lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User6', 'User6@umich.edu', 'User6fname', true, true, true, true, 'User6lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User7', 'User7@umich.edu', 'User7fname', true, true, true, true, 'User7lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User8', 'User8@umich.edu', 'User8fname', true, true, true, true, 'User8lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User9', 'User9@umich.edu', 'User9fname', true, true, true, true, 'User9lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User10', 'User10@umich.edu', 'User10fname', true, true, true, true, 'User10lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User11', 'User11@umich.edu', 'User11fname', true, true, true, true, 'User11lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User12', 'User12@umich.edu', 'User12fname', true, true, true, true, 'User12lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User13', 'User13@umich.edu', 'User13fname', true, true, true, true, 'User13lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User14', 'User14@umich.edu', 'User14fname', true, true, true, true, 'User14lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User15', 'User15@umich.edu', 'User15fname', true, true, true, true, 'User15lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User16', 'User16@umich.edu', 'User16fname', true, true, true, true, 'User16lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User17', 'User17@umich.edu', 'User17fname', true, true, true, true, 'User17lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User18', 'User18@umich.edu', 'User18fname', true, true, true, true, 'User18lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User19', 'User19@umich.edu', 'User19fname', true, true, true, true, 'User19lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User20', 'User20@umich.edu', 'User20fname', true, true, true, true, 'User20lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User21', 'User21@umich.edu', 'User21fname', true, true, true, true, 'User21lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User22', 'User22@umich.edu', 'User22fname', true, true, true, true, 'User22lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User23', 'User23@umich.edu', 'User23fname', true, true, true, true, 'User23lname', 'password');\r\n"
      + "\r\n" + "INSERT INTO astro_app_user(\r\n"
      + "user_id, email, first_name, is_enabled, is_password_non_expired, is_user_non_expired, is_user_non_locked, last_name, password)\r\n"
      + "VALUES ('User24', 'User24@umich.edu', 'User24fname', true, true, true, true, 'User24lname', 'password');\r\n"
      + "\r\n" + "\r\n" + "INSERT INTO role(\r\n" + "user_id, role)\r\n"
      + "VALUES ('admin1', 'ADMIN');\r\n" + "\r\n" + "INSERT INTO role(\r\n" + "user_id, role)\r\n"
      + "VALUES ('admin2', 'ADMIN');\r\n" + "\r\n" + "INSERT INTO role(\r\n" + "user_id, role)\r\n"
      + "VALUES ('adminstructor1', 'ADMIN');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('adminstructor2', 'ADMIN');\r\n" + "\r\n"
      + "INSERT INTO role(\r\n" + "user_id, role)\r\n" + "VALUES ('instructor3', 'USER');\r\n"
      + "\r\n" + "INSERT INTO role(\r\n" + "user_id, role)\r\n"
      + "VALUES ('instructor4', 'USER');\r\n" + "\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User1', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User2', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User3', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User4', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User5', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User6', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User7', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User8', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User9', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User10', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User11', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User12', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User13', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User14', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User15', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User16', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User17', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User18', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User19', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User20', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User21', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User22', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User23', 'USER');\r\n" + "\r\n" + "INSERT INTO role(\r\n"
      + "user_id, role)\r\n" + "VALUES ('User24', 'USER');\r\n" + "\r\n" + "\r\n"
      + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course1A',dateadd('month', 1, current_timestamp), '1Acode', 'course1Atitle',dateadd('month', -1, current_timestamp) , 'subj1A');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course1B',dateadd('month', 1, current_timestamp), '1Bcode', 'course1Btitle', dateadd('month', -1, current_timestamp) , 'subj1B');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course1C',dateadd('month', 1, current_timestamp), '1Ccode', 'course1Ctitle', dateadd('month', -2, current_timestamp) , 'subj1C');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course2A', dateadd('month', 1, current_timestamp), '2Acode', 'course2Atitle',dateadd('month', -1, current_timestamp) , 'subj2A');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course2B', dateadd('month', -1, current_timestamp), '2Bcode', 'course2Btitle',  dateadd('month', -2, current_timestamp), 'subj2B');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course3A', dateadd('month', 1, current_timestamp), '3Acode', 'course3Atitle', dateadd('month', -1, current_timestamp) , 'subj3A');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course3B', dateadd('month', 3, current_timestamp), '3Bcode', 'course3Btitle', dateadd('month', 1, current_timestamp) , 'subj3B');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course4A', dateadd('month', 1, current_timestamp), '4Acode', 'course4Atitle', dateadd('month', -1, current_timestamp) , 'subj4A');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course4B', dateadd('month', 1, current_timestamp), '4Bcode', 'course4Btitle', dateadd('month', -1, current_timestamp) , 'subj4B');\r\n"
      + "\r\n" + "INSERT INTO course(\r\n"
      + "course_id, close_timestamp, course_code, course_title, open_timestamp, subject_code)\r\n"
      + "VALUES ('course4C', dateadd('month', 1, current_timestamp), '4Ccode', 'course4Ctitle', dateadd('month', -2, current_timestamp) , 'subj4C');\r\n"
      + "\r\n" + "\r\n" + "INSERT INTO course_user(\r\n"
      + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('1A-instruc', true, 'INSTRUCTOR', 'course1A', 'adminstructor1');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('1B-instruc', true, 'INSTRUCTOR', 'course1B', 'adminstructor1');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('1C-instruc', true, 'INSTRUCTOR', 'course1C', 'adminstructor1');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('2A-instruc', true, 'INSTRUCTOR', 'course2A', 'adminstructor2');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('2B-instruc', true, 'INSTRUCTOR', 'course2B', 'adminstructor2');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('3A-instruc', true, 'INSTRUCTOR', 'course3A', 'instructor3');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('3B-instruc', true, 'INSTRUCTOR', 'course3B', 'instructor3');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('4A-instruc', true, 'INSTRUCTOR', 'course4A', 'instructor4');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('4B-instruc', true, 'INSTRUCTOR', 'course4B', 'instructor4');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('4C-instruc', true, 'INSTRUCTOR', 'course4C', 'instructor4');\r\n" + "\r\n"
      + "\r\n" + "INSERT INTO course_user(\r\n"
      + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course1A', true, 'STUDENT', 'course1A', 'User1');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course2A', true, 'STUDENT', 'course2A', 'User1');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course1A', true, 'STUDENT', 'course1A', 'User2');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course2A', true, 'STUDENT', 'course2A', 'User2');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course1A', true, 'STUDENT', 'course1A', 'User3');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course2A', true, 'STUDENT', 'course2A', 'User3');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course1A', true, 'STUDENT', 'course1A', 'User4');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course2A', true, 'STUDENT', 'course2A', 'User4');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course1A', true, 'STUDENT', 'course1A', 'User5');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course2A', true, 'STUDENT', 'course2A', 'User5');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course1A', true, 'STUDENT', 'course1A', 'User6');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course2A', true, 'STUDENT', 'course2A', 'User6');\r\n" + "\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course1B', true, 'STUDENT', 'course1B', 'User7');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course2B', true, 'STUDENT', 'course2B', 'User7');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course1B', true, 'STUDENT', 'course1B', 'User8');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course2B', true, 'STUDENT', 'course2B', 'User8');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course1B', true, 'STUDENT', 'course1B', 'User9');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course2B', true, 'STUDENT', 'course2B', 'User9');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course1B', true, 'STUDENT', 'course1B', 'User10');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course2B', true, 'STUDENT', 'course2B', 'User10');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course1B', true, 'STUDENT', 'course1B', 'User11');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course2B', true, 'STUDENT', 'course2B', 'User11');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course1B', true, 'STUDENT', 'course1B', 'User12');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course2B', true, 'STUDENT', 'course2B', 'User12');\r\n" + "\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course3A', true, 'STUDENT', 'course3A', 'User13');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course4A', true, 'STUDENT', 'course4A', 'User13');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course3A', true, 'STUDENT', 'course3A', 'User14');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course4A', true, 'STUDENT', 'course4A', 'User14');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course3A', true, 'STUDENT', 'course3A', 'User15');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course4A', true, 'STUDENT', 'course4A', 'User15');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course3A', true, 'STUDENT', 'course3A', 'User16');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course4A', true, 'STUDENT', 'course4A', 'User16');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course3A', true, 'STUDENT', 'course3A', 'User17');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course4A', true, 'STUDENT', 'course4A', 'User17');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course3A', true, 'STUDENT', 'course3A', 'User18');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course4A', true, 'STUDENT', 'course4A', 'User18');\r\n" + "\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course3B', true, 'STUDENT', 'course3B', 'User19');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud1-course4B', true, 'STUDENT', 'course4B', 'User19');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course3B', true, 'STUDENT', 'course3B', 'User20');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud2-course4B', true, 'STUDENT', 'course4B', 'User20');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course3B', true, 'STUDENT', 'course3B', 'User21');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud3-course4B', true, 'STUDENT', 'course4B', 'User21');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course3B', true, 'STUDENT', 'course3B', 'User22');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud4-course4B', true, 'STUDENT', 'course4B', 'User22');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course3B', true, 'STUDENT', 'course3B', 'User23');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud5-course4B', true, 'STUDENT', 'course4B', 'User23');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course3B', true, 'STUDENT', 'course3B', 'User24');\r\n" + "\r\n"
      + "INSERT INTO course_user(\r\n" + "course_user_id, is_active, role, course_id, user_id)\r\n"
      + "VALUES ('stud6-course4B', true, 'STUDENT', 'course4B', 'User24'); \r\n"
      + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod1-course1A', dateadd('week', 2, current_timestamp),dateadd('week', 1, current_timestamp) , 'readable_text', 10, 'mod1-course1Atitle',dateadd('week', -1, current_timestamp) ,dateadd('week', -2, current_timestamp) , 'course1A');\r\n"
      + "\r\n" + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod2-course1A', dateadd('week', 2, current_timestamp),dateadd('week', 1, current_timestamp) , 'readable_text', 10, 'mod2-course1Atitle',dateadd('week', -1, current_timestamp),dateadd('week', -2, current_timestamp), 'course1A');\r\n"
      + "\r\n" + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod3-course1A',dateadd('week', 3, current_timestamp),dateadd('week', 2, current_timestamp), 'readable_text', 10, 'mod3-course1Atitle',dateadd('week', 1, current_timestamp),dateadd('day', 3, current_timestamp) , 'course1A');\r\n"
      + "\r\n" + "\r\n" + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod1-course1B', dateadd('week', 2, current_timestamp),dateadd('week', 1, current_timestamp) , 'readable_text', 10, 'mod1-course1Btitle', dateadd('week', -1, current_timestamp),dateadd('week', -2, current_timestamp) , 'course1B');\r\n"
      + "\r\n" + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod2-course1B', dateadd('week', 2, current_timestamp),dateadd('week', 1, current_timestamp) , 'readable_text', 10, 'mod2-course1Btitle', dateadd('week', -1, current_timestamp),dateadd('week', -2, current_timestamp), 'course1B');\r\n"
      + "\r\n" + "INSERT INTO module(\r\n"
      + "module_id, close_timestamp, due_date, human_readable_text, max_students, module_title, open_timestamp, visible_timestamp, course_id)\r\n"
      + "VALUES ('mod3-course1B', dateadd('week', 3, current_timestamp),dateadd('week', 2, current_timestamp) , 'readable_text', 10, 'mod3-course1Btitle', dateadd('week', 1, current_timestamp),dateadd('week', 1, current_timestamp) , 'course1B');";

  @Autowired
  public StartupHousekeeper(EntityManager em) {
    this.em = em;
  }

  @EventListener
  public void handleContextRefresh(ContextRefreshedEvent event) {
    em.createNativeQuery(SQL).executeUpdate();

  }

  @PostConstruct
  public void onInit() {
    Assert.notNull(em);
  }

}
