// ---------------- Part A: Traditional DOM Methods ----------------

// 1. Change heading text
document.getElementById('heading').innerHTML = "DOM Lab in Progress"; // dom 1

// 2. Change color of paragraphs with class "intro"
for (let i = 0; i < document.getElementsByClassName('intro').length; i++) {
    document.getElementsByClassName('intro')[i].style.color = "blue"; // dom 2
}

// 3. Count all <p> tags and show in output
var p = document.getElementsByTagName("p");
document.getElementById("output").innerHTML = p.length + " paragraphs found."; // dom 3

// 4. Change background color of paragraph with name="note"
var notes = document.getElementsByName("note");
for (let i = 0; i < notes.length; i++) {
    notes[i].style.backgroundColor = "lightblue"; // dom 4
}


// ---------------- Part B: querySelector & querySelectorAll ----------------

// 5. Make first <li> bold
document.querySelector('li.item').style.fontWeight = 'bold'; // dom 5

// 6. Append text to paragraph with id="para1"
document.querySelector('#para1').append(' (Modified)'); // dom 6

// 7. Change all list items to green
document.querySelectorAll('.item').forEach(item => {
    item.style.color = 'green'; // dom 7
});

// 8. Log all paragraphs with class "intro"
document.querySelectorAll('p.intro').forEach(p => {
    console.log(p.textContent); // dom 8
});


// ---------------- Part C: Compare Methods ----------------

// 9. Compare same element using two methods
var a = document.getElementById('para1');
var b = document.querySelector('#para1');
console.log(a === b); // true (same element) // dom 9

// 10. Compare return types
console.log(document.getElementsByClassName('intro')); // HTMLCollection
console.log(document.querySelectorAll('.intro')); // NodeList // dom 10


// ---------------- Part D: Styling and Manipulation ----------------

// 11. Change last <li> text to "Orange"
document.querySelector("ul li:last-child").textContent = "Orange"; // dom 11

// 12. Add numbers before each fruit name
document.querySelectorAll(".item").forEach((item, i) => {
    item.textContent = (i + 1) + ". " + item.textContent; // dom 12
});

// 13. Hide second paragraph
document.getElementsByTagName("p")[1].style.display = "none"; // dom 13

// 14. Underline first .intro paragraph
document.querySelector("p.intro").style.textDecoration = "underline"; // dom 14

// 15. Change background of all list items
for (let i = 0; i < document.getElementsByClassName("item").length; i++) {
    document.getElementsByClassName("item")[i].style.backgroundColor = "lightyellow"; // dom 15
}


// ---------------- Part E: Attribute Access ----------------

// 16. Print tag name of heading
console.log(document.querySelector("#heading").tagName); // dom 16

// 17. Change text color of [name="note"]
document.querySelector("[name='note']").style.color = "red"; // dom 17

// 18. Log innerHTML of all paragraphs
document.querySelectorAll("p").forEach(p => {
    console.log(p.innerHTML); // dom 18
});

// 19. Change id of para1 to firstPara
document.getElementById("para1").id = "firstPara"; // dom 19

// 20. Add new list item "Grapes"
var newLi = document.createElement("li");
newLi.className = "item";
newLi.textContent = "4. Grapes";
document.querySelector("ul").appendChild(newLi); // dom 20


// ---------------- Part F: Interactive Tasks ----------------

// 21. Increase font size of all paragraphs
function increaseFont() {
    document.querySelectorAll("p").forEach(p => {
        p.style.fontSize = (parseInt(window.getComputedStyle(p).fontSize) + 2) + "px"; // dom 21
    });
}

// 22. Highlight all list items
function highlightList() {
    document.querySelectorAll("li.item").forEach(li => {
        li.style.backgroundColor = "lightgreen"; // dom 22
    });
}

// 23. Count intro paragraphs and display count
function countIntroParas() {
    var count = document.querySelectorAll(".intro").length;
    document.getElementById("output").innerHTML = count + " intro paragraphs found."; // dom 23
}

// 24. Count elements of user input tag name
function countTags() {
    var tag = document.getElementById("tagInput").value;
    var count = document.getElementsByTagName(tag).length;
    document.getElementById("output").innerHTML = count + " <" + tag + "> elements found."; // dom 24
}

// 25. Toggle heading color on click
document.querySelector("h2").addEventListener("click", function () {
    this.style.color = this.style.color === "red" ? "black" : "red"; // dom 25
});
