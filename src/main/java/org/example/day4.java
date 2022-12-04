package org.example;

public class day4 {

  public static void main(String[] args) throws java.io.IOException {
    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday4"));

    String pair[] = str.split("\\n");

    int count1 = 0;
    int count2 = 0;

    for(int i = 0; i < pair.length; i++) {
      String elves[] = pair[i].split(",");
      String value1[] = elves[0].split("-");
      String value2[] = elves[1].split("-");

      int e1min = Integer.parseInt(value1[0]);
      int e1max = Integer.parseInt(value1[1]);

      int e2min = Integer.parseInt(value2[0]);
      int e2max = Integer.parseInt(value2[1]);

      if((e1min <= e2min && e1max >= e2max) || (e2min <= e1min && e2max >= e1max)) {
        count1 += 1;
      }

      if( inRange(e1min, e1max, e2min) || inRange(e1min, e1max, e2max) || inRange(e2min, e2max, e1min) || inRange(e2min, e2max, e1max)) {
        count2 += 1;
      }
    }

    System.out.println("Count 1: " + count1);
    System.out.println("Count 2: " + count2);

  }

  private static boolean inRange(int min, int max, int num) {
    if(num >= min && num <= max) {
      return true;
    } else {
      return false;
    }
  }

}
