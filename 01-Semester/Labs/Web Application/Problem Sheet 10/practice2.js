function extractDates(text) {
  const dateRegex = /\b\d{2}-[A-Za-z]{3}-\d{4}\b/g;

  const matches = text.match(dateRegex);

  return matches || [];
}
const sampleText = `
  Important dates:
  - Meeting on 11-NOV-2024
  - Submission due 23-dec-2025
  - Review on 07-Jul-2023
  - Another test date: 05-APR-2022
`;

const dates = extractDates(sampleText);
console.log("Extracted Dates:", dates);
