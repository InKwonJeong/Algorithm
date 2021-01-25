package baekjoon.implementation;

import java.util.Scanner;

public class RoadToErrands {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int homeToSchool = input.nextInt();
        int schoolToPcRoom = input.nextInt();
        int pcRoomToAcademy = input.nextInt();
        int academyToHome = input.nextInt();

        int total = homeToSchool + schoolToPcRoom + pcRoomToAcademy + academyToHome;
        System.out.println(total / 60);
        System.out.println(total % 60);
    }
}
