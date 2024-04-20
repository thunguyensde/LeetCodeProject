import java.util.*;

public class ReconstructItinerary {
    /*
    332.

    requirement:
    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent
    the departure and the arrival airports of one flight.
    Reconstruct the itinerary in order and return it.
    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
    If there are multiple valid itineraries, you should return the itinerary
    that has the smallest lexical order when read as a single string.
    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    You may assume all tickets form at least one valid itinerary.
    You must use all the tickets once and only once.

    notes:
    - euler circuit: start at v, pass every edge once, end at v
    - hamilton circuit: start at v, pass every vertex once, end at v
    */

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String> itinerary = new LinkedList<>();
        findItineraryHelper(graph, "JFK", itinerary);
        return itinerary;
    }

    private void findItineraryHelper(Map<String, PriorityQueue<String>> graph, String departure, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.getOrDefault(departure, new PriorityQueue<>());
        while (!destinations.isEmpty()) {
            String dest = destinations.poll();
            findItineraryHelper(graph, dest, itinerary);
        }
        itinerary.addFirst(departure);
    }
}
