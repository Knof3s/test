public class WordFrequency  {
    public static void countWordStarts(String input) {
//1
        input = input.replaceAll("\\d", "");
//2
        String[] words = input.split("\\s+");
//3
        Set<Character> commonStarts = Set.of('a', 'e', 'i', 'o', 'u');
//4
        Map<Character, Integer> startFreq = new HashMap<>();
//5
        Stream.of(words)
                .map(word -> word.toLowerCase().charAt(0))
                .filter(ch -> !commonStarts.contains(ch))
                .forEach(ch -> startFreq.merge(ch, 1, Integer::sum));

//6
        List<Map.Entry<Character, Integer>> startFreqList = new ArrayList<>(startFreq.entrySet());
//7
        startFreqList.sort(Map.Entry.<Character, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
//8
        startFreqList.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
//9
        String input = "The 2 quick brown foxes jump over 3 lazy dogs.";
        countWordStarts(input);
    }
}
