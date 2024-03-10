const avatarUpload = document.querySelector('.avatar-upload');
const imageUpload = avatarUpload.querySelector('.image-upload');
const defaultImage = avatarUpload.querySelector('.image-preview');

imageUpload.addEventListener('change', function() {
    const file = this.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', function() {
        defaultImage.src = reader.result;
    });

    reader.readAsDataURL(file);
});