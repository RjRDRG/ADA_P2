import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        line = in.readLine().split(" ");
        int nlocations = Integer.parseInt(line[0]);
        int nconnections = Integer.parseInt(line[1]);

        List<Integer>[] adjacencies = new List[nlocations];

        for(int i=0; i<nconnections; i++) {
            line = in.readLine().split(" ");
            int location0 = Integer.parseInt(line[0]);
            int location1 = Integer.parseInt(line[1]);

            if(adjacencies[location0] == null)
                adjacencies[location0] = new ArrayList<>();

            if(adjacencies[location1] == null)
                adjacencies[location1] = new ArrayList<>();

            adjacencies[location0].add(location1);
            adjacencies[location1].add(location0);
        }

        int nsick = Integer.parseInt(in.readLine());

        Map<Integer,Integer> sick = new HashMap<>();

        for (int i=0; i<nsick; i++) {
            line = in.readLine().split(" ");
            int home = Integer.parseInt(line[0]);
            int distance = Integer.parseInt(line[1]);
            sick.put(home,distance);
        }


    }
}