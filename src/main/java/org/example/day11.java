package org.example;

public class day11 {

  private static java.util.ArrayList<Monkey> monkey = new java.util.ArrayList<>();
  private static java.math.BigInteger testProduct = java.math.BigInteger.valueOf(2*3*5*7*11*13*17*19);

  public static void main(String[] args) throws java.io.IOException {

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday11"));

    String[] input = str.split("\\n");

    int round = 1;
    for(int i = 0; i < 8; i++) {
      monkey.add(new org.example.Monkey());
    }
    loadMonkeys(input);

    for(int i = 0; i < 10000; i++) {
      System.out.println(i);
      processMonkeys();
    }

    Integer[] counts = new Integer[8];
    for(int i = 0; i < monkey.size(); i++) {
      System.out.println("Monkey: " + i + " inspected items " + monkey.get(i).inspections + " times");
      counts[i] = monkey.get(i).inspections;

    }
    java.util.Arrays.sort(counts);
    System.out.println(java.math.BigInteger.valueOf(counts[6]).multiply(java.math.BigInteger.valueOf(counts[7])));

  }

  private static void processMonkeys() {
    for(int j = 0; j < monkey.size(); j++) {
      Monkey m = monkey.get(j);
      for(int k = 0; k < m.items.size(); k++) {
        m.inspections += 1;
        java.math.BigInteger bigInt = m.items.get(k);
        //System.out.println("Monkey " + j + " inspects an item of worry level " + currentItem);
        bigInt = monkeyMaths(m, bigInt).mod(testProduct);
        //bigInt = bigInt.divide(java.math.BigInteger.valueOf(3));

        java.math.BigInteger result = (bigInt.mod(m.test));
        if(result.equals(java.math.BigInteger.ZERO)){
          monkey.get(m.trueThrow).items.add(bigInt);
        } else {
          monkey.get(m.falseThrow).items.add(bigInt);
        }
        m.items.remove(k);
        k--;
      }




    }
  }

  private static java.math.BigInteger monkeyMaths(Monkey m, java.math.BigInteger i) {
    java.math.BigInteger temp;
    if(java.util.Objects.equals(m.modifier, java.math.BigInteger.ZERO)) {
      temp = i;
    } else {
      temp = m.modifier;
    }
    switch(m.operation) {
      case "*":
        return i.multiply(temp);
      case "+":
        return i.add(temp);
      case "-":
        return i.subtract(temp);
    }
  return i;
  }

  private static void loadMonkeys(String[] input) {
    int i = -1;
    for(String s: input) {
      if(s.startsWith("Monkey")) {
        i += 1;
      }

      if(s.startsWith("  Starting items:")) {
        String tmp = s.substring(18);
        String[] items = tmp.split(", ");
        for(int j = 0; j < items.length; j++) {
          monkey.get(i).items.add(java.math.BigInteger.valueOf(Integer.parseInt(items[j])));
        }
      }

      if(s.startsWith("  Operation:")) {
        monkey.get(i).operation = s.substring(23,24);
        try {
          monkey.get(i).modifier = java.math.BigInteger.valueOf(Integer.parseInt(s.substring(25)));
        } catch (Exception e) {
          monkey.get(i).modifier = java.math.BigInteger.valueOf(0);
        }
      }

      if(s.startsWith("  Test:")) {
        monkey.get(i).test = java.math.BigInteger.valueOf(Integer.parseInt(s.split(" by ")[1]));
      }

      if(s.contains("If true:")) {
        monkey.get(i).trueThrow = Integer.parseInt(s.split("monkey ")[1]);
      }

      if(s.contains("If false:")) {
        monkey.get(i).falseThrow = Integer.parseInt(s.split("monkey ")[1]);
      }
    }

  }

}

class Monkey {
  java.util.ArrayList<java.math.BigInteger> items;
  String operation;
  java.math.BigInteger modifier;
  java.math.BigInteger test;
  int trueThrow;
  int falseThrow;
  int inspections;

  public Monkey() {

    items = new java.util.ArrayList<>();
  inspections = 0;
  }
}