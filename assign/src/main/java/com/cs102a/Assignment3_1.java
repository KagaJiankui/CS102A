package com.cs102a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Assignment3_1 {
  static CurricuList curricuList = new CurricuList();
  static RoomList roomList = new RoomList();

  public static void prettyPrint() {
    System.out.println("Room List");
    System.out.println("Theory: " + roomList.theory);
    System.out.println("Lab: " + roomList.lab);
    System.out.println("Art: " + roomList.art);
    System.out.println("Curriculum List");
    System.out.println("Theory: " + curricuList.theory);
    System.out.println("Lab: " + curricuList.lab);
    System.out.println("Art: " + curricuList.art);
  }

  public static void testMatch() {
    System.out.println(matchRoom(roomList.theory, curricuList.theory));
    System.out.println(matchRoom(roomList.lab, curricuList.lab));
    System.out.println(matchRoom(roomList.art, curricuList.art));
  }

  public static Boolean matchAllRooms() {
    boolean flags[] = { false, false, false };
    flags[0] = matchRoom(roomList.theory, curricuList.theory);
    flags[1] = matchRoom(roomList.lab, curricuList.lab);
    flags[2] = matchRoom(roomList.art, curricuList.art);
    return flags[0] && flags[1] && flags[2];
  }

  public static Boolean matchRoom(ArrayList<Integer> R, ArrayList<Integer> C) {
    if (R.size()<C.size()) {
      return false;
    } else {
      Boolean flag=false;
      for (int i = 0; i < C.size(); i++) {
        flag = (R.get(i) - C.get(i) < 0);
        if (flag) {
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();
    String[] readedLine;
    scanner.nextLine();
    for (int i = 0; i < rows; i++) {
      readedLine = scanner.nextLine().split(",");
      String courseType = readedLine[1];
      String roomType = readedLine[0];
      switch (roomType) {
        case "R":
          switch (courseType) {
            case "theory":
              roomList.theory.add(Integer.parseInt(readedLine[2]));
              break;
            case "lab":
              roomList.lab.add(Integer.parseInt(readedLine[2]));
              break;
            case "art":
              roomList.art.add(Integer.parseInt(readedLine[2]));
              break;
            default:
              break;
          }
          break;
        case "C":
          switch (courseType) {
            case "theory":
              curricuList.theory.add(Integer.parseInt(readedLine[2]));
              break;
            case "lab":
              curricuList.lab.add(Integer.parseInt(readedLine[2]));
              break;
            case "art":
              curricuList.art.add(Integer.parseInt(readedLine[2]));
              break;
            default:
              break;
          }
          break;
        default:
          break;
      }
    }
    scanner.close();
    roomList.theory.sort(Comparator.reverseOrder());
    roomList.lab.sort(Comparator.reverseOrder());
    roomList.art.sort(Comparator.reverseOrder());
    curricuList.theory.sort(Comparator.reverseOrder());
    curricuList.lab.sort(Comparator.reverseOrder());
    curricuList.art.sort(Comparator.reverseOrder());
    Boolean flag_match = matchAllRooms();
    if (flag_match) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

class CurricuList {
  ArrayList<Integer> theory = new ArrayList<>();
  ArrayList<Integer> lab = new ArrayList<>();
  ArrayList<Integer> art = new ArrayList<>();
}
class RoomList {
  ArrayList<Integer> theory = new ArrayList<>();
  ArrayList<Integer> lab = new ArrayList<>();
  ArrayList<Integer> art = new ArrayList<>();
}