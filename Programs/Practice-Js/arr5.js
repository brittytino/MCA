function cN(arr){
    let pos = 0, neg = 0, even = 0 , odd = 0;
    for (let num of arr){
        if(num >=0)
            pos++;
        else 
            neg++;
        if(num % 2 === 0)
            even ++;
        else 
            odd++;

    }
    console.log(`Positive: ${pos} Negative: ${neg} Even: ${even} Odd: ${odd}`);
    
}

cN([1,-2,3,4,-5]);