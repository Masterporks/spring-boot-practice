package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;

import java.util.List;

/**
 * To handle all School related operations
 */
public interface SchoolService {
    /**
     * To create a new school
     *
     * @param school School
     */
    void createSchool(School school);

    /**
     * To find a school by Id
     * @param id School Id
     * @return School
     */
    School findSchoolById(Long id) throws SchoolNotFoundException;

    /**
     *
     * To find a School by Name
     * @param name School name
     * @return School
     */
    School findSchoolByName(String name) throws SchoolNotFoundException;

    /**
     *
     * To find all schools
     * @return list of Schools
     */
    List<School> findAllSchools();


    /**
     * To update an excisting school
     * @param school School
     */
    void updateSchool(School school) throws SchoolNotFoundException;


    /**
     * To delete School by Id
     * @param id School ID
     */

    void deleteSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException;

    /**
     * To Restore a School by ID
     * @param id School ID
     */
    void restoreSchoolById(Long id) throws SchoolNotFoundException, CourseNotFoundException;

}
