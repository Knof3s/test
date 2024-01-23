import java.util.*;

public class WordFrequency {
    //1
    public static void countWords(String input) {
        //2
        String[] words = input.split(" ");

        //3
        Set<String> commonWords = Set.of("the", "a", "an", "and", "or", "but");

        //4
        Map<String, Integer> wordFreq = new HashMap<>();

        //5
        for (String word : words) {
            //6
            word = word.toLowerCase();
            //7
            if (!commonWords.contains(word)) {
            //8
                wordFreq.merge(word, 1, Integer::sum);
            }
        }

        //10
        List<Map.Entry<String, Integer>> wordFreqList = new ArrayList<>(wordFreq.entrySet());

        //11
        wordFreqList.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));

        //12
        wordFreqList.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        //13
        String input = "the quick brown fox jumps over the lazy dog and the brown fox runs away";
        countWords(input);
    }
}
