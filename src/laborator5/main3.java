package laborator5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class main3 {
    public static void main(String[] args) {
        // Execută operațiunile pe fișiere
        FileOperations.runOperations();
    }
}

class FileOperations {
    public static void runOperations() {
        String inputFile = "in.txt";       // Asigură-te că acest fișier există
        String outputFile = "out.txt";
        String randomWordsFile = "outrand.txt";

        processFile(inputFile, outputFile);
        generateRandomWordsFile(randomWordsFile);
    }

    static void processFile(String inputFile, String outputFile) {
        try {
            if (!Files.exists(Paths.get(inputFile))) {
                System.out.println("Eroare: Fișierul " + inputFile + " nu există.");
                return;
            }

            List<String> lines = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
            List<String> modifiedLines = new ArrayList<>();

            for (String line : lines) {
                modifiedLines.add(line.trim()); // Elimină spațiile goale la început și sfârșit
                String replacedLine = line.replaceAll("\\.", ".\n").trim();

                // Adaugă doar dacă linia modificată nu este goală
                if (!replacedLine.isEmpty()) {
                    modifiedLines.add(replacedLine);
                }
            }

            Files.write(Paths.get(outputFile), modifiedLines, StandardCharsets.UTF_8);
            System.out.println("Fișierul " + outputFile + " a fost creat cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la procesarea fișierului: " + e.getMessage());
        }
    }

    static void generateRandomWordsFile(String fileName) {
        Random rand = new Random();
        int wordCount = 10;
        int lineCount = 5;
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < lineCount; i++) {
            List<String> words = new ArrayList<>();
            for (int j = 0; j < wordCount; j++) {
                words.add(generateRandomWord(rand, 4));
            }
            Collections.sort(words);
            lines.add(String.join(" ", words));
        }

        try {
            Files.write(Paths.get(fileName), lines, StandardCharsets.UTF_8);
            System.out.println("Fișierul " + fileName + " a fost generat cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la generarea fișierului: " + e.getMessage());
        }
    }

    static String generateRandomWord(Random rand, int length) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            word.append(c);
        }
        return word.toString();
    }
}
