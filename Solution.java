import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    List<String> times = getTimes();
    
    List<Integer> seconds = times.stream()
      .map(t -> evaluateTime(t, 1))
      .collect(Collectors.toList());
    
    List<Integer> minutes = times.stream()
      .map(t -> evaluateTime(t, 0))
      .collect(Collectors.toList());
    
    Integer totalSeconds = seconds.stream().mapToInt(Integer::intValue).sum();
    
    Integer totalMinutes = minutes.stream().mapToInt(Integer::intValue).sum();
    
    Map<String, Integer> secondCalc = convert(totalSeconds);
    int finalSeconds = secondCalc.get("remainder");
    int finalMinutes = secondCalc.get("figure");
    
    Map<String, Integer> minutesCalc = convert(totalMinutes);
    finalMinutes = finalMinutes + minutesCalc.get("remainder");
    int hours = minutesCalc.get("figure");
    
    StringBuilder builder = new StringBuilder();
    builder.append(Integer.toString(hours) + ":");
    builder.append(Integer.toString(finalMinutes) + ":");
    builder.append(Integer.toString(finalSeconds));
    
    System.out.println("Final: " + builder.toString());
    
  }
  
  public static List<String> getTimes() {
    
    List<String> strings = new ArrayList<>();
    strings.add("12:32");
    strings.add("34:01");
    strings.add("15:23");
    strings.add("9:27");
    strings.add("55:22");
    strings.add("25:56");
    
    return strings;
  }
  
  public static int evaluateTime(String time, int index) {
    String value = time.split(":")[index];
    return Integer.parseInt(value);
  }
  
  public static Map<String, Integer> convert(int value) {
    int figure = value / 60;
    int remainder = value % 60;
    
    Map<String, Integer> finalFigure = new HashMap<String, Integer>();
    finalFigure.put("figure", figure);
    finalFigure.put("remainder", remainder);
    return finalFigure;
  }
  
  
}
