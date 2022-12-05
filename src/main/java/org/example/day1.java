package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1 {

  public static void main(String[] args) throws IOException {

    String str = Files.readString(Paths.get("src/main/resources/ElveFood"));
    String[] Elves = str.split("\\n\\n");
    int cal1 = 0, cal2 = 0, cal3 = 0;
    ArrayList<Integer> cals = new ArrayList<>();

    for(int i = 0; i < Elves.length; i++) {
      String[] calories = Elves[i].split("\\n");
      int elvecalories = 0;
      for(int j = 0; j < calories.length; j++) {
        elvecalories += Integer.parseInt(calories[j]);
      }
      cals.add(elvecalories);
    }
    Collections.sort(cals);
    List<Integer> top3 = new ArrayList<Integer>(cals.subList(cals.size() -3, cals.size()));
    Integer total = top3.get(0) + top3.get(1) + top3.get(2);
    System.out.println(total);
  }
}