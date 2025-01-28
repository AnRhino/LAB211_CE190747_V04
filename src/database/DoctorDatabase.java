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
 * Manages a collection of Doctor objects, allowing for adding, updating,
 * deleting, and searching for doctors in the database.
 *
 * @author Nguyen Ho Phuoc An - CE190747
 */
public class DoctorDatabase {

    private static final HashMap<String, Doctor> hMapDoctor = new HashMap<>(); // HashMap to store doctors by their code

    public static void addDoctor(String code, String name, String specialization, String availability) {
        code = code.toUpperCase();
        hMapDoctor.put(code, new Doctor(code, name, specialization, Integer.parseInt(availability)));
    }

    public static void updateDoctor(String code, String name, String specialization, String availability) {
        addDoctor(code, name, specialization, availability);
    }

    /**
     * Deletes a doctor from the database by their code.
     *
     * @param code The code of the doctor to be deleted
     */
    public static void deleteDoctor(String code) {
        hMapDoctor.remove(code); // Remove the doctor from the HashMap
    }

    public static String[][] searchDoctor(String searchText) {
        searchText = searchText.toUpperCase();
        List<Doctor> doctorList = new ArrayList<>();

        for (Doctor doctor : hMapDoctor.values()) {
            if (doctor.getCode().contains(searchText)
                    || doctor.getName().toUpperCase().contains(searchText)
                    || doctor.getSpecialization().toUpperCase().contains(searchText)) {
                doctorList.add(doctor);
            } else {
                try {
                    if (doctor.getAvailability() == Integer.parseInt(searchText)) {
                        doctorList.add(doctor);
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        String[][] output = new String[doctorList.size()][4];
        int count = 0;
        for (Doctor doctor : doctorList) {
            output[count][0] = doctor.getCode();
            output[count][1] = doctor.getName();
            output[count][2] = doctor.getSpecialization();
            output[count][3] = doctor.getAvailability() + "";
            count++;
        }

        return output;
    }

    /**
     * Finds a doctor by their code.
     *
     * @param code The code of the doctor to find
     * @return The Doctor object if found
     */
    public static Doctor findByCode(String code) {
        code = code.trim().toUpperCase();
        return hMapDoctor.get(code); // Return the found doctor
    }

    public static String checkCodeValid(String code) {
        code = code.toUpperCase();
        if (code.length() == 0) {
            return "Code must not be empty";
        }
        if (code.contains(" ")) {
            return "Code must not contain spaces";
        }
        if (!code.matches("^[0-9A-Za-z]*$")) {
            return "Code must not contain special characters";
        }
        if (!code.startsWith("DOC")) {
            return "Code must start with \"DOC\"";
        }
        if (hMapDoctor.keySet().contains(code)) {
            return "Code already exists";
        }
        return null;
    }

    public static String checkNameValid(String name) {
        name = name.trim();
        if (name.length() == 0) {
            return "Name must not be empty";
        }
        return null;
    }

    public static String checkSpecializationValid(String specialization) {
        specialization = specialization.trim();
        if (specialization.length() == 0) {
            return "Specialization must not be empty";
        }
        return null;
    }

    public static String checkAvailabilityValid(String availability) {
        availability = availability.trim();
        if (availability.length() == 0) {
            return "Availability must not be empty";
        }
        if (!availability.matches("^-?[0-9]+$")) {
            return "Availability must be an integer";
        }
        if (availability.startsWith("-")) {
            return "Availability must be non-negative";
        }
        return null;
    }

    public static String checkAllValid(String code, String name, String specialization, String availability) {
        if (DoctorDatabase.checkCodeValid(code) != null) {
            return DoctorDatabase.checkCodeValid(code);
        }
        if (DoctorDatabase.checkNameValid(name) != null) {
            return DoctorDatabase.checkNameValid(name);
        }
        if (DoctorDatabase.checkSpecializationValid(specialization) != null) {
            return DoctorDatabase.checkSpecializationValid(specialization);
        }
        if (DoctorDatabase.checkAvailabilityValid(availability) != null) {
            return DoctorDatabase.checkAvailabilityValid(availability);
        }
        return null;
    }
}
