// routes/studentRoutes.js
const express = require('express');
const Student = require('../models/student');
const router = express.Router();

// Home Route
router.get('/', (req, res) => {
  res.render('index');
});

// Add Student
router.get('/addStudent', (req, res) => {
  res.render('addStudent');
});

router.post('/addStudent', async (req, res) => {
  const { rollnumber, name, guardianPhone, skills } = req.body;
  try {
    const newStudent = new Student({ rollnumber, name, guardianPhone, skills });
    await newStudent.save();
    res.redirect('/');
  } catch (err) {
    res.send('Error: ' + err);
  }
});

// Delete Student
router.get('/deleteStudent/:rollnumber', async (req, res) => {
  try {
    await Student.findOneAndDelete({ rollnumber: req.params.rollnumber });
    res.redirect('/');
  } catch (err) {
    res.send('Error: ' + err);
  }
});

// Update Student Skills
router.get('/updateStudent', (req, res) => {
  res.render('updateStudent');
});

router.post('/updateStudent', async (req, res) => {
  const { rollnumber, skills } = req.body;
  try {
    await Student.findOneAndUpdate({ rollnumber }, { $set: { skills: skills.split(',') } });
    res.redirect('/');
  } catch (err) {
    res.send('Error: ' + err);
  }
});

// Display Student by Roll Number
router.get('/displayStudent/:rollnumber', async (req, res) => {
  const student = await Student.findOne({ rollnumber: req.params.rollnumber });
  if (!student) {
    return res.send('Student not found');
  }
  res.render('displayStudent', { student });
});

// Search Students by Skillset
router.get('/skillStudent', (req, res) => {
  res.render('skillStudent');
});

router.post('/skillStudent', async (req, res) => {
  const { skill } = req.body;
  const students = await Student.find({ skills: skill });
  res.render('displaySkills', { students });
});

// Display All Day Scholars
router.get('/displayAll', async (req, res) => {
  const students = await Student.find({ guardianPhone: null });
  res.render('displayAll', { students });
});

module.exports = router;
