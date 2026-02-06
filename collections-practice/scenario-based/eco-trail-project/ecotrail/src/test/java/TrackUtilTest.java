import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrackUtilTest{
    private TrailUtil util;
    
    @BeforeEach
    void setup(){
        util = new TrailUtil();

        util.addTrailRecord(new Trail("T1", "Everest", "Asia", "Easy", 100));
        util.addTrailRecord(new Trail("T2", "Alps", "Europe", "Medium", 150));
        util.addTrailRecord(new Trail("T3", "Rockies", "America", "Hard", 150));
        util.addTrailRecord(new Trail("T4", "Fuji", "Asia", "Easy", 80));
    }

    @Test
    void testGetTrailById(){
        Trail t = util.getTrailById("T1");
        assertNotNull(t);
        assertEquals("Everest", t.getName());
    }

    @Test
    void testGetTrailByInvalid(){
        assertNull(util.getTrailById("INVALID"));
    }

    @Test
    void testGetMostHikedTrails(){
        Set<Trail> mostHiked = util.getMostHikedTrails();
        assertEquals(2, mostHiked.size());
    }

    @Test
    void testGetHikeCountByRegion(){
        Map<String, Integer> result = util.getHikeCountByRegion();
        assertEquals(180, result.get("Asia"));
        assertEquals(150, result.get("Europe"));
        assertEquals(150, result.get("America"));
    }

    @Test
    void testGroupTrailsByDifficulty(){
        Map<String, List<Trail>> grouped = util.groupTrailsByDifficulty();
        assertEquals(2, grouped.get("Easy").size());
        assertEquals(1, grouped.get("Medium").size());
        assertEquals(1, grouped.get("Hard").size());
    }

    @Test 
    void testUpdateHikeCountValid(){
        boolean b = util.updateHikeCount("T1", 20);
        assertTrue(b);
        assertEquals(120, util.getTrailById("T1").getHikeCount());
    }

    @Test
    void testUpdateHikeCountInvalid(){
        assertFalse(util.updateHikeCount("INVALID", 10));
    }

    @Test
    void testFilterTrails(){
        List<Trail> filtered = util.filterTrails("Asia", "Easy");
        assertEquals(2, filtered.size());
    }

    @Test
    void testTopTrailsByRegion(){
        Map<String, List<Trail>> topk = util.getTopTrailsByRegion(1);

        assertEquals(1, topk.get("Asia").size());
        assertEquals(100, topk.get("Asia").get(0).getHikeCount());
    }

    @Test
    void testDifficultyStats(){
        Map<String, String> stats = util.getDifficultyStats();

        String stat = stats.get("Easy");
        assertTrue(stat.contains("Total trails: 2"));
        assertTrue(stat.contains("Total hike counts: 180"));
    }

}