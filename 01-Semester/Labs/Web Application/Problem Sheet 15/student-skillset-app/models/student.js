// models/student.js
const mongoose = require('mongoose');

// Create a schema for student details
const studentSchema = new mongoose.Schema({
  rollnumber: { type: Number, required: true, unique: true },
  name: { type: String, required: true },
  guardianPhone: { type: String, default: null },
  skills: [String]  // Skills are stored as an array of strings
});

const Student = mongoose.model('Student', studentSchema);
module.exports = Student;
