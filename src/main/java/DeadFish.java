
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeadFish {

    /**
     * algorithm on codewars
     * link: https://www.codewars.com/kata/51e0007c1f9378fa810002a9/train/java
     *
     * Write a simple parser that will parse and run Deadfish.
     *
     * Deadfish has 4 commands, each 1 character long:
     *
     * i increments the value (initially 0)
     * d decrements the value
     * s squares the value
     * o outputs the value into the return array
     * Invalid characters should be ignored.
     *
     * Example: Deadfish.parse("iiisdoso") =- new int[] {8, 64};
     */


//  first solution
    public static int[] parse(String data) {

        int[] intArr;
        ArrayList<Integer> intArrList = new ArrayList<>();

        String increase = "i";
        String decrease = "d";
        String square = "s";
        String output = "o";

        int count = 0;

        String[] arr = data.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(increase)) {
                count++;
            }
            if (arr[i].equals(decrease)) {
                count--;
            }
            if (arr[i].equals(square)) {
                count *= count;
            }
            if (arr[i].equals(output)) {
                intArrList.add(count);
            }
        }
        intArr = intArrList.stream().mapToInt(i -> i).toArray();
        return intArr;
    }

//  second solution
    public static int[] parse2(String data) {
        int value = 0;
        List<Integer> result = new ArrayList<>();
        for(char letter : data.toCharArray()) {
            switch(letter) {
                case 'i': value++; break;
                case 'd': value--; break;
                case 's': value *= value; break;
                case 'o': result.add(value); break;
                default: throw new IllegalArgumentException("Not valid code letter");
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println("Parse === " + Arrays.toString(parse("iisisdosoensndeoiu")));

        System.out.println("Parse2 === " + Arrays.toString(parse2("idosoenndeoiuss")));
    }

}
