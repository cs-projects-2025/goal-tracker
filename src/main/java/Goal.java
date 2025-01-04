/*
* Author: TS and OV
* Description:
* */
public class Goal {
    // TODO: finish the implemntation of the goal class

    private String goalCategory;
    private String strategy;
    private String measure;
    private int baseline;
    private int target;

    public Goal(String goalCategory, String strategy, String measure, int baseline, int target) {
        this.goalCategory = goalCategory;
        this.strategy = strategy;
        this.measure = measure;
        this.baseline = baseline;
        this.target = target;
    }

    public String getGoalCategory() {
        return goalCategory;
    }

    public void setGoalCategory(String goalCategory) {
        this.goalCategory = goalCategory;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getBaseline() {
        return baseline;
    }

    public void setBaseline(int baseline) {
        this.baseline = baseline;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalCategory='" + goalCategory + '\'' +
                ", strategy='" + strategy + '\'' +
                ", measure='" + measure + '\'' +
                ", baseline=" + baseline +
                ", target=" + target +
                '}';
    }
}
