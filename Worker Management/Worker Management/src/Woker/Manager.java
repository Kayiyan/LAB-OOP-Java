package Woker;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.Comparator;

public class Manager {
    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<History> history = new ArrayList<>();

    ArrayList<History> historySalary = new ArrayList<>();

    Validate validate = new Validate();


    public Worker getWorkerByCode(String id){
        for(Worker worker : workers){
            if(id.equalsIgnoreCase(worker.getId())){
                return worker;
            }
        }
        return null;
    }

    public History getHistoryByCode(String id){
        for(History history1 : history){
            if(id.equalsIgnoreCase(history1.getId())){
                return history1;
            }
        }
        return null;
    }

    public void addWorker(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());
        String id;
        String workingDay ;
        while(true) {
            id = validate.inputString("Enter id: ");
            Worker worker = getWorkerByCode(id);
            if (worker == null) {
                break;
            }
            else{
                System.err.println("This id is exist");
            }
        }

        String name = validate.inputString("Enter name: ");
        int age = validate.age_Range("Enter age: ",18,50);
        double salary = validate.input_Salary("Enter salary: ",1,Double.MAX_VALUE);
        String workLocation = validate.inputString("Enter location: ");

        Date startDate;
        while (true) {
            String startDateString = validate.inputString("Enter start date (dd/MM/yyyy): ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                startDate = sdf.parse(startDateString);

                long timeDifferentMillseconds = calendar.getTimeInMillis() - startDate.getTime();
                long timeDifferentDays = TimeUnit.DAYS.convert(timeDifferentMillseconds,TimeUnit.MILLISECONDS);
                long years = timeDifferentDays / 365;
                long remainingDays = timeDifferentDays % 365;
                long weeks = remainingDays / 7;
                long months = weeks / 4;
                long remainingweeks = weeks % 4;
                long days = remainingDays % 7;

                workingDay = years +" year " + months+" months "+remainingweeks+" weeks "+days+" days ";
                System.out.println(workingDay);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
            }
        }


        workers.add(new Worker(id,name,age,salary,workLocation, workingDay));
        history.add(new History(id,name,age,salary,workLocation,workingDay,"UP",date));
    }

    public void changeSalary(String status){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());
        while(true) {
        String id = validate.inputString("Enter id: ");

            Worker worker = getWorkerByCode(id);
            if (worker == null) {
                System.out.println("Worker not exist");
            } else {
                if (worker.getSalary() == 1 && status.equals("DOWN")) {
                    System.out.print("Can not down this worker salary anymore");
                } else if (worker.getSalary() == Double.MAX_VALUE && status.equals("UP")) {
                    System.out.println("Can not up this worker salary anymore");
                } else {
                    double salaryCurrent = worker.getSalary();
                    double salaryUpdate;
                    while (true) {
                        double salary = validate.input_Salary("Enter salary: ", 1, Double.MAX_VALUE);
                        if (status.equals("UP")) {
                            salaryUpdate = salary + salaryCurrent;
                            break;
                        } else {
                            if (salary > salaryCurrent) {
                                System.out.print("You Should input smaller than current salary " + "(" + salaryCurrent + ")");
                            } else {
                                salaryUpdate = salaryCurrent - salary;
                                break;
                            }
                        }
                    }

                    history.add(new History( worker.getId(), worker.getName(),
                            worker.getAge(), salaryUpdate, worker.getWorkLocation(), worker.getWorkingDay(), status, date));

                    worker.setSalary(salaryUpdate);

                }
            }
            break;
        }

    }

    public void printHistory(){
        if(history.isEmpty()){
            System.out.print("No history ");

        }

        System.out.printf("%-10s%-15s%-5s%-10s%-10s%-20s%-20s\n","Code","Name","Age","Salary","Status","Date","WorkingDay");
        Collections.sort(history,Comparator.comparing(History::getWorkingDay).reversed());
        for(History history :history){
            System.out.printf("%-10s%-15s%-5d%-10.0f%-10s%-20s%-20s\n",history.getId(),history.getName(),
                    history.getAge(),history.getSalary(),history.getStatus(),history.getDate(),history.getWorkingDay());
        }

    }

    public void printStatus(){
        String id;
        while (true){
            id = validate.inputString("Enter ID:");
            History history1 = getHistoryByCode(id);
            if (history1 == null){
                break;
            }else {
                System.out.println(history1.getStatus());
            }
        }
    }


}
