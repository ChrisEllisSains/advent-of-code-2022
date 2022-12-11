package org.example;

public class day10 {

  private static int x = 1;
  private static int cycle = 0;
  private static int sum = 0;
  private static int pixel = 0;
  private static char[] output = new char[240];
  private static char sprite = '#';

  public static void main(String[] args) throws java.io.IOException {

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday10"));

    String[] input = str.split("\\n");

    cycle = 1;
    x = 1;
    sum = 0;

    for(String s: input) {
      if(s.equals("noop")) {
        print();
        cycle += 1;
      } else if(s.startsWith("addx")) {
        print();
        cycle += 1;
        print();
        cycle += 1;
        x += Integer.parseInt(s.split(" ")[1]);

      }
    }

    System.out.println(sum);

    image();

  }

  private static void print() {
    draw();
    if((cycle + 20) % 40 == 0) {
      System.out.println("Cycle " + cycle + ": " + x);
      sum += cycle * x;
    }
  }

  private static void draw() {
    if(shouldDrawSprite()) {
      output[pixel] = sprite;
    } else {
      output[pixel] = '.';
    }
    pixel += 1;
  }

  private static boolean shouldDrawSprite() {
    int row = getPosition(cycle);
    if(x-1 == row-1 || x == row-1 || x+1 == row-1) {
      return true;
    } else {
      return false;
    }
  }

  private static int getPosition(int tmp) {
    int i = tmp;
    while(i > 40) {
      i = i - 40;
    }
    return i;
  }
  private static void image() {
    drawLine(0, 39);
    drawLine(40, 79);
    drawLine(80, 119);
    drawLine(120, 159);
    drawLine(160, 199);
    drawLine(200, 239);
  }

  private static void drawLine(int start, int finish) {
    for(int i = start; i <= finish; i++) {
      System.out.print(output[i]);
    }
    System.out.println();
  }

}
