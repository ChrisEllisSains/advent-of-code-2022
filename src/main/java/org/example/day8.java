package org.example;

public class day8 {

  private static int[][] tree;
  private static int width;
  private static int height;

  public static void main(String[] args) throws java.io.IOException {

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday8"));

    String[] input = str.split("\\n");

    width = input[0].length();
    height = input.length;

    tree = new int[width][height];

    int total = width*2 + height*2 - 4;

    for(int i = 0; i < width; i++) {
      for(int j = 0; j < height; j++) {
        tree[i][j] = input[i].charAt(j) - '0';
      }
    }

    for(int i = 1; i < width - 1; i++) {
      for(int j = 1; j < height - 1; j++) {
        if(isVisible(i,j)) {
          total += 1;
        }
      }
    }

    int maxScore = 0;
    for(int i = 0; i < width; i++) {
      for(int j = 0; j < height -1; j++) {
        if(calScore(i,j) > maxScore) {
          maxScore = calScore(i,j);
        }
      }
    }

    System.out.println("Part 1: " + total);
    System.out.println("Part 2: " + maxScore);
  }

  private static int calScore(int i, int j) {
    int top = 0;
    int bottom = 0;
    int left = 0;
    int right = 0;

    if(i == 0) {
      left = 1;
    } else {
      for(int k = i-1; k >= 0; k--) {
        left += 1;
        if(tree[k][j] >= tree[i][j]) {
          break;
        }
      }
    }

    if(i == 99) {
      right = 1;
    } else {
      for(int k = i+1; k < width; k++) {
        right += 1;
        if(tree[k][j] >= tree[i][j]) {
          break;
        }
      }
    }

    if(j == 0) {
      top = 1;
    } else {
      for(int k = j-1; k >= 0; k--) {
        top += 1;
        if(tree[i][k] >= tree[i][j]) {
          break;
        }
      }
    }

    if(j == 99) {
      bottom = 1;
    } else {
      for(int k = j+1; k < height; k++) {
        bottom += 1;
        if(tree[i][k] >= tree[i][j]) {
          break;
        }
      }
    }

    return top * bottom * left * right;
  }

  private static boolean isVisible(int i, int j) {
    boolean left = true;
    boolean right = true;
    boolean top = true;
    boolean bottom = true;

    for(int k = 0; k < i; k++) {
      if(tree[k][j] >= tree[i][j]) {
        left = false;
      }
    }
    for(int k = i+1; k < width; k++) {
      if(tree[k][j] >= tree[i][j]) {
        right = false;
      }
    }

    for(int k = 0; k < j; k++) {
      if(tree[i][k] >= tree[i][j]) {
        top = false;
      }
    }
    for(int k = j+1; k < height; k++) {
      if(tree[i][k] >= tree[i][j]) {
        bottom = false;
      }
    }
    return top || bottom || left || right;
  }

}
