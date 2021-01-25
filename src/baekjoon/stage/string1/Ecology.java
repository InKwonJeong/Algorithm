package baekjoon.stage.string1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Ecology {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> trees = new HashMap<>();
        double total = 0;
        while (br.ready()) {
            String tree = br.readLine();
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
            total++;
        }

        String[] tree_names = new String[trees.size()];
        trees.keySet().toArray(tree_names);
        Arrays.sort(tree_names);

        StringBuilder builder = new StringBuilder();
        for(String name : tree_names) {
            builder.append(name).append(" ");
            String percent = String.format("%.4f", (trees.get(name) / total) * 100);
            builder.append(percent).append("\n");
        }

        System.out.println(builder);
    }
}
