package org.example;
import org.example.Exceptions.*;
import org.example.Leagues.*;
import org.example.Teams.*;
import org.example.Staffers.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.example.Leagues.LambdaFunctions.findLeagueWithHighestId;
import static org.example.Staffers.LambdaFunctions.filterStaffByType;
import static org.example.Teams.LambdaFunctions.mapTeamNames;

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

        StaffMoves staffMoves = new StaffMoves(); //correct
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
        Staff staffer102 = new Worker(102, "Cashier");
        staffers.add(staffer);
        StaffMoves.hireStaff();
        Staff staffer2 = new Coach(2, "Mike Vrabel", 51);
        staffers.add(staffer2);
        StaffMoves.hireStaff();

        //Lambda Functions
        Optional<League> largestLeague = findLeagueWithHighestId(leagues);

        List<String> teamNames = mapTeamNames(teams);
        teamNames.forEach(System.out::println);

        List<Coach> coaches = filterStaffByType(staffers, Coach.class);
        coaches.forEach(System.out::println);

        //methods toString,hashCode and equals
        System.out.println(staffer2.toString());
        System.out.println(staffer.hashCode());
        System.out.println(staffer.equals(staffer102));//implement the method in Staffer class
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

        //Collection and Streaming
        teamNames = teams.stream()
                .map(Team::getName)
                .collect(Collectors.toList());
        System.out.println("Nomes dos times: " + teamNames);

        System.out.println("Jogadores ordenados por ID:");
        players.stream()
                .sorted(Comparator.comparingInt(Player::getNumber))
                .forEach(System.out::println);

        Optional<Team> firstNorthConferenceTeam = teams.stream()
                .filter(team -> team.getConference() == Conference.NORTH)
                .findFirst();
        firstNorthConferenceTeam.ifPresent(team -> System.out.println("Primeiro time do Norte: " + team.getName()));

        List<Team> southConferenceTeams = teams.stream()
                .filter(team -> team.getConference() == Conference.SOUTH)
                .toList();
        System.out.println("Times do Conference SOUTH: " + southConferenceTeams);

        Set<String> uniquePlayerCountries = players.stream()
                .map(Player::getNationality)
                .collect(Collectors.toSet());
        System.out.println("Países únicos dos jogadores: " + uniquePlayerCountries);

        Map<Class<? extends Staff>, List<Staff>> staffGroupedByType = staffers.stream()
                .collect(Collectors.groupingBy(Staff::getClass));
        staffGroupedByType.forEach((type, list) -> {
            System.out.println("Tipo de Staff: " + type.getSimpleName());
            list.forEach(System.out::println);
        });
        //

        //t
        //Try-catch use
        try {
            for (Staff i : staffers) {
                if (i.getId() == 19191) {
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
            File inputFile = new File("C:\\Users\\lucas\\IdeaProjects\\PracticeMaven\\src\\main\\java\\org\\example\\input.txt");
            File outputFile = new File("C:\\Users\\lucas\\IdeaProjects\\PracticeMaven\\src\\main\\java\\org\\example\\output.txt");

            String content = FileUtils.readFileToString(inputFile);
            if (!inputFile.exists()) {
                System.out.println("O arquivo input.txt não foi encontrado!");
            }

            Set<String> uniqueWords = new HashSet<>(Arrays.asList(StringUtils.split(content.toLowerCase(), " \t\n\r\f,.:;?![]'\"")));

            FileUtils.writeStringToFile(outputFile, "Unique word count: " + uniqueWords.size());
        }catch (IOException e){
            System.out.println("Read error.");
        }

        Class<?> clazz = Player.class;
        System.out.println("Fields");
        Field[] field = clazz.getDeclaredFields();
        for (Field campo : field) {
            int modifiers = campo.getModifiers();
            System.out.println("Modifier: " + Modifier.toString(modifiers) + ", field: " + campo.getName() + ", Type: " + campo.getType());
        }

        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName() + ", parameters: " + constructor.getParameterCount());
            Class<?>[] typesOfParameters = constructor.getParameterTypes();
            for (Class<?> type : typesOfParameters) {
                System.out.println("Type of parameter: " + type.getName());
            }
        }

        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method met : methods) {
            int modificadores = met.getModifiers();
            System.out.println("Modificador: " + Modifier.toString(modificadores) + ", Método: " + met.getName() + ", Tipo de retorno: " + met.getReturnType());
            Class<?>[] typesOfParameters = met.getParameterTypes();
            for (Class<?> type : typesOfParameters) {
                System.out.println("Tipo de parâmetro: " + type.getName());
            }
        }

        try{
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class,String.class,String.class);
            Object myObject = constructor.newInstance(11,"Brazillian","Forward");

            Method method = clazz.getDeclaredMethod("getNationality");
            method.invoke(myObject);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}