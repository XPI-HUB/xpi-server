package com.xpi.xpiserver.service.dataExtraction;

import java.io.IOException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReadabilityService {
    public String readability(final MultipartFile file) throws IOException {
        String fileData = new String(file.getBytes());
        return runReadabilityCalculator(fileData);
    }

    @SuppressWarnings("checkstyle:LineLength")
    public String runReadabilityCalculator(final String text) {
        String score="";
        try {
            int sentenceCount = text.split("[.?!][\\s]+").length;
            int wordCount = text.split("[\\s]+").length;
            int charCount = text.replaceAll("[\\s]+", "").length();
            int syllableCount = 0;
            int polySyllableCount = 0;
            for (String word : text.split("[,:'\"]?[\\s]+[,:'\"]?")) {
                if (word.charAt(word.length() - 1) == 'e') {
                    word = word.substring(0, word.length() - 1);
                }
                int syllables = (int) Pattern.compile("[aeiouy]+").matcher(word).results().count();
                polySyllableCount += syllables >= 3 ? 1 : 0;
                syllableCount += syllables == 0 ? 1 : syllables;
            }
            double scoreARI = (4.71 * charCount / wordCount) +
                    (0.5 * wordCount / sentenceCount) - 21.43;
            double scoreFK = (0.39 * wordCount / sentenceCount) +
                    (11.8 * syllableCount / wordCount) - 15.59;
            double scoreSMOG = 1.043 * Math.sqrt(polySyllableCount * 30f / sentenceCount) + 3.1291;
            double scoreCL = 0.0588 * ((double) charCount / wordCount * 100) -
                    0.296 * ((double) sentenceCount / wordCount * 100) - 15.8;

            int ageARI = getAge(scoreARI);
            int ageFK = getAge(scoreFK);
            int ageSMOG = getAge(scoreSMOG);
            int ageCL = getAge(scoreCL);
            double avg = (ageARI + ageARI + ageSMOG + ageCL) / 4f;
            score = ("Words: %d\nSentences: %d\nCharacters: %d\nSyllables: %d" +
                    "\nPolysyllables: %dAutomated Readability Index:%s (about %d year olds)" +
                    "\nFlesch-Kincaid readability tests: %s (about %d year olds)" +
                    "\nSimple Measure of Gobbledygook: %s (about %d year olds)" +
                    "\nColeman-Liau index: %s (about %d year olds)" +
                    "\n\nThis text should be understood in average by %s year olds.")
                    .formatted(wordCount, sentenceCount, charCount, syllableCount, polySyllableCount, scoreARI, ageARI, scoreFK, ageFK, scoreSMOG, ageSMOG, scoreCL, ageCL, avg);
        } catch (ArithmeticException exception) {
            System.out.println("Empty file");
        }
        return score;
    }

    public static int getAge(final double grade) {
        int score = (int) Math.round(grade);
        if (score < 3) {
            return score + 5;
        } else if (score < 13) {
            return score + 6;
        } else if (score < 14) {
            return score + 11;
        } else {
            return 30;
        }
    }
}
