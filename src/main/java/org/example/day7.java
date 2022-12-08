package org.example;

public class day7 {
  private static String[] command;
  private static Directory currentDir;

  private static Boolean buildingDir;

  private static Directory topDir;
  private static java.util.List<Directory> directories = new java.util.ArrayList<org.example.Directory>();

  public static void main(String[] args) throws java.io.IOException {
    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday7"));

    command = str.split("\\n");


    for(String c: command) {
      if(c.startsWith("$ cd")) {
        changeDir(c);
      } else if(c.startsWith("$ ls")) {

      } else if(c.startsWith("dir")) {
        Directory temp = new org.example.Directory(c.substring(4), currentDir);
        currentDir.subDirs.add(temp);
        directories.add(temp);
      } else {
        currentDir.files.add(Integer.parseInt(c.split(" ")[0]));
      }
    }

    part1();
    part2();

  }

  private static void changeDir(String s) {
    String dir = s.substring(5);
    //System.out.println("opening directory: " + dir);
    if(dir.equals("/")) {
      currentDir = new org.example.Directory(dir, null);
      directories.add(currentDir);
      topDir = currentDir;
    } else if(dir.equals("..")) {
      currentDir = currentDir.parent;
    } else {
      currentDir = currentDir.subDirs.get(currentDir.subDirs.indexOf(new org.example.Directory(dir, currentDir)));
    }
  }

  public static void part1() {
    int total = 0;

    for(Directory directory: directories) {
      if(directory.getSize() <= 100000) {
        total += directory.getSize();
      }
    }

    System.out.println(total);
  }

  public static void part2() {
    int freeSpace = 70000000 - directories.get(0).getSize();
    int neededSpace = 30000000 - freeSpace;

    int smallest = directories.get(0).getSize();
    for (Directory dir: directories) {
      if(dir.getSize() <= smallest && dir.getSize() >= neededSpace){
        smallest = dir.getSize();
      }
    }

    System.out.println(smallest);
  }

}
