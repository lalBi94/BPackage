/* [BRandom]
 *  Desc: To create a random number fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

public class BRandom {
    private int beginAt = 0;
    private int finishAt = 0;
    private int number = 0;

    public BRandom(int between, int and) {
        this.beginAt = between;
        this.finishAt = and;
    }

    public int getRandom() {
        this.number = (int) (Math.random() * (finishAt - beginAt)) + beginAt;
        return this.number;
    }

    @Override
    public String toString() {
        return "Random value generated: " + this.number;
    }
}