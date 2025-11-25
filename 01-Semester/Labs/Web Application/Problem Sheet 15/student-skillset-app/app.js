// app.js
const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const Student = require('./models/student');
const path = require('path');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.set('view engine', 'ejs');
app.use(express.static(path.join(__dirname, "public")));

// Connect to MongoDB
mongoose.connect('mongodb://localhost:27017/studentDB', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('MongoDB connected'))
  .catch(err => console.log(err));

// Home Route
app.get('/', (req, res) => {
  res.render('index');
});

// Add Student
app.get('/addStudent', (req, res) => {
  res.render('addStudent');
});

app.post('/addStudent', async (req, res) => {
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
app.get('/deleteStudent/:rollnumber', async (req, res) => {
  try {
    await Student.findOneAndDelete({ rollnumber: req.params.rollnumber });
    res.redirect('/');
  } catch (err) {
    res.send('Error: ' + err);
  }
});

// Update Student Skills
app.get('/updateStudent', (req, res) => {
  res.render('updateStudent');
});

app.post('/updateStudent', async (req, res) => {
  const { rollnumber, skills } = req.body;
  try {
    await Student.findOneAndUpdate({ rollnumber }, { $set: { skills: skills.split(',') } });
    res.redirect('/');
  } catch (err) {
    res.send('Error: ' + err);
  }
});

// Display Student by Roll Number
app.get('/displayStudent/:rollnumber', async (req, res) => {
  const student = await Student.findOne({ rollnumber: req.params.rollnumber });
  if (!student) {
    return res.send('Student not found');
  }
  res.render('displayStudent', { student });
});

// Search Students by Skillset
app.get('/skillStudent', (req, res) => {
  res.render('skillStudent');
});

app.post('/skillStudent', async (req, res) => {
  const { skill } = req.body;
  const students = await Student.find({ skills: skill });
  res.render('displaySkills', { students });
});

// Display All Day Scholars
app.get('/displayAll', async (req, res) => {
  const students = await Student.find({ guardianPhone: null });
  res.render('displayAll', { students });
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
