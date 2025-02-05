/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * Represents a Doctor with attributes such as code, name, specialization, and
 * availability.
 * Provides methods to access and modify these attributes.
 */
public class Doctor {

    private final String code; // Unique identifier for the doctor
    private String name; // Name of the doctor
    private String specialization; // Specialization of the doctor
    private int availability; // Availability status of the doctor

    /**
     * Constructor to initialize a Doctor object with specified attributes.
     *
     * @param code           Unique code for the doctor
     * @param name           Name of the doctor
     * @param specialization Specialization of the doctor
     * @param availability   Availability status of the doctor
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code; // Set the code
        this.name = name; // Set the name
        this.specialization = specialization; // Set the specialization
        this.availability = Math.max(availability, -1); // Ensure availability is non-negative
    }

    /**
     * Checks if any required information is missing for the doctor.
     *
     * @return true if any information is missing, false otherwise
     */
    public boolean isMissing() {
        return code.isEmpty() || name.isEmpty() || specialization.isEmpty() || availability == -1;
    }

    public String getCode() {
        return code; // Return the doctor's code
    }

    public String getName() {
        return name; // Return the doctor's name
    }

    public void setName(String name) {
        this.name = name; // Set the doctor's name
    }

    public String getSpecialization() {
        return specialization; // Return the doctor's specialization
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization; // Set the doctor's specialization
    }

    public int getAvailability() {
        return availability; // Return the doctor's availability
    }

    public void setAvailability(int availability) {
        this.availability = availability; // Set the doctor's availability
    }

}
