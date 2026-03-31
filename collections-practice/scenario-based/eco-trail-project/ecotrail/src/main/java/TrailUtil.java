import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrailUtil{
    private List<Trail> trailList = new ArrayList<>();

    public boolean addTrailRecord(Trail trail){
        if(trail == null) return false;
        trailList.add(trail);
        return true;
    }

    public Trail getTrailById(String trailId){
        if(trailId == null) return null;
        for(Trail t : trailList){
            if(t.getTrailId().equalsIgnoreCase(trailId)){
                return t;
            }
        }

        return null;
    }

    public Set<Trail> getMostHikedTrails(){
        Set<Trail> set = new HashSet<>();
        if(trailList.isEmpty()) return set;

        int max = trailList.stream().mapToInt(Trail::getHikeCount).max().orElse(0);
        // for(Trail t : trailList){
        //     if(t.getHikeCount() > max){
        //         max = t.getHikeCount();
        //     }
        // }

        for(Trail t: trailList){
            if(t.getHikeCount() == max){
                set.add(t);
            }
        }

        return set;
    }

    public Map<String, Integer> getHikeCountByRegion(){
        Map<String, Integer> map = new HashMap<>();

        for(Trail t : trailList){
            map.put(t.getRegion(), map.getOrDefault(t.getRegion(), 0) + t.getHikeCount());
        }

        return map;
    }

    public Map<String, List<Trail>> groupTrailsByDifficulty(){
        Map<String, List<Trail>> grouped = new HashMap<>();

        for(Trail t : trailList){
            grouped.computeIfAbsent(t.getDifficulty(), k -> new ArrayList<>()).add(t);
        }

        return grouped;
    }

    public boolean updateHikeCount(String trailId, int additionalHikes){
        if(additionalHikes <= 0) return false;

        Trail t = getTrailById(trailId);
        if(t != null){
            t.setHikeCount(t.getHikeCount() + additionalHikes);
            return true;
        }

        return false;
    }

    public List<Trail> filterTrails(String region, String difficulty){
        if (region == null || difficulty == null) return Collections.emptyList();
        
        List<Trail> filtered = new ArrayList<>();
        for(Trail t : trailList){
            if(t.getRegion().equalsIgnoreCase(region) && t.getDifficulty().equalsIgnoreCase(difficulty)){
                filtered.add(t);
            }
        }

        return filtered;
    }

    public Map<String, List<Trail>> getTopTrailsByRegion(int n) {
        if (n <= 0) return Collections.emptyMap();
        
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getRegion,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Trail::getHikeCount).reversed())
                                        .limit(n)
                                        .toList()
                        )
        ));
    }

    public Map<String, String> getDifficultyStats() {
        Map<String, String> map = new HashMap<>();

        addStatsForDifficulty("Easy", map);
        addStatsForDifficulty("Medium", map);
        addStatsForDifficulty("Hard", map);

        return map;
    }

    private void addStatsForDifficulty(String difficulty, Map<String, String> map) {
        int trailCount = 0;
        int hikeCount = 0;

        for (Trail t : trailList) {
            if (t.getDifficulty().equalsIgnoreCase(difficulty)) {
                trailCount++;
                hikeCount += t.getHikeCount();
            }
        }

        double average = 0;
        if (trailCount > 0) {
            average = (double) hikeCount / trailCount;
        }

        String stats = "Total trails: " + trailCount +
                    ", Total hike counts: " + hikeCount +
                    ", Average hike count: " + average;

        map.put(difficulty, stats);
    }
}