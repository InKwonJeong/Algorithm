package codingtest.kakaoenterprise;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result2 {

    /*
     * Complete the 'requestsServed' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamp
     *  2. INTEGER_ARRAY top
     */

    public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
        // Write your code here
        timestamp.sort(Comparator.reverseOrder());
        top.sort(Comparator.reverseOrder());
        int answer = 0;
        int index = 0;
        for(int t : top) {
            for(int i = index; i < timestamp.size(); i++) {
                if(t >= timestamp.get(i)) {
                    if(i + 5 > timestamp.size()) {
                        index = timestamp.size();
                        answer += timestamp.size() - i;
                    } else {
                        index = i + 5;
                        answer += 5;
                    }
                    break;
                }
            }
        }

        return answer;
    }

}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int timestampCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> timestamp = IntStream.range(0, timestampCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int topCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> top = IntStream.range(0, topCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.requestsServed(timestamp, top);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

