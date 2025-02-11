/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.*;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * DoctorDatabase class manages the storage and operations related to doctors.
 */
public class DoctorDatabase {

    // HashMap to store doctors by their code
    private static final HashMap<String, Doctor> hMapDoctor = new HashMap<>();

    /**
     * Adds a new doctor to the database.
     * 
     * @param code           The unique code for the doctor.
     * @param name           The name of the doctor.
     * @param specialization The specialization of the doctor.
     * @param availability   The availability of the doctor.
     */
    public static void addDoctor(String code, String name, String specialization, String availability) {
        // Convert code to uppercase
        code = code.toUpperCase();
        // Add the new doctor to the HashMap
        hMapDoctor.put(code, new Doctor(code, name, specialization, Integer.parseInt(availability)));
    }

    /**
     * Updates an existing doctor's information in the database.
     * 
     * @param code           The unique code for the doctor.
     * @param name           The new name of the doctor.
     * @param specialization The new specialization of the doctor.
     * @param availability   The new availability of the doctor.
     */
    public static void updateDoctor(String code, String name, String specialization, String availability) {
        // Call addDoctor to update the doctor's information
        addDoctor(code, name, specialization, availability);
    }

    /**
     * Deletes a doctor from the database using their code.
     * 
     * @param code The unique code for the doctor to be deleted.
     */
    public static void deleteDoctor(String code) {
        // Remove the doctor from the HashMap
        hMapDoctor.remove(code);
    }

    /**
     * Searches for doctors based on a search text.
     * 
     * @param searchText The text to search for in doctor details.
     * @return A 2D array containing the details of matching doctors.
     */
    public static String[][] searchDoctor(String searchText) {
        // Convert search text to uppercase
        searchText = searchText.toUpperCase();
        // Create a list to hold matching doctors
        List<Doctor> doctorList = new ArrayList<>();

        // Iterate through the doctors in the HashMap
        for (Doctor doctor : hMapDoctor.values()) {
            // Check if the doctor's details match the search text
            if (doctor.getCode().contains(searchText)
                    || doctor.getName().toUpperCase().contains(searchText)
                    || doctor.getSpecialization().toUpperCase().contains(searchText)) {
                // Add matching doctor to the list
                doctorList.add(doctor);
            } else {
                try {
                    // Check if availability matches the search text
                    if (doctor.getAvailability() == Integer.parseInt(searchText)) {
                        // Add matching doctor to the list
                        doctorList.add(doctor);
                    }
                } catch (NumberFormatException e) {
                    // Handle exception if search text is not a number
                }
            }
        }

        // Create a 2D array to hold the output
        String[][] output = new String[doctorList.size()][4];
        // Initialize a counter for the output array
        int count = 0;
        // Populate the output array with doctor details
        for (Doctor doctor : doctorList) {
            // Store the doctor's code in the output array
            output[count][0] = doctor.getCode();
            // Store the doctor's name in the output array
            output[count][1] = doctor.getName();
            // Store the doctor's specialization in the output array
            output[count][2] = doctor.getSpecialization();
            // Store the doctor's availability in the output array
            output[count][3] = doctor.getAvailability() + "";
            // Increment the counter
            count++;
        }

        // Return the array of matching doctors
        return output;
    }

    /**
     * Finds a doctor by their unique code.
     * 
     * @param code The unique code for the doctor.
     * @return The Doctor object if found, otherwise null.
     */
    public static Doctor findByCode(String code) {
        // Trim and convert code to uppercase
        code = code.trim().toUpperCase();
        // Return the doctor from the HashMap
        return hMapDoctor.get(code);
    }

    /**
     * Validates the doctor code.
     * 
     * @param code The code to validate.
     * @return An error message if invalid, otherwise null.
     */
    public static String checkCodeValid(String code) {
        // Convert code to uppercase
        code = code.toUpperCase();
        // Check if code is empty
        if (code.length() == 0) {
            return "Code must not be empty";
        }
        // Check if code contains spaces
        if (code.contains(" ")) {
            return "Code must not contain spaces";
        }
        // Check if code contains special characters
        if (!code.matches("^[0-9A-Za-z]*$")) {
            return "Code must not contain special characters";
        }
        // Check if code starts with "DOC"
        if (!code.startsWith("DOC")) {
            return "Code must start with \"DOC\"";
        }
        // Check if code already exists in the HashMap
        if (hMapDoctor.keySet().contains(code)) {
            return "Code already exists";
        }
        // Return null if valid
        return null;
    }

    /**
     * Validates the doctor's name.
     * 
     * @param name The name to validate.
     * @return An error message if invalid, otherwise null.
     */
    public static String checkNameValid(String name) {
        // Trim the name
        name = name.trim();
        // Check if name is empty
        if (name.length() == 0) {
            return "Name must not be empty";
        }
        // Return null if valid
        return null;
    }

    /**
     * Validates the doctor's specialization.
     * 
     * @param specialization The specialization to validate.
     * @return An error message if invalid, otherwise null.
     */
    public static String checkSpecializationValid(String specialization) {
        // Trim the specialization
        specialization = specialization.trim();
        // Check if specialization is empty
        if (specialization.length() == 0) {
            return "Specialization must not be empty";
        }
        // Return null if valid
        return null;
    }

    /**
     * Validates the doctor's availability.
     * 
     * @param availability The availability to validate.
     * @return An error message if invalid, otherwise null.
     */
    public static String checkAvailabilityValid(String availability) {
        // Trim the availability
        availability = availability.trim();
        // Check if availability is empty
        if (availability.length() == 0) {
            return "Availability must not be empty";
        }
        // Check if availability is an integer
        if (!availability.matches("^-?[0-9]+$")) {
            return "Availability must be an integer";
        }
        // Check if availability is non-negative
        if (availability.startsWith("-")) {
            return "Availability must be non-negative";
        }
        // Return null if valid
        return null; 
    }

    /**
     * Validates all fields for a doctor.
     * 
     * @param code           The code of the doctor.
     * @param name           The name of the doctor.
     * @param specialization The specialization of the doctor.
     * @param availability   The availability of the doctor.
     * @return An error message if any field is invalid, otherwise null.
     */
    public static String checkAllValid(String code, String name, String specialization, String availability) {
        // Validate the doctor code
        if (code != null && DoctorDatabase.checkCodeValid(code) != null) {
            // Return error message
            return DoctorDatabase.checkCodeValid(code);
        }
        // Validate the doctor's name
        if (DoctorDatabase.checkNameValid(name) != null) {
            // Return error message
            return DoctorDatabase.checkNameValid(name);
        }
        // Validate the doctor's specialization
        if (DoctorDatabase.checkSpecializationValid(specialization) != null) {
            // Return error message
            return DoctorDatabase.checkSpecializationValid(specialization);
        }
        // Validate the doctor's availability
        if (DoctorDatabase.checkAvailabilityValid(availability) != null) {
            // Return error message
            return DoctorDatabase.checkAvailabilityValid(availability);
        }
        // Return null if valid
        return null;
    }
}
