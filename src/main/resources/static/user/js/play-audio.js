// Tạo các đối tượng Audio
let homeAudio = new Audio('https://lta10022002.github.io/food-ordering/home-audio.mp3');
let suon_bi_cha = new Audio('https://res.cloudinary.com/dggnkthlu/video/upload/v1710250151/audio/ubraw8rcbehgtzqvmgdl.mp3');
let suon_cay = new Audio('https://res.cloudinary.com/dggnkthlu/video/upload/v1710313769/audio/gbeg0thkajj03utrh5vo.mp3');
let dui_ga = new Audio('https://res.cloudinary.com/dggnkthlu/video/upload/v1710403509/audio/vr9dtroqudlmz1a7iwhr.mp3');


// Hàm để phát âm thanh tương ứng với từng trang
function playAudioForPage(page) {
    switch (page) {
        case '/home':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    homeAudio.play();
                }
            }
            break;
        case '/shop/product-detail/com-dui-ga':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    dui_ga.play();
                }
            }
            break;
        case '/shop/product-detail/suon-bi-cha':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    suon_bi_cha.play();
                }
            }
            break;
        case '/shop/product-detail/suon-cay':
            document.body.onkeyup = function(e) {
                if (e.keyCode == 32) {
                    suon_cay.play();
                }
            }
            break;
        default:
            console.log('No audio for this page');
    }
}

// Gọi hàm playAudioForPage khi trang được tải
playAudioForPage(window.location.pathname);