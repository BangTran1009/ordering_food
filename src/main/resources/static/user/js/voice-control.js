// Khởi tạo đối tượng nhận dạng giọng nói
const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
const recognition = new SpeechRecognition();

recognition.lang = 'vi-VI';
// recognition.continuous = true;

recognition.onend = function() {
    recognition.start();
};

recognition.start();

recognition.onresult = function(event) {
    const text = event.results[0][0].transcript;
    const transcript = text.toLowerCase();

    console.log(transcript);
    switch(transcript) {
        case 'về trang chủ':
            window.location.href = '/';
            break;
        case 'đến trang mua sắm':
            window.location.href = '/shop';
            break;
        case 'xem chi tiết sản phẩm':
          window.location.href = '/product-details';
          break;
        case 'xem giỏ hàng':
          window.location.href = '/cart';
          break;
        case 'đến trang đăng nhập':
          window.location.href = '/login';
          break;
        case 'đến trang thanh toán':
          window.location.href = '/checkout';
          break;
        // Thêm các trường hợp khác theo nhu cầu
    }
};
