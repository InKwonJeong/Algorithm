package baekjoon.stage.divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LargestRectangleInHistogram {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            bw.write(biggestSquare(0, n - 1) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static long biggestSquare(long l, long r) {
        long res;
        if (r == l)
            return arr[(int) r];
        long mid = (r + l) / 2;

        long left = biggestSquare(l, mid);
        long right = biggestSquare(mid + 1, r);

        res = Math.max(left, right);
        long leftIndex = mid - 1, rightIndex = mid + 2;
        long minArr = Math.min(arr[(int) mid], arr[(int) (mid + 1)]);
        long squarenum = 2;
        res = Math.max(res, minArr * squarenum);

        while (rightIndex <= r && leftIndex >= l) {
            if (arr[(int) rightIndex] < arr[(int) leftIndex]) {
                minArr = Math.min(arr[(int) leftIndex], minArr);
                leftIndex--;
            } else {
                minArr = Math.min(arr[(int) rightIndex], minArr);
                rightIndex++;
            }
            squarenum++;
            res = Math.max(res, minArr * squarenum);
        }
        while (leftIndex >= l) {
            minArr = Math.min(arr[(int) leftIndex], minArr);
            leftIndex--;
            squarenum++;
            res = Math.max(res, minArr * squarenum);
        }
        while (rightIndex <= r) {
            minArr = Math.min(arr[(int) rightIndex], minArr);
            rightIndex++;
            squarenum++;
            res = Math.max(res, minArr * squarenum);
        }
        return res;
    }
}


