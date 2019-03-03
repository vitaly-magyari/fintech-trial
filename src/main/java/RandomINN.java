import java.util.concurrent.ThreadLocalRandom;

public class RandomINN {
    public String getRandomINN() {
        int a = 7;
        int b = 7;
        int c = ThreadLocalRandom.current().nextInt(0, 9);
        int d = ThreadLocalRandom.current().nextInt(0, 9);
        int e = ThreadLocalRandom.current().nextInt(0, 9);
        int f = ThreadLocalRandom.current().nextInt(0, 9);
        int g = ThreadLocalRandom.current().nextInt(0, 9);
        int h = ThreadLocalRandom.current().nextInt(0, 9);
        int i = ThreadLocalRandom.current().nextInt(0, 9);
        int j = ThreadLocalRandom.current().nextInt(0, 9);

        int k = ((a * 7 + b * 2 + c * 4 + d * 10 + e * 3 + f * 5 + g * 9 + h * 4 + i * 6 + j * 8) % 11) % 10;
        int z = ((a * 3 + b * 7 + c * 2 + d * 4 + e * 10 + f * 3 + g * 5 + h * 9 + i * 4 + j * 6 + k * 8) % 11) % 10;


        String string = new String();
        String s1 = String.valueOf(a);
        String s2 = s1 + b + c + d + e + f + g + h + i + j + k + z;
        String str = String.valueOf(s2);

        return str;
    }
}