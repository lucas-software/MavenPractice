package org.example.Leagues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LambdaFunctions {
    public static <T extends League> Optional<T> findLeagueWithHighestId(List<T> leagues) {
        return leagues.stream()
                .reduce((league1, league2) ->
                        league1.getId() > league2.getId() ? league1 : league2);
    }
}