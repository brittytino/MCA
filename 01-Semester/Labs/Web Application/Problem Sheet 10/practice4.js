const voterIdPatterns = {
  india: /^[A-Z]{4}\d{6}$/,         
  usa: /^\d{3}-\d{2}-\d{4}$/,       
  uk: /^\d{8}$/                     
};

function validateVoterID(country, voterID) {
  const pattern = voterIdPatterns[country.toLowerCase()];
  if (!pattern) {
    return "Country not supported.";
  }
  return pattern.test(voterID)
    ? "Valid Voter ID"
    : "Invalid Voter ID";
}

console.log(validateVoterID("india", "ABCZ123456"));  
console.log(validateVoterID("usa", "123-45-6789"));    
console.log(validateVoterID("uk", "12345678"));        

console.log(validateVoterID("india", "AB12345678"));   
console.log(validateVoterID("usa", "123456789"));      
console.log(validateVoterID("uk", "1234567A"));       
