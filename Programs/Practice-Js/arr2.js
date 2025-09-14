function sL(arr){
    if(arr.length <2 )
        return null

    arr.sort((a,b)=> b-a);
    return arr[1];
}
 console.log(sL([80,10,30,40,20]));
