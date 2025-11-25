const express = require("express");
const fs = require("fs");
const path = require("path");
const bodyParser = require("body-parser");

const app = express();
const PORT = 3000;

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, "public")));

const empFile = path.join(__dirname, "data", "EmpLogin.txt");
const prodFile = path.join(__dirname, "data", "Prod.csv");
const ordersFile = path.join(__dirname, "data", "Orders.json");

// ======== Problem 1: Employee Login ========

// Add employee login
app.post("/empLogin", (req, res) => {
    const { EmpID, Date, TimeIn, TimeOut } = req.body;
    let empArr = [];
    if (fs.existsSync(empFile)) {
        const data = fs.readFileSync(empFile, "utf-8");
        if(data.trim() !== "") empArr = JSON.parse(data);
    }
    empArr.push({ EmpID, Date, TimeIn, TimeOut });
    fs.writeFileSync(empFile, JSON.stringify(empArr, null, 2));
    res.json({ message: "Employee login added!" });
});

// Count employees after 10AM
app.get("/empCount/:date", (req, res) => {
    const date = req.params.date;
    if (!fs.existsSync(empFile)) return res.json({ count: 0 });
    const data = fs.readFileSync(empFile, "utf-8");
    if(data.trim() === "") return res.json({ count: 0 });
    const empArr = JSON.parse(data);
    const count = empArr.filter(emp => emp.Date === date && parseInt(emp.TimeIn.split(":")[0]) >= 10).length;
    res.json({ count });
});

// ======== Problem 2: Products ========

// Add product
app.post("/addProduct", (req, res) => {
    const { ProdID, Description, Price, Stock } = req.body;
    const header = "ProdID,Description,Price,Stock\n";
    const row = `${ProdID},${Description},${Price},${Stock}\n`;
    if (!fs.existsSync(prodFile)) {
        fs.writeFileSync(prodFile, header + row);
    } else {
        fs.appendFileSync(prodFile, row);
    }
    res.json({ message: "Product added!" });
});

// Get low stock products
app.get("/lowStock", (req, res) => {
    if (!fs.existsSync(prodFile)) return res.json([]);
    const lines = fs.readFileSync(prodFile, "utf-8").split("\n").slice(1);
    const lowStock = lines.filter(l => l.trim() !== "").map(line => {
        const [ProdID, Description, Price, Stock] = line.split(",");
        return { ProdID, Description, Price, Stock: parseInt(Stock) };
    }).filter(p => p.Stock < 10);
    res.json(lowStock);
});

// Update product stock
app.post("/updateStock", (req, res) => {
    const { ProdID, newStock } = req.body;
    if (!fs.existsSync(prodFile)) return res.json({ message: "No products found." });
    const lines = fs.readFileSync(prodFile, "utf-8").split("\n");
    const updatedLines = lines.map(line => {
        if (line.startsWith("ProdID") || line.trim() === "") return line;
        const parts = line.split(",");
        if (parts[0] === ProdID) parts[3] = newStock;
        return parts.join(",");
    });
    fs.writeFileSync(prodFile, updatedLines.join("\n"));
    res.json({ message: "Stock updated!" });
});

// ======== Problem 3: Food Orders ========

// Add order
app.post("/addOrder", (req, res) => {
    const { orderID, itemName, price, quantity } = req.body;
    let orders = [];
    if (fs.existsSync(ordersFile)) {
        const data = fs.readFileSync(ordersFile, "utf-8");
        if(data.trim() !== "") orders = JSON.parse(data);
    }
    orders.push({ orderID, itemName, price: parseFloat(price), quantity: parseInt(quantity) });
    fs.writeFileSync(ordersFile, JSON.stringify(orders, null, 2));
    res.json({ message: "Order added!" });
});

// Total sales
app.get("/totalSales", (req, res) => {
    if (!fs.existsSync(ordersFile)) return res.json({ total: 0 });
    const orders = JSON.parse(fs.readFileSync(ordersFile, "utf-8"));
    const total = orders.reduce((sum, o) => sum + o.price * o.quantity, 0);
    res.json({ total });
});

app.listen(PORT, () => console.log(`Server running at http://localhost:${PORT}`));
