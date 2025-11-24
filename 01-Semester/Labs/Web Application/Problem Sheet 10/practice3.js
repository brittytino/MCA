let str = "The value 10110 and 1100 are binary and also 110";

let result = str.replace(/\b[01]+\b/g, match => `\\b${match}`);

console.log(result);
