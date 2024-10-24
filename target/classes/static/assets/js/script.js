const formCart = document.querySelector("[form-cart]");
var listBook = [];

// Lấy dữ liệu từ Local Storage khi trang tải
const storedBooks = localStorage.getItem("listBook");
if (storedBooks) {
    listBook = JSON.parse(storedBooks);
}

// Hiển thị số lượng giỏ hàng khi trang tải
updateCartCount();

if (formCart) {
    formCart.addEventListener("submit", (e) => {
        e.preventDefault();
        const quantity = parseInt(document.querySelector("[quantity]").value);
        const price = parseFloat(document.querySelector("[price]").value); // Convert to float
        const image = document.querySelector("[image]").src;
        const bookId = document.querySelector("[bookId]").value;
        const book = {
            quantity: quantity,
            price: price,
            image: image,
            bookId : bookId,
        };

        // Kiểm tra xem sách đã có trong danh sách hay chưa
        const existingBookIndex = listBook.findIndex(b => b.bookId === book.bookId);

        if (existingBookIndex !== -1) {
            // Cập nhật số lượng nếu sách đã có trong danh sách
            listBook[existingBookIndex].quantity += book.quantity;
        } else {
            // Thêm sách mới vào danh sách
            listBook.push(book);
        }

        // Lưu danh sách vào Local Storage
        localStorage.setItem("listBook", JSON.stringify(listBook));

        // Hiển thị chuỗi JSON trên console
        console.log(JSON.stringify(book));

        // Cập nhật số lượng giỏ hàng
        updateCartCount();

        // Hiển thị lại sách trong giỏ hàng
        displayBooks();
    });
}

// Hàm để hiển thị sách từ Local Storage (ví dụ: hiển thị sách trên trang)
function displayBooks() {
    const booksContainer = document.querySelector("[books-container]"); // Giả sử có phần tử này để hiển thị sách
    const cartItems = document.getElementById("cart-items");
    const totalPriceElement = document.getElementById("total-price");

    let totalPrice = 0;

    if (booksContainer) {
        booksContainer.innerHTML = ''; // Xóa nội dung cũ nếu có
    }
    if (cartItems) {
        cartItems.innerHTML = ''; // Xóa nội dung cũ nếu có
    }

    listBook.forEach((book, index) => {
        totalPrice += book.quantity * book.price;

        if (booksContainer) {
            const bookElement = document.createElement('div');
            bookElement.innerHTML = `
                <img src="${book.image}" alt="Book Image">
                <p>Quantity: ${book.quantity}</p>
                <p>Price: ${book.price}</p>
            `;
            booksContainer.appendChild(bookElement);
        }

        if (cartItems) {
            const cartRow = document.createElement('tr');
            cartRow.innerHTML = `
                <td style="display: flex; align-items: center;"><img style="width: 70px" src="${book.image}" alt="Book Image" style="width: 50px; height: auto;"></td>
                <td>$ ${book.price}</td>
                <td>
                    <input style="width: 50px; outline: none; "  type="number" value="${book.quantity}" min="1" class="quantity-input" data-index="${index}">
                </td>
                <td><div style="cursor: pointer;" class="delete-button" data-index="${index}">Xóa</div></td>
            `;
            cartItems.appendChild(cartRow);
        }
    });

    if (totalPriceElement) {
        totalPriceElement.textContent = totalPrice.toFixed(2);
    }

    // Add event listeners to delete buttons
    const deleteButtons = document.querySelectorAll(".delete-button");
    deleteButtons.forEach(button => {
        button.addEventListener("click", (e) => {
            const index = e.target.getAttribute("data-index");
            deleteBook(index);
        });
    });

    // Add event listeners to quantity inputs
    const quantityInputs = document.querySelectorAll(".quantity-input");
    quantityInputs.forEach(input => {
        input.addEventListener("change", (e) => {
            const index = e.target.getAttribute("data-index");
            const newQuantity = parseInt(e.target.value);
            updateQuantity(index, newQuantity);
        });
    });
}

// Hàm để cập nhật số lượng giỏ hàng
function updateCartCount() {
    const cartCountElement = document.getElementById("cart-count");
    if (cartCountElement) {
        cartCountElement.textContent = listBook.length;
    }
}

// Hàm để xóa sách khỏi giỏ hàng
function deleteBook(index) {
    listBook.splice(index, 1);

    // Lưu danh sách vào Local Storage
    localStorage.setItem("listBook", JSON.stringify(listBook));

    // Cập nhật số lượng giỏ hàng
    updateCartCount();

    // Hiển thị lại sách trong giỏ hàng
    displayBooks();
}

// Hàm để cập nhật số lượng sách trong giỏ hàng
function updateQuantity(index, newQuantity) {
    if (newQuantity < 1) {
        newQuantity = 1; // Không cho phép số lượng dưới 1
    }
    listBook[index].quantity = newQuantity;

    // Lưu danh sách vào Local Storage
    localStorage.setItem("listBook", JSON.stringify(listBook));

    // Cập nhật số lượng giỏ hàng
    updateCartCount();

    // Hiển thị lại sách trong giỏ hàng
    displayBooks();
}

// Gọi hàm hiển thị sách khi trang tải
displayBooks();
