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

    // Unique identifier for the doctor
    private final String code;
    // Name of the doctor
    private String name;
    // Specialization of the doctor
    private String specialization;
    // Availability status of the doctor
    private int availability;

    /**
     * Constructor to initialize a Doctor object with specified attributes.
     *
     * @param code           Unique code for the doctor
     * @param name           Name of the doctor
     * @param specialization Specialization of the doctor
     * @param availability   Availability status of the doctor
     */
    public Doctor(String code, String name, String specialization, int availability) {
        // Set the code
        this.code = code;
        // Set the name
        this.name = name;
        // Set the specialization
        this.specialization = specialization;
        // Ensure availability is non-negative
        this.availability = Math.max(availability, -1);
    }

    /**
     * Checks if any required information is missing for the doctor.
     *
     * @return true if any information is missing, false otherwise
     */
    public boolean isMissing() {
        // Check for missing information
        return code.isEmpty() || name.isEmpty() || specialization.isEmpty() || availability == -1;
    }

    /**
     * Gets the unique code of the doctor.
     *
     * @return The doctor's code.
     */
    public String getCode() {
        // Return the doctor's code
        return code;
    }

    /**
     * Gets the name of the doctor.
     *
     * @return The doctor's name.
     */
    public String getName() {
        // Return the doctor's name
        return name;
    }

    /**
     * Sets the name of the doctor.
     *
     * @param name The new name for the doctor.
     */
    public void setName(String name) {
        // Set the doctor's name
        this.name = name;
    }

    /**
     * Gets the specialization of the doctor.
     *
     * @return The doctor's specialization.
     */
    public String getSpecialization() {
        // Return the doctor's specialization
        return specialization;
    }

    /**
     * Sets the specialization of the doctor.
     *
     * @param specialization The new specialization for the doctor.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the availability status of the doctor.
     *
     * @return The doctor's availability.
     */
    public int getAvailability() {
        // Return the doctor's availability
        return availability;
    }

    /**
     * Sets the availability status of the doctor.
     *
     * @param availability The new availability status for the doctor.
     */
    public void setAvailability(int availability) {
        // Set the doctor's availability
        this.availability = availability;
    }
}
