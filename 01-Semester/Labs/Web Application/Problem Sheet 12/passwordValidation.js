const form = document.getElementById('passwordForm');
const message = document.getElementById('message');

form.addEventListener('submit', function(event) {
    event.preventDefault();
    const password = form.password.value;
    if (validatePassword(password)) {
        message.textContent = "Password is valid.";
        message.style.color = "green";
    } else {
        message.textContent = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number.";
        message.style.color = "red";
    }
});

function validatePassword(password) {
    const minLength = 8;
    const hasUpperCase = /[A-Z]/.test(password);
    const hasLowerCase = /[a-z]/.test(password);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
    const hasNumber = /\d/.test(password);
    return password.length >= minLength && hasUpperCase && hasLowerCase && hasSpecialChar && hasNumber;
}
