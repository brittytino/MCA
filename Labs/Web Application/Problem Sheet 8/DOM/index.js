document.getElementById('heading').innerHTML = "DOM Lab in progress"; // dom 1 

document.getElementsByClassName('intro');
for (let i = 0; i < 2; i++) {
    document.getElementsByClassName('intro')[i].style.color = "blue"; // dom 2
}

var p = document.getElementsByTagName("p");
document.getElementById("output").innerHTML = p.length + " paragraphs found.";

var notes = document.getElementsByName("note");
for (let i = 0; i < notes.length; i++) {
    notes[i].style.backgroundColor = "lightblue";
}

document.querySelector('li.item').style.fontWeight = 'bold';

document.querySelector('#para1').append(' - Modified');

document.querySelectorAll('.item').forEach(item => {
    item.style.color = 'green';
});