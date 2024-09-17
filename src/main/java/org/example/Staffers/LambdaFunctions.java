package org.example.Staffers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class LambdaFunctions {
    public static <T extends Staff> List<T> filterStaffByType(List<Staff> staffList, Class<T> type) {
        Predicate<Staff> isOfType = staff -> type.isInstance(staff);
        return staffList.stream()
                .filter(isOfType)
                .map(type::cast)
                .collect(Collectors.toList());
    }
}
