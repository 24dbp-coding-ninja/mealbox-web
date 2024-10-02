/*
기능: 장바구니 페이지 js
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
 */
const products = [
  { name: "상품명1", quantity: 1, price: 13000 },
  { name: "상품명2", quantity: 1, price: 13000 },
];

// DOM 요소 가져오기
const itemList = document.getElementById("itemList");
const totalMoneyElement = document.getElementById("money");

// 총 결제 금액 계산 함수
function updateTotal() {
  let total = 0;
  document.querySelectorAll(".itemInfo3 p").forEach((item) => {
    const priceText = item.textContent.replace(/[^\d]/g, "");
    const price = parseInt(priceText, 10);
    total += price;
  });
  totalMoneyElement.textContent = `${total.toLocaleString()}원`;
}

// 상품 목록 동적으로 생성하는 함수
function addItemsToCart(products) {
  products.forEach((product) => {
    // 새로운 상품 요소 생성
    const item = document.createElement("div");
    item.classList.add("item");

    item.innerHTML = `
          <div class="itemInfo1">
            <img src="../images/cartItem.png" alt="상품 이미지" />
          </div>
          <div class="itemInfo2">
            <p>${product.name}</p>
            <p>상품수량: ${product.quantity}</p>
          </div>
          <div class="itemInfo3" align="right">
            <button class="close-btn">X</button>
            <p>총가격 ${product.price.toLocaleString()}원</p>
          </div>
        `;

    // 닫기 버튼 이벤트 추가
    item.querySelector(".close-btn").addEventListener("click", function () {
      removeItem(item);
    });

    // 상품을 itemList에 추가
    itemList.appendChild(item);
  });

  // 총 금액 업데이트
  updateTotal();
}

// 상품 제거 함수
function removeItem(item) {
  item.remove();
  updateTotal();
}

// 페이지 로드 시 상품을 추가
document.addEventListener("DOMContentLoaded", () => {
  addItemsToCart(products);
});