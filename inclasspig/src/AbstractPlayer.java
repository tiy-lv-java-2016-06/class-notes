/**
 * Created by jeff on 6/22/16.
 */
public abstract class AbstractPlayer implements Player{
    private String name;
    private int score;
    private Die die;

    public AbstractPlayer(String name) {
        this.name = name;
        score = 0;
        die = new Die();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int addScore(int score) {
        this.score += score;
        return this.score;
    }

    @Override
    public int roll() {
        return this.die.roll();
    }
}
