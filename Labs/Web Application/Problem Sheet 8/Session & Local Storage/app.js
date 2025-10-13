let visitCount = sessionStorage.getItem('visitCount');
if (visitCount){
    visitCount = parseInt(visitCount) +1;
}
else {
    visitCount = 1;
}

sessionStorage.setItem('visitCount',visitCount);
console.log(visitCount);

document.getElementById('visit-msg').textContent= `You have visited this page ${visitCount}`





function addName(event){
    event.preventDefault();
    let name = document.getElementById('input-name').value;
    localStorage.setItem('name',name);
    sessionStorage.setItem('name',name);

    let rollno = document.getElementById('input-rollno').value;
    localStorage.setItem('rollno',rollno);
    sessionStorage.setItem('rollno',rollno);

}

