package managecandidate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {

    ArrayList<Candidate> candidates = new ArrayList<>();
    ArrayList<Experience> experience = new ArrayList<>();
    ArrayList<Fresher> fresher = new ArrayList<>();
    ArrayList<Internship> internship = new ArrayList<>();

    Validate validate = new Validate();

    public void createCandidate(int type) {
        while (true) {
            String id;
            while (true) {
                id = validate.inputString("Enter your id: ", "[A-Za-z0-9\\s]+");
                if (validate.checkIdExist(candidates, id)) {
                    break;
                } else {
                    System.out.println("ID is exist");
                }
            }
            String firstName = validate.inputString("Enter first name: ", "[A-Za-z\\s]+");
            String lastName = validate.inputString("Enter last name: ", "[A-Za-z\\s]+");
            String birthDate = validate.inputDate("Enter birthDate: ");
            String address = validate.inputString("Enter address: ", ".+");
            String phone = validate.inputString("Enter phone: ", "(0[3|5|7|8|9])+([0-9]{8})");
            String email = validate.inputString("Enter email: ", "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$");
            switch (type) {
                case 0:
                    int yearExperience = validate.inputInt("Enter year of experience: ", 0, 100);
                    String professionalSkill = validate.inputString("Enter professional Skill: ", ".+");
                    experience.add(new Experience(yearExperience, professionalSkill, id, firstName, lastName, birthDate, address, phone, email, type));
                    Collections.sort(experience, Comparator.comparing(Experience::getYearExperience));
                    candidates.add(new Experience(yearExperience, professionalSkill, id, firstName, lastName, birthDate, address, phone, email, type));
                    break;
                case 1:
                    String graduationDate = validate.inputDate("Enter graduation date:");
                    System.out.print("Enter graduation rank: ");
                    String graduationRank = validate.checkInputGraduationRank();
                    fresher.add(new Fresher(graduationDate, graduationRank, id, firstName, lastName, birthDate, address, phone, email, type));
                    Collections.sort(fresher, Comparator.comparing(Fresher::getGraduationRank));
                    candidates.add(new Fresher(graduationDate, graduationRank, id, firstName, lastName, birthDate, address, phone, email, type));
                    break;
                case 2:
                    String major = validate.inputString("Enter major: ", ".+");
                    String semester = validate.inputString("Enter semester: ", ".+");
                    String university = validate.inputString("Enter university: ", ".+");
                    internship.add(new Internship(major, semester, university, id, firstName, lastName, birthDate, address, phone, email, type));
                    Collections.sort(internship, Comparator.comparing(Internship::getMajor));
                    candidates.add(new Internship(major, semester, university, id, firstName, lastName, birthDate, address, phone, email, type));
                    break;
            }
            System.out.println("Do you want to continue:");
            if (!validate.checkInputYN()) {
                return;
            }
        }
    }

    public void printlistsearchCandidate() {

        System.out.println("=====Experience Candidate (0)=====");
        for (Experience candidate : experience) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName() + " " + ((Experience) candidate).getYearExperience());
        }

        System.out.println("=====Fresher Candidate (1)=====");
        for (Fresher candidate : fresher) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName() + " " + ((Fresher) candidate).getGraduationRank());
        }

        System.out.println("=====Internship Candidate (2)=====");
        for (Internship candidate : internship) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName() + " " + ((Internship) candidate).getMajor());

        }
    }

    public void searchCandidate() {
        printlistsearchCandidate();
        String nameSearch = validate.inputString("Enter candidate name (First Name or Last Name):", ".+");
        int typeCandidate = validate.inputInt("Enter type of candidate (0 for Experience, 1 for Fresher, 2 for Internship): ", 0, 2);
        int count = 0;
        if (typeCandidate == 0) {
            for (Experience candidate : experience) {
                if (candidate.getTypeCandidate() == typeCandidate
                        && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                    System.out.println(candidate.toString());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not found");
            }
        }
        if (typeCandidate == 1) {
            for (Fresher candidate : fresher) {
                if (candidate.getTypeCandidate() == typeCandidate
                        && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                    System.out.println(candidate.toString());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not found");
            }
        }
        if (typeCandidate == 2) {
            for (Internship candidate : internship) {
                if (candidate.getTypeCandidate() == typeCandidate
                        && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                    System.out.println(candidate.toString());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not found");
            }
        }
    }

}
