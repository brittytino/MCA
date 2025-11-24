function validateName() {
  let n = document.getElementById("name");
  let e = document.getElementById("nameError");
  if (!/^[A-Za-z\s]+$/.test(n.value)) e.textContent = "Invalid name";
  else e.textContent = "✔";
}

function validateEmail() {
  let e = document.getElementById("email");
  let err = document.getElementById("emailError");
  if (!/^[^@]+@[^@]+\.(com|edu|in)$/.test(e.value)) err.textContent = "Invalid email";
  else err.textContent = "✔";
}

function validatePassword() {
  let p = document.getElementById("password");
  let e = document.getElementById("passwordError");
  if (p.value.length < 6 || !/\d/.test(p.value)) e.textContent = "Invalid password";
  else e.textContent = "✔";
}

function validateMobile() {
  let m = document.getElementById("mobile");
  let e = document.getElementById("mobileError");
  if (!/^\d{10}$/.test(m.value)) e.textContent = "Invalid number";
  else e.textContent = "✔";
}

function validateDOB() {
  let d = document.getElementById("dob");
  let e = document.getElementById("dobError");
  if (d.value === "") e.textContent = "Select DOB";
  else e.textContent = "✔";
}

function displayData() {
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let rating = document.querySelector('input[name="rating"]:checked');
  let interests = document.querySelectorAll('input[name="interest"]:checked');
  let list = [];
  interests.forEach(i => list.push(i.value));

  alert(
    "Name: " + name +
    "\nEmail: " + email +
    "\nRating: " + (rating ? rating.value : "None") +
    "\nInterests: " + (list.join(", ") || "None")
  );
}

function validateForm() {
  if (
    document.querySelectorAll("span:contains('Invalid'), span:contains('Select DOB')").length === 0
  ) return true;
  alert("Please fix errors before submitting!");
  return false;
}
