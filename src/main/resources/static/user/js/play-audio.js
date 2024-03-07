// Tạo các đối tượng Audio
let homeAudio = new Audio('https://lta10022002.github.io/food-ordering/home-audio.mp3');
let productDetailsAudio = new Audio('https://lta10022002.github.io/food-ordering/suon-cop-lech-audio.mp3');

// Hàm để phát âm thanh tương ứng với từng trang
function playAudioForPage(page) {
    switch (page) {
        case '/':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    homeAudio.play();
                }
            }
            break;
        case '/product-details':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    productDetailsAudio.play();
                }
            }
            break;
        default:
            console.log('No audio for this page');
    }
}

// Gọi hàm playAudioForPage khi trang được tải
playAudioForPage(window.location.pathname);