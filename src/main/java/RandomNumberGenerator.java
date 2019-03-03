import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    public int getRandomNumber(int origin, int bound) {
        int randomInt = ThreadLocalRandom.current().nextInt(origin, bound);
        return randomInt;
    }

    public int getRandomNumber() {
        return getRandomNumber(100000, 200000);
    }
}
