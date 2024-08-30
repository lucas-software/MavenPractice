package org.example.Staffers;

public class StaffMoves {
    // Static Variable
    private static int totalStaffHired = 0;

    // Static Block
    static {
        System.out.println("Staff is taking shape.");
    }

    // Static Method
    public static void hireStaff() {
        totalStaffHired++;
        System.out.println("Staff hired. Total staff: " + totalStaffHired);
    }
}
