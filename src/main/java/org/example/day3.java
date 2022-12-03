package org.example;

public class day3 {

  private static java.util.Hashtable pValue = new java.util.Hashtable();

  public static void main(String[] args) throws java.io.IOException {
    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday3"));
    String rucksack[] = str.split("\\n");
    int sumPriorities = 0;

    for (int i = 0; i < rucksack.length; i++) {
      String  tmp1 = rucksack[i].substring(0, rucksack[i].length() / 2);
      String tmp2 = rucksack[i].substring(rucksack[i].length() / 2);

      String c1 = java.util.Arrays.asList(tmp1.split("")).stream().distinct().collect(java.util.stream.Collectors.joining());
      String c2 = java.util.Arrays.asList(tmp2.split("")).stream().distinct().collect(java.util.stream.Collectors.joining());

      for (int j = 0; j < c1.length(); j++) {
        if(c2.indexOf(c1.charAt(j)) != -1) {
          sumPriorities += calculatePriority(c1.charAt(j));
        }
      }
    }
    System.out.println("Part 1: " + sumPriorities);
    int score2 = 0;

    for(int i = 0; i < rucksack.length; i+=3) {
      score2 += calculatePriority(findBadge(rucksack[i] ,rucksack[i+1],rucksack[i+2]));
    }
    System.out.println("Part 2: " + score2);
  }
  private static int calculatePriority(char c) {
    int result = c >= 97 ? c - 96 : c - 38;
    return result;
  }

  private static char findBadge(String bag1, String bag2, String bag3) {
    for(char current : bag1.toCharArray()) {
      if(bag2.indexOf(current) != -1 && (bag3.indexOf(current) != -1)) {
        return current;
      }
    }
    return 0;
  }
}

