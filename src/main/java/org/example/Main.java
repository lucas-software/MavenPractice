package org.example;
import org.example.Exceptions.*;
import org.example.Leagues.*;
import org.example.Teams.*;
import org.example.Staffers.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Nba nba = new Nba(1, "Basketball", 32);
        Nfl nfl = new Nfl(2, "Football");
        NbaTeam nbaTeam = new NbaTeam("Brazillian Angels", Conference.NORTH, 1);
        NflTeam nflTeam = new NflTeam("Brazillian Devils", Conference.SOUTH, 2);
        Player Neymar = new Player(11, "Brazil", "Forward");
        ArrayList<League> leagues = new ArrayList<>();
        leagues.add(nba);
        leagues.add(nfl);
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(nbaTeam);
        teams.add(nflTeam);
        ArrayList<Player> players = new ArrayList<>();
        players.add(Neymar);
        ArrayList<Staff> staffers = new ArrayList<>();
        Coach headCoach = new Coach(1, "Bill Belichick", 72);
        staffers.add(headCoach);
        StaffMoves StaffMoves = new StaffMoves();
        StaffMoves.hireStaff();
        Coordinator coordinator = new Coordinator(2, "Defensive coordinator", "Jerod Mayo", 38);
        staffers.add(coordinator);
        StaffMoves.hireStaff();
        Worker worker = new Worker(100, "Cleaning");
        staffers.add(worker);
        StaffMoves.hireStaff();
        //polymorfism with the abstract class Staff
        Staff staffer = new Worker(101, "Cashier");
        staffers.add(staffer);
        StaffMoves.hireStaff();
        Staff staffer2 = new Coach(2, "Mike Vrabel", 51);
        staffers.add(staffer2);
        StaffMoves.hireStaff();
        //methods toString,hashCode and equals
        System.out.println(staffer2.toString());
        System.out.println(staffer.hashCode());
        System.out.println(staffer2.equals(staffer));
        headCoach.submitReport();
        headCoach.attendTraining();
        headCoach.takeBreak();
        headCoach.getPromotion();
        headCoach.work();
        headCoach.enrollInsurance();
        headCoach.receiveSalary();
        Intern intern = new Intern(6, 120);
        intern.work();
        intern.attendTraining();
        intern.receiveSalary();
        intern.displayInternshipDuration();
        intern.takeBreak();

        //Try-catch use
        try {
            for (Staff i : staffers) {
                if (coordinator.getId() == 19191) {
                    System.out.println("Exists");
                } else {
                    throw new StaffNotFoundException("Id not found");
                }
            }
        } catch (StaffNotFoundException e) {
            System.out.println("Staffer not found: " + e.getMessage());

            try {
                for (Staff i : staffers) {
                    if (coordinator.getId() == 19191) {
                        System.out.println("Exists");
                    } else {
                        throw new StaffRemovalException("Could not remove the Staffer");
                    }
                }
            } catch (StaffRemovalException r) {
                System.out.println("Error removing staffer: " + e.getMessage());
            }

        }

        try{
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            String content = FileUtils.readFileToString(inputFile);
            if (!inputFile.exists()) {
                System.out.println("O arquivo input.txt não foi encontrado!");
            }

            Set<String> uniqueWords = new HashSet<>(Arrays.asList(StringUtils.split(content.toLowerCase(), " \t\n\r\f,.:;?![]'\"")));

            FileUtils.writeStringToFile(outputFile, "Unique word count: " + uniqueWords.size());
        }catch (IOException e){
            System.out.println("Read error.");
        }
    }
}