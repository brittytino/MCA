// ===== Employee =====
function addEmployee() {
    const EmpID = document.getElementById("empID").value;
    const Date = document.getElementById("empDate").value;
    const TimeIn = document.getElementById("empTimeIn").value;
    const TimeOut = document.getElementById("empTimeOut").value;

    fetch("/empLogin", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ EmpID, Date, TimeIn, TimeOut })
    }).then(res => res.json()).then(data => alert(data.message));
}

function countEmployee() {
    const date = document.getElementById("checkDate").value;
    fetch(`/empCount/${date}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("empCount").innerText = `Employees logged in after 10AM: ${data.count}`;
        });
}

// ===== Products =====
function addProduct() {
    const ProdID = document.getElementById("prodID").value;
    const Description = document.getElementById("prodDesc").value;
    const Price = document.getElementById("prodPrice").value;
    const Stock = document.getElementById("prodStock").value;

    fetch("/addProduct", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ ProdID, Description, Price, Stock })
    }).then(res => res.json()).then(data => alert(data.message));
}

function getLowStock() {
    fetch("/lowStock")
        .then(res => res.json())
        .then(data => {
            const div = document.getElementById("lowStockList");
            if(data.length === 0) div.innerHTML = "No low stock products.";
            else {
                div.innerHTML = "<ul>" + data.map(p => `<li>${p.ProdID} - ${p.Description} - Stock: ${p.Stock}</li>`).join("") + "</ul>";
            }
        });
}

// ===== Orders =====
function addOrder() {
    const orderID = document.getElementById("orderID").value;
    const itemName = document.getElementById("itemName").value;
    const price = document.getElementById("itemPrice").value;
    const quantity = document.getElementById("itemQty").value;

    fetch("/addOrder", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ orderID, itemName, price, quantity })
    }).then(res => res.json()).then(data => alert(data.message));
}

function showTotalSales() {
    fetch("/totalSales")
        .then(res => res.json())
        .then(data => {
            document.getElementById("totalSales").innerText = `Total Sales: $${data.total}`;
        });
}
