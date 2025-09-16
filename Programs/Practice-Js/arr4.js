function sE(arr,key){
    for(let i =0; i < arr.length; i++){
        if (arr[i]===key)
            return i;
    }
    return -1;
}
console.log(sE([70,80,90,100],90));

//d
