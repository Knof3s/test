function wordFrequency(str: string): void {
const exclude = ["the", "a", "an", "and", "or", "but"];
const words = str.split(" ");
const freqMap = {};
 words.forEach((word) => {
    if (!exclude.includes(word)) {
      if (!freqMap[word]) {
        freqMap[word] = 0;
      }
      freqMap[word] += 1;
    }
  });
const sortedWords: string[] = Object.keys(freqMap).sort((a, b) => freqMap[b] - freqMap[a]);
sortedWords.forEach((word) => console.log(`${word}: ${freqMap[word]}`));
}

// Пример использования функции
wordFrequency("The quick brown fox jumps over the lazy dog and the dog does not care.");
