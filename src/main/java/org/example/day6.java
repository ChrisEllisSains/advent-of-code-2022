package org.example;

public class day6 {

  public static void main(String[] args) throws java.io.IOException {

    String str = java.nio.file.Files.readString(
        java.nio.file.Paths.get("src/main/resources/inputday6"));

    java.util.ArrayDeque<Character> last4Chars = new java.util.ArrayDeque<>();

    for(int i = 0; i < 13; i++) {
      last4Chars.add(str.charAt(i));
    }
    for(int i = 3; i < str.length(); i++) {
      last4Chars.add(str.charAt(i));
      System.out.println("Comparing: " + last4Chars.toString());
      if(isMarker(last4Chars)) {
        System.out.println("Marker is: " + last4Chars.toString() + " at position: " + (i+1));
        break;
      } else {
        last4Chars.pop();
      }
    }

  }

  private static boolean isMarker(java.util.ArrayDeque<Character> last4Chars) {

    java.util.Set<Character> distintValues = new java.util.HashSet<Character>(last4Chars);

    return (distintValues.size() == last4Chars.size());
  }

}
