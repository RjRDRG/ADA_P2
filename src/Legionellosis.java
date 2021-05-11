import java.util.*;

public class Legionellosis {

    List<Integer>[] adjacencies;
    Map<Integer,Integer> sick;
    final int nsick;

    public Legionellosis(List<Integer>[] adjacencies, Map<Integer,Integer> sick, int nsick) {
        this.adjacencies = adjacencies;
        this.sick = sick;
        this.nsick = nsick;
    }

    Set<Integer> solve() {
        int[] sickCounter = new int[adjacencies.length];
        Set<Integer> perilousLocations = new HashSet<>();

        for(Map.Entry<Integer,Integer> entry: sick.entrySet()){
            Queue<RelativeLocation> frontier = new LinkedList<>();
            Set<Integer> explored = new HashSet<>();

            int home = entry.getKey();
            int maxDistance = entry.getValue();

            frontier.add(new RelativeLocation(home,0));
            explored.add(home);

            while (!frontier.isEmpty()) {
                RelativeLocation currentLocation = frontier.poll();

                sickCounter[currentLocation.index] += 1;

                if (sickCounter[currentLocation.index]==nsick)
                    perilousLocations.add(currentLocation.index);

                for (Integer adj : adjacencies[currentLocation.index]) {
                    int newDistance = currentLocation.distance+1;
                    if(newDistance <= maxDistance && !explored.contains(adj)) {
                        frontier.add(new RelativeLocation(adj, newDistance));
                        explored.add(adj);
                    }
                }
            }
        }


        return perilousLocations;
    }

}
