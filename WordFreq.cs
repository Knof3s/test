using System;
using System.Collections.Generic;
using System.Linq;

public class WordStartCounter
{
//1
public static void CountWordStarts(string input)
{
//2
// Разбиваем входную строку на слова, используя пробелы в качестве разделителей
string[] words = input.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

//3
// Создаем множество символов, которые считаются общими (гласные)
HashSet<char> commonStarts = new HashSet<char> { 'a', 'e', 'i', 'o', 'u' };

//4
// Создаем словарь для хранения частоты начальных букв слов
Dictionary<char, int> startFreq = new Dictionary<char, int>();

//5
// Преобразуем массив слов в поток
foreach (var word in words)
{
//6
// Преобразуем каждое слово в нижний регистр и берем первый символ
char firstChar = char.ToLower(word[0]);

//7
// Фильтруем символы, исключая общие (гласные)
if (!commonStarts.Contains(firstChar))
{
//8
// Обновляем частоту начальных букв в словаре
if (startFreq.ContainsKey(firstChar))
{
startFreq[firstChar]++;
}
else
{
startFreq[firstChar] = 1;
}
}
}

//9
// Удаляем все цифры из строки
input = System.Text.RegularExpressions.Regex.Replace(input, @"\d", "");

//10
// Преобразуем словарь в список для сортировки
var startFreqList = startFreq.ToList();

//11
// Сортируем список по значению в обратном порядке, а затем по ключу
startFreqList.Sort((pair1, pair2) =>
{
int valueComparison = pair2.Value.CompareTo(pair1.Value);
return valueComparison == 0 ? pair1.Key.CompareTo(pair2.Key) : valueComparison;
});

//12
// Выводим каждую запись из списка на экран
foreach (var entry in startFreqList)
{
Console.WriteLine($"{entry.Key}: {entry.Value}");
}
}

public static void Main(string[] args)
{
//13
// Входная строка для анализа
string input = "The 2 quick brown foxes jump over 3 lazy dogs.";
CountWordStarts(input);
}
}
