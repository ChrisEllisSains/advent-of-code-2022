package org.example;

public class day9 {

  private static java.util.ArrayList<Position> visited1 = new java.util.ArrayList<>();
  private static java.util.ArrayList<Position> visited2 = new java.util.ArrayList<>();

  public static void main(String[] args) throws java.io.IOException {

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday9"));

    String[] input = str.split("\\n");


    Position[] rope = new org.example.Position[10];
    for(int i = 0; i < 10; i++) {
      rope[i] = new Position(0,0);
    }

    Position head = new org.example.Position(0,0);
    Position tail = new org.example.Position(0,0);
    visited1.add(new org.example.Position(0,0));
    visited2.add(new Position(0,0));
/*
    for(String s: input) {
      String direction = s.substring(0,1);
      Integer distance = Integer.parseInt(s.split(" ")[1]);
      processMove(direction, distance, head, tail);
    }
    System.out.println(visited1.size());
*/
    for(String s: input) {
      String direction = s.substring(0,1);
      Integer distance = Integer.parseInt(s.split(" ")[1]);
      processMove2(direction, distance, rope);
    }
    System.out.println(visited2.size());

  }

  private static void processMove(String direction, Integer distance, Position head, Position tail) {

    switch(direction) {
      case "U":
        moveUp(distance, head, tail);
        break;
      case "D":
        moveDown(distance, head, tail);
        break;
      case "L":
        moveLeft(distance, head, tail);
        break;
      case "R":
        moveRight(distance, head, tail);
        break;
    }
  }

  private static void processMove2(String direction, Integer distance, Position[] rope) {

    switch(direction) {
      case "U":
        moveUp(distance, rope);
        break;
      case "D":
        moveDown(distance, rope);
        break;
      case "L":
        moveLeft(distance, rope);
        break;
      case "R":
        moveRight(distance, rope);
        break;
    }
  }

  private static void moveUp(Integer distance, Position head, org.example.Position tail) {
    for(int i = 0; i < distance; i++) {
      head.y += 1;
      checkTail(head, tail);
    }
  }

  private static void moveDown(Integer distance, Position head, org.example.Position tail) {
    for(int i = 0; i < distance; i++) {
      head.y -= 1;
      checkTail(head, tail);
    }
  }

  private static void moveLeft(Integer distance, Position head, org.example.Position tail) {
    for(int i = 0; i < distance; i++) {
      head.x -= 1;
      checkTail(head, tail);
    }
  }

  private static void moveRight(Integer distance, Position head, org.example.Position tail) {
    for(int i = 0; i < distance; i++) {
      head.x += 1;
      checkTail(head, tail);
    }
  }

  private static void moveRight(Integer distance, Position[] rope) {
    for(int i = 0; i < distance; i++) {
      rope[0].x += 1;
      for(int j = 0; j < rope.length-2; j++) {
        checkRope(rope[j], rope[j+1]);
      }
      checkRopeTail(rope[8], rope[9]);
    }
  }

  private static void moveUp(Integer distance, Position[] rope) {
    for(int i = 0; i < distance; i++) {
      rope[0].y += 1;
      for(int j = 0; j < rope.length-2; j++) {
        checkRope(rope[j], rope[j+1]);
      }
      checkRopeTail(rope[8], rope[9]);
    }
  }

  private static void moveDown(Integer distance,Position[] rope) {
    for(int i = 0; i < distance; i++) {
      rope[0].y -= 1;
      for(int j = 0; j < rope.length-2; j++) {
        checkRope(rope[j], rope[j+1]);
      }
      checkRopeTail(rope[8], rope[9]);
    }
  }

  private static void moveLeft(Integer distance, Position[] rope) {
    for(int i = 0; i < distance; i++) {
      rope[0].x -= 1;
      for(int j = 0; j < rope.length-2; j++) {
        checkRope(rope[j], rope[j+1]);
      }
      checkRopeTail(rope[8], rope[9]);
    }
  }

  private static void checkTail(Position head, org.example.Position tail) {
    if(!isAdjacent(head, tail)) {
      moveTail(head, tail);
    }
  }
  private static void checkRope(Position head, org.example.Position tail) {
    if(!isAdjacent(head, tail)) {
      moveRope(head, tail);
    }
  }

  private static void checkRopeTail(Position head, org.example.Position tail) {
    if(!isAdjacent(head, tail)) {
      moveRopeTail(head, tail);
    }
  }

  private static void moveTail(Position head, org.example.Position tail) {

    if(head.x > tail.x) {
      tail.x += 1;
    } else if(head.x < tail.x) {
      tail.x -= 1;
    }
    if(head.y > tail.y) {
      tail.y += 1;
    } else if(head.y < tail.y) {
      tail.y -= 1;
    }
    if(!visited1.contains(tail)) {
      visited1.add(new Position(tail.x, tail.y));
    }
  }

  private static void moveRopeTail(Position head, org.example.Position tail) {

    if(head.x > tail.x) {
      tail.x += 1;
    } else if(head.x < tail.x) {
      tail.x -= 1;
    }
    if(head.y > tail.y) {
      tail.y += 1;
    } else if(head.y < tail.y) {
      tail.y -= 1;
    }
    if(!visited2.contains(tail)) {
      visited2.add(new Position(tail.x, tail.y));
    }
  }

  private static void moveRope(Position head, org.example.Position tail) {

    if(head.x > tail.x) {
      tail.x += 1;
    } else if(head.x < tail.x) {
      tail.x -= 1;
    }
    if(head.y > tail.y) {
      tail.y += 1;
    } else if(head.y < tail.y) {
      tail.y -= 1;
    }
  }

  private static boolean isAdjacent(Position head, org.example.Position tail) {
    if((head.x - tail.x <= 1 && head.x - tail.x >= -1) && (head.y - tail.y <= 1 && head.y - tail.y >= -1)) {
      return true;
    } else {
      return false;
    }
  }

}

 class Position {
  public int x;
  public int y;

  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
   public boolean equals(Object o) {
    final Position other = (Position) o;
    if(this.x == other.x && this.y == other.y) {
      return true;
    } else {
      return false;
    }
  }
}


