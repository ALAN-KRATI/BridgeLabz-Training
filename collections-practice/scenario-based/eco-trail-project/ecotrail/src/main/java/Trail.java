public class Trail{
    private String trailId;
    private String name;
    private String region;
    private String difficulty;
    private int hikeCount;

    public Trail(){}

    public Trail(String trailId, String name, String region, String difficulty, int hikeCount){
        this.trailId = trailId;
        this.name = name;
        this.region = region;
        this.difficulty = difficulty;
        this.hikeCount = hikeCount;
    }

    public String getTrailId(){return trailId; }
    public String getName(){ return name; }
    public String getRegion(){ return region; }
    public String getDifficulty(){ return difficulty; }
    public int getHikeCount(){ return hikeCount; }

    public void setTrailId(String id){this.trailId = id;}
    public void setName(String name){this.name = name;}
    public void setRegion(String region){this.region = region;}
    public void setDifficulty(String difficulty){this.difficulty = difficulty;}
    public void setHikeCount(int hikeCount){this.hikeCount = hikeCount;}

    public String toString(){
        return "trailId = " + trailId + " | name = " + name + " | region = " + region + " | difficulty = " + difficulty + " | hikecount = " + hikeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trail)) return false;
        Trail t = (Trail) o;
        return trailId.equalsIgnoreCase(t.trailId);
    }

    @Override
    public int hashCode() {
        return trailId.toLowerCase().hashCode();
    }
}