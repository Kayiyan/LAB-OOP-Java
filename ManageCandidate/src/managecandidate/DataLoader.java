package managecandidate;

import java.util.Comparator;


public class DataLoader {

    public static void loadSampleData(Manager manager) {

        // Load 2 Experience candidates
        Experience experience1 = new Experience(3, "Java Programming", "EXP001", "John", "Doe", "01/01/1990", "123 Main St", "1234567890", "john@example.com", 0);
        Experience experience2 = new Experience(5, "Database Management", "EXP002", "Alice", "Smith", "02/02/1995", "456 Elm St", "9876543210", "alice@example.com", 0);
        manager.experience.add(experience1);
        manager.experience.add(experience2);
        manager.experience.sort(Comparator.comparing(Experience::getYearExperience));

        // Load 2 Fresher candidates
        Fresher fresher1 = new Fresher("05/05/2022", "Excellence", "FR001", "Bob", "Johnson", "03/03/2000", "789 Oak St", "5551234567", "bob@example.com", 1);
        Fresher fresher2 = new Fresher("06/06/2022", "Good", "FR002", "Eve", "Brown", "04/04/2005", "101 Pine St", "9998887777", "eve@example.com", 1);
        manager.fresher.add(fresher1);
        manager.fresher.add(fresher2);
        manager.fresher.sort(Comparator.comparing(Fresher::getGraduationRank));

        // Load 2 Internship candidates
        Internship internship1 = new Internship("Web Development", "Summer 2021", "XYZ University", "INT001", "Mike", "Wilson", "05/05/1998", "222 Maple St", "4443332222", "mike@example.com", 2);
        Internship internship2 = new Internship("Data Analysis", "Spring 2021", "ABC College", "INT002", "Sara", "Lee", "06/06/1996", "333 Cedar St", "7776665555", "sara@example.com", 2);
        manager.internship.add(internship1);
        manager.internship.add(internship2);
        manager.internship.sort(Comparator.comparing(Internship::getMajor));
    }
}

