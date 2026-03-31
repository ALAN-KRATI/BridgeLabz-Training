public class Tank{
    private String tankId;
    private double capacity;
    private double currentLevel;

    public Tank(String tankId, double capacity, double currentLevel) throws InvalidWaterLevelException{
        if(currentLevel > capacity) throw new InvalidWaterLevelException("Tank " + tankId + " level exceed capacity!");
        this.tankId = tankId;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public String getTankId(){ return tankId; }
    public double getCapacity(){ return capacity; }
    public double getCurrentLevel(){ return currentLevel; }

    public void setTankId(String tankId){ this.tankId = tankId; }
    public void setCapacity(double capacity){ this.capacity = capacity; }
    public void setCurrentLevel(double currentLevel){ this.currentLevel = currentLevel;}

    public String toString(){
        return tankId + " -> " + capacity + " -> " + currentLevel;
    }
}