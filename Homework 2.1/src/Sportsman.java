public class Sportsman {
    protected String name;
    protected int runDistance;
    protected int swimDistance;
    protected int jumpDistance;

    public Sportsman(String name, int runDistance, int swimDistance, int jumpDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpDistance = jumpDistance;
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public int getJumpDistance() {
        return jumpDistance;
    }
}
