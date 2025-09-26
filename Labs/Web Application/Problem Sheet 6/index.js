// Select necessary elements
const invoiceForm = document.getElementById('invoiceForm');
const addRowBtn = document.getElementById('addRowBtn');
const itemsTable = document.getElementById('itemsTable').getElementsByTagName('tbody')[0];
const grandTotalElement = document.getElementById('grandTotal');
const gstElement = document.getElementById('gst');
const finalAmountElement = document.getElementById('finalAmount');

// Function to calculate the subtotal for each row
function calculateSubtotal(row) {
    const quantity = row.querySelector('.quantity').value;
    const price = row.querySelector('.price').value;
    const subtotal = quantity * price;
    row.querySelector('.subtotal').value = subtotal.toFixed(2);
    updateTotals();
}

// Function to update grand total, GST, and final amount
function updateTotals() {
    let grandTotal = 0;

    // Loop through each row and sum up subtotals
    document.querySelectorAll('.item-row').forEach(row => {
        const subtotal = parseFloat(row.querySelector('.subtotal').value) || 0;
        grandTotal += subtotal;
    });

    // GST calculation (18% of Grand Total)
    const gst = grandTotal * 0.18;
    const finalAmount = grandTotal + gst;

    // Display the totals
    grandTotalElement.textContent = grandTotal.toFixed(2);
    gstElement.textContent = gst.toFixed(2);
    finalAmountElement.textContent = finalAmount.toFixed(2);
}

// Function to handle adding a new row
addRowBtn.addEventListener('click', () => {
    const newRow = document.createElement('tr');
    newRow.classList.add('item-row');
    
    newRow.innerHTML = `
        <td><input type="text" class="item-name" placeholder="Item Name"></td>
        <td><input type="number" class="quantity" value="1" min="1" required placeholder="Quantity"></td>
        <td><input type="number" class="price" value="10" min="0" required placeholder="Price per unit"></td>
        <td><input type="text" class="subtotal" disabled placeholder="Subtotal" readonly></td>
        <td><button type="button" class="remove-btn">Remove</button></td>
    `;
    
    // Add the new row to the table
    itemsTable.appendChild(newRow);

    // Add event listeners to the new row's inputs
    newRow.querySelector('.quantity').addEventListener('input', () => calculateSubtotal(newRow));
    newRow.querySelector('.price').addEventListener('input', () => calculateSubtotal(newRow));
    newRow.querySelector('.remove-btn').addEventListener('click', () => newRow.remove());

    // Recalculate totals
    calculateSubtotal(newRow);
});

// Event listener for input changes in quantity or price fields
document.querySelectorAll('.item-row .quantity, .item-row .price').forEach(input => {
    input.addEventListener('input', function() {
        const row = input.closest('.item-row');
        calculateSubtotal(row);
    });
});

// Submit the form (optional feature)
invoiceForm.addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Invoice Generated!');
});
