// Khởi tạo đối tượng nhận dạng giọng nói
const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
const recognition = new SpeechRecognition();

recognition.lang = 'vi-VI';
// recognition.continuous = true;

recognition.onend = function() {
    recognition.start();
};

recognition.start();

const pages = {
    home: FuzzySet(['về trang chủ']),
    shop: FuzzySet(['đến trang mua sắm']),
    cart: FuzzySet(['xem giỏ hàng']),
    login: FuzzySet(['đến trang đăng nhập']),
    checkout: FuzzySet(['đến trang thanh toán']),

    // Danh sách món ăn
    comDuiGa: FuzzySet(['xem món cơm đùi gà']),
    comSuonBiCha: FuzzySet(['xem món cơm sườn bì chả']),
    comSuonCay: FuzzySet(['xem món cơm sườn cây'] , ['xem món cơm sườn cộng']),
};

recognition.onresult = function(event) {
    const text = event.results[0][0].transcript;
    const transcript = text.toLowerCase();

    console.log(transcript);
    for (const [page, fuzzySet] of Object.entries(pages)) {
        const result = fuzzySet.get(transcript);
        if (result && result[0] && result[0][0] > 0.5) {  // kiểm tra xem result và result[0] có tồn tại trước khi truy cập result[0][0]
            if (page === 'comDuiGa') {
                window.location.href = '/shop/product-detail/suon-bi-cha';
            } else if (page === 'comSuonBiCha') {
                window.location.href = '/shop/product-detail/suon-cay';
            } else if (page === 'comSuonCay') {
                window.location.href = '/shop/product-detail/com-dui-ga';
            } else {
                window.location.href = `/${page}`;
            }
            break;
        }
    }
};


