// Function to validate roll number
function validateRollNumber(rollNumber) {
  const pattern = /^25MX(\d{3})$/;

  const match = rollNumber.match(pattern);

  if (match) {
    const num = parseInt(match[1], 10);
    
    if (num >= 301 && num <= 360) {
      return "✅ Valid roll number.";
    } else {
      return "❌ Invalid roll number: Number out of range (301–360).";
    }
  } else {
    return "❌ Invalid format: Must be like 25MX301 to 25MX360.";
  }
}

const userInput = prompt("Enter your roll number (e.g., 25MX321):");
alert(validateRollNumber(userInput));
