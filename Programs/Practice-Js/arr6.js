function gymnastics(scores) {
  scores.sort((a, b) => a - b);
  let lowest = scores[0];
  let highest = scores[scores.length - 1];
  let total = scores.slice(1, -1).reduce((a, b) => a + b, 0);
  let avg = total / (scores.length - 2);
  
  console.log(`Lowest: ${lowest}`);
  console.log(`Highest: ${highest}`);
  console.log(`Total: ${total.toFixed(2)}`);
  console.log(`Average: ${avg.toFixed(2)}`);
}

gymnastics([9.1, 9.0, 8.9, 8.8, 9.4, 7.9, 8.6, 9.8]);
