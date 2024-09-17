package org.example.Teams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaFunctions {
    public static <T extends Team> List<String> mapTeamNames(List<T> teams) {
        Function<T, String> getName = Team::getName;
        return teams.stream().map(getName).collect(Collectors.toList());
    }
}
