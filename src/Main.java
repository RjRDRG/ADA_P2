import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int nchilds = Integer.parseInt(in.readLine());

        List<Integer>[] sticks = new List[nchilds];

        for(int i=0; i<nchilds; i++) {
            String[] line = in.readLine().split(" ");;
            int nsticks = Integer.parseInt(line[0]);
            sticks[i] = new ArrayList<>(nsticks);
            for(int j=1; j<=nsticks; j++) {
                sticks[i].add(Integer.parseInt(line[j]));
            }
        }

        Integer max = null;

        for(List<Integer> list : sticks) {
            for(Integer stick : list) {
                if(max == null || stick > max)
                    max = stick;
            }
        }

        System.out.println(max);
    }
}

/*
4
3 5 12 2
0
3 25 5 17
5 2 4 2 10 21
 */