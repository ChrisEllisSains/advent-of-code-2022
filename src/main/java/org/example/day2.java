package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class day2 {

  public static void main(String[] args) throws IOException {
    String str = Files.readString(Paths.get("src/main/resources/rps"));
    String rounds[] = str.split("\\n");

    int totalScore = 0;

    for(int i = 0; i < rounds.length; i++) {
      totalScore += calcScore(rounds[i]);
    }
    System.out.println(totalScore);

  }

  private static int calcScore(String round) {
    char opponent = round.charAt(0);
    char me = round.charAt(2);

    switch (opponent) {
      case 'A':
        return rockVs(me);
      case 'B':
        return paperVs(me);
      case 'C':
        return scissorsVs(me);
    }
    return 0;
  }

  private static int rockVs(char me) {
    int score = 0;
    switch(me) {
      case 'X':
        return 3;
      case 'Y':
        return 4;
      case 'Z':
        return 8;
    }
    return score;
  }

  private static int scissorsVs(char me) {
    int score = 0;
    switch(me) {
      case 'X':
        return 2;
      case 'Y':
        return 6;
      case 'Z':
        return 7;
    }
    return score;
  }

  private static int paperVs(char me) {
    int score = 0;
    switch(me) {
      case 'X':
        return 1;
      case 'Y':
        return 5;
      case 'Z':
        return 9;
    }
    return score;
  }



}
