package org.example;

public class Directory {

  String name;

  Directory parent;
  java.util.List<Integer> files;
  java.util.List<Directory> subDirs;


  Directory(String name, Directory parent) {
    this.name = name;
    this.parent = parent;

    files = new java.util.ArrayList<>();
    subDirs = new java.util.ArrayList<>();
  }

  int getSize() {

    int total = 0;

    for (int i = 0; i < files.size(); i++) {
      total += files.get(i);
    }

    for (int i = 0; i < subDirs.size(); i++) {
      total += subDirs.get(i).getSize();
    }

    return total;
  }

  @Override
  public String toString() {
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Directory && ((Directory) obj).name.equals(this.name)) {
      return true;
    }

    return false;
  }
}