let count = 0;
let timer = setInterval(function() {
  count++;
  console.log(count);
  if (count === 5) {
    clearInterval(timer);
  }
}, 1000);
