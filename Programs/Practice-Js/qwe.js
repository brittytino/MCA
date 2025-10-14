// const greet = (name = "Guest", greeting = "Hello") => {
//   console.log(greeting + " " + name + "!");
// };
// greet();           // Hello Guest!
// greet("John");     // Hello John!
// greet("John", "Hi"); // Hi John!


let fruits = ["Apple", "Banana", "Orange"];
console.log(fruits[0]);    // Apple
console.log(fruits[1]);    // Banana
fruits.push("Mango");      
console.log(fruits);       // ["Apple", "Banana", "Orange", "Mango"]
fruits.pop();              
console.log(fruits);       // ["Apple", "Banana", "Orange"]
fruits.shift();            
console.log(fruits);       // ["Banana", "Orange"]
fruits.unshift("Pineapple");
console.log(fruits);       // ["Pineapple", "Banana", "Orange"]
fruits.forEach(function(item, index) {
    console.log(index + ": " + item);
});
console.log(fruits.length);      // 3
let index = fruits.indexOf("Banana");
console.log(index);              // 1
fruits.splice(index, 1);
console.log(fruits);            // ["Pineapple", "Orange"]
