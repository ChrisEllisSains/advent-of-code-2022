package org.example;

public class day5 {

  private static final java.util.ArrayList<java.util.Deque<Character>> stack = new java.util.ArrayList<>();

  public static void main(String[] args) throws java.io.IOException {

    initialise();

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday5"));

    String[] instructions = str.split("\\n");

    //part1(instructions);
    part2(instructions);
  }

  private static void part1(String[] instructions) {
    for (int i = 10; i < instructions.length; i++) {
      instructions[i] = instructions[i].replaceAll("[^[0-9]]", " ").trim().replaceAll(" +", " ");
      //System.out.println("Line: " + i + " = " + instructions[i]);
      String[] commands = instructions[i].split(" ");
      int numberOfMoves = Integer.parseInt(commands[0]);
      int from = Integer.parseInt(commands[1]) - 1;
      int to = Integer.parseInt(commands[2]) - 1;

      for (int j = 0; j < numberOfMoves; j++) {
        stack.get(to).add(stack.get(from).removeLast());
      }
    }

    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i).getLast());
    }
  }

  private static void part2(String[] instructions) {
    for (int i = 10; i < instructions.length; i++) {
      instructions[i] = instructions[i].replaceAll("[^[0-9]]", " ").trim().replaceAll(" +", " ");
      String[] commands = instructions[i].split(" ");
      int numberOfMoves = Integer.parseInt(commands[0]);
      int from = Integer.parseInt(commands[1]) - 1;
      int to = Integer.parseInt(commands[2]) - 1;
      java.util.Deque<Character> temp = new java.util.ArrayDeque();
      for (int j = 0; j < numberOfMoves; j++) {

        temp.add(stack.get(from).removeLast());
      }

      for(int k = 0; k < numberOfMoves; k++) {
        stack.get(to).add(temp.removeLast());
      }
    }

    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i).getLast());
    }
  }

  private static void initialise() throws java.io.IOException {

    for (int i = 0; i < 9; i++) {
      stack.add(new java.util.ArrayDeque<>());
    }
    stack.get(0).add('B');
    stack.get(0).add('Z');
    stack.get(0).add('T');

    stack.get(1).add('V');
    stack.get(1).add('H');
    stack.get(1).add('T');
    stack.get(1).add('D');
    stack.get(1).add('N');

    stack.get(2).add('B');
    stack.get(2).add('F');
    stack.get(2).add('M');
    stack.get(2).add('D');

    stack.get(3).add('T');
    stack.get(3).add('J');
    stack.get(3).add('G');
    stack.get(3).add('W');
    stack.get(3).add('V');
    stack.get(3).add('Q');
    stack.get(3).add('L');

    stack.get(4).add('W');
    stack.get(4).add('D');
    stack.get(4).add('G');
    stack.get(4).add('P');
    stack.get(4).add('V');
    stack.get(4).add('F');
    stack.get(4).add('Q');
    stack.get(4).add('M');

    stack.get(5).add('V');
    stack.get(5).add('Z');
    stack.get(5).add('Q');
    stack.get(5).add('G');
    stack.get(5).add('H');
    stack.get(5).add('F');
    stack.get(5).add('S');

    stack.get(6).add('Z');
    stack.get(6).add('S');
    stack.get(6).add('N');
    stack.get(6).add('R');
    stack.get(6).add('L');
    stack.get(6).add('T');
    stack.get(6).add('C');
    stack.get(6).add('W');

    stack.get(7).add('Z');
    stack.get(7).add('H');
    stack.get(7).add('W');
    stack.get(7).add('D');
    stack.get(7).add('J');
    stack.get(7).add('N');
    stack.get(7).add('R');
    stack.get(7).add('M');

    stack.get(8).add('M');
    stack.get(8).add('Q');
    stack.get(8).add('L');
    stack.get(8).add('F');
    stack.get(8).add('D');
    stack.get(8).add('S');
  }

}
