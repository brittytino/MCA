const text = "Sky birds fly over the mountain and through clouds.";

const regex = /\b\w*[aeiouAEIOU]\w*\b/g;

const wordsWithVowels = text.match(regex);

console.log(wordsWithVowels);
