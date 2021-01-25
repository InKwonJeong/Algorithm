package baekjoon.stage.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortAge {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            Member[] a = new Member[n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                a[i] = new Member(age, name);
            }
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static class Member implements Comparable<Member> {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%d %s", age, name);
        }

        @Override
        public int compareTo(Member o) {
            if (age > o.getAge())
                return 1;
            else if (age == o.getAge())
                return 0;
            else
                return -1;
        }
    }
}

