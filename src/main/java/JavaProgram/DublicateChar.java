package JavaProgram;


import java.util.HashMap;
import java.util.Map;

public class DublicateChar {
    public static void main(String[] args) {

        String input = "testing";
                char[] chars = input.toCharArray();

                Map<Character, Integer> map = new HashMap<>();

                // Count frequency of each character
                for (char ch : chars) {
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }

                // Print duplicate characters
                System.out.println("Duplicate characters:");
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey());
                    }
                }


    String a = "My name is Swapnil".toLowerCase();
    char[] arr = a.toCharArray();

        for (int i = 0; i < arr.length; i++) {
        int count = 1;
        if(arr[i]==' ')
            continue;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println(arr[i] + " -> " + count);
        }
    }
        }
        }



