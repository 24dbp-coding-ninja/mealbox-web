// 현재 선택된 제품 ID
let currentProductId = 'gobdoritang';

// 상품 정보를 관리하는 객체
const products = {
    gobdoritang: {
        name: "곱도리탕",
        image: "../img/gobdoritang.png",
        price: 13000,
        rating: {
            stars: "⭐️⭐️⭐️⭐️☆",
            score: 4.0
        },
        description: "곱도리탕"
    },
    strawberrysiru: {
        name: "딸기시루",
        image: "../img/gobdoritang.png",
        price: 15000,
        rating: {
            stars: "⭐️⭐️⭐️⭐️⭐️",
            score: 5.0
        },
        description: "딸기시루"
    }
    // , 다른 음식 추가하면 됨~
};

// 특정 제품의 정보를 가져오는 함수
function getProduct(productId) {
    return products[productId];
}

// 특정 제품의 평균 평점을 서버로부터 받아오는 함수
function fetchProductRating(productId) {
    return fetch(`ReviewServlet?productId=${productId}`)
        .then(response => response.json())
        .then(data => {
            const averageScore = data.averageScore;
            return averageScore;
        })
        .catch(error => {
            console.error('Error fetching product rating:', error);
            return 0; // 오류 발생 시 0점으로 처리
        });
}

// 별점 계산 함수
function calculateStars(averageScore) {
    const fullStars = Math.floor(averageScore); // 꽉 찬 별 개수
    const halfStar = averageScore % 1 >= 0.5 ? 1 : 0; // 반 별 여부
    const emptyStars = 5 - fullStars - halfStar; // 빈 별 개수

    let stars = '⭐️'.repeat(fullStars); // 꽉 찬 별 추가
    if (halfStar) {
        stars += '⭐️'; // 반 별 추가
    }
    stars += '☆'.repeat(emptyStars); // 빈 별 추가

    return stars;
}

// DOM 요소를 업데이트하는 함수
function displayProductDetails(productId) {
    const product = getProduct(productId);
    console.log(product); // 확인하려고 추가한 코드라서 신경 안 써두 됨!!

     // 서버에서 평균 평점 받아오기
     fetchProductRating(productId).then(averageScore => {
        // 동적으로 별점과 평균 점수 업데이트
        document.getElementById("display_rating_stars").textContent = calculateStars(averageScore);
        document.getElementById("product_rating_score").textContent = averageScore.toFixed(1);
    });

    // 이미지, 이름, 가격, 설명, 평점 등을 동적으로 업데이트
    document.getElementById("product_image").src = product.image;
    document.getElementById("product_image").alt = product.name;
    document.getElementById("product_name").textContent = product.name;
    document.getElementById("product_price").textContent = product.price.toLocaleString() + "원";
    document.getElementById("product_description").textContent = product.description;
    //document.getElementById("display_rating_stars").textContent = product.rating.stars;
    //document.getElementById("product_rating_score").textContent = product.rating.score.toFixed(1);
    document.getElementById("how_much").textContent = product.price.toLocaleString() + "원";
    document.getElementById("total_price").textContent = product.price.toLocaleString() + "원";
}

// 수량에 따라 가격을 계산하는 함수
function updateTotalPrice(quantity) {
    const product = getProduct(currentProductId);
    const totalPrice = product.price * quantity;
    document.getElementById("total_price").textContent = totalPrice.toLocaleString() + "원";
    document.getElementById("how_much").textContent = totalPrice.toLocaleString() + "원";
}

// 수량 변경 +-버튼 이벤트
// +
document.querySelector(".increase").addEventListener("click", function() {
    const quantityInput = document.getElementById("quantity");
    quantityInput.value = parseInt(quantityInput.value) + 1;
    updateTotalPrice(quantityInput.value);
});
// -
document.querySelector(".decrease").addEventListener("click", function() {
    const quantityInput = document.getElementById("quantity");
    if (quantityInput.value > 1) {
        quantityInput.value = parseInt(quantityInput.value) - 1;
        updateTotalPrice(quantityInput.value);
    }
});

// 초기화 시 상품 정보를 표시하고 총 가격을 계산
function init() {
    displayProductDetails(currentProductId);
}

// 페이지 초기화
window.onload = init;