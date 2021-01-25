package codingtest.kakaoenterprise;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result3 {

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY space
     */

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        Integer[] array = new Integer[space.size()];
        space.toArray(array);
        Arrays.sort(array);

        int answer = 0;
        int min_index = 0;
        int max_index = array.length - 1;

        while (min_index <= max_index) {
            int mid_index = (min_index + max_index) / 2;
            if(check(space, array[mid_index], x)) {
                answer = array[mid_index];
                min_index = mid_index + 1;
            } else {
                max_index = mid_index - 1;
            }
        }
        return answer;
    }

    private static boolean check(List<Integer> space, int value, int x) {
        int count = 0;
        for(int a : space) {
            if(value <= a)
                count++;
            else
                count = 0;

            if(count >= x)
                return true;
        }
        return false;
    }

}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> space = IntStream.range(0, spaceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result3.segment(x, space);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
