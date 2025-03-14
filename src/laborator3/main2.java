package laborator3;
import java.util.Random;

// Clasa PasswordMaker cu Singleton
class PasswordMaker {
    private static PasswordMaker instance;
    private static int instanceCounter = 0;
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5;
    private final String magicString;
    private final String name;

    private PasswordMaker(String name) {
        this.name = name;
        this.magicString = StringRandomizer.generateRandomString(20);
    }

    public static synchronized PasswordMaker getInstance(String name) {
        if (instance == null) {
            instance = new PasswordMaker(name);
        }
        instanceCounter++;
        return instance;
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }

    public String getPassword() {
        String part1 = StringRandomizer.generateRandomString(MAGIC_NUMBER);
        String part2 = magicString.substring(0, 10);
        String part3 = Integer.toString(name.length());
        int part4 = new Random().nextInt(51);
        return part1 + part2 + part3 + part4;
    }
}

// Clasa StringRandomizer
class StringRandomizer {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(rand.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}

// Clasa Application pentru testare
class Application {
    public static void main(String[] args) {
        System.out.println("-- Testare PasswordMaker Singleton --");
        PasswordMaker pm1 = PasswordMaker.getInstance("JohnDoe");
        System.out.println("Generated password: " + pm1.getPassword());

        PasswordMaker pm2 = PasswordMaker.getInstance("JaneDoe");
        System.out.println("Generated password (should be same instance): " + pm2.getPassword());

        System.out.println("PasswordMaker getInstance() called: " + PasswordMaker.getInstanceCounter() + " times");
    }
}
