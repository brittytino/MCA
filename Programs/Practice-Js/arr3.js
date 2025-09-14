let arr = [7,4,9,5,2,8];
let asc = [...arr].sort((a,b)=> a-b);
let desc = [...arr].sort((a,b)=> b-a);

console.log("Ascending : ",asc);
console.log("Descending : ",desc);