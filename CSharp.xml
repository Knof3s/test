using System;
using System.Collections.Generic;
using System.Linq;

public class WordFrequency
{
    public static void CountWords(string input)
    {
        //1 
        var words = input.Split(' ', StringSplitOptions.RemoveEmptyEntries);

        //2 
        var commonWords = new HashSet<string> { "the", "a", "an", "and", "or", "but" };

        //3 
        var wordFreq = new Dictionary<string, int>();

        //4
        foreach (var word in words)
        {
            var lower = word.ToLower();
            if (!commonWords.Contains(lower))
            {
                wordFreq[lower] = wordFreq.TryGetValue(lower, out var count) ? count + 1 : 1;
            }
        }

        //5
        var sorted = wordFreq
            .OrderByDescending(kv => kv.Value)
            .ThenBy(kv => kv.Key);

        //6 
        foreach (var kv in sorted)
        {
            Console.WriteLine($"{kv.Key}: {kv.Value}");
        }
    }

    public static void Main()
    {
        var input = "the quick brown fox jumps over the lazy dog and the brown fox runs away";
        CountWords(input);
    }
}
