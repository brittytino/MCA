function stringOps(str){
  let len=0,rev="";
  for(let ch of str){len++;rev=ch+rev;}
  console.log(len);     // length
  console.log(rev);     // reverse
  console.log(str);     // copy
}
stringOps("Apple");
