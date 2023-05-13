var slideshow = document.getElementById('slideshow');
var images = slideshow.getElementsByTagName('img');
var currentImageIndex = 0;
var intervalTime = 5000;

function nextImage() {
  images[currentImageIndex].classList.remove('active');
  currentImageIndex = (currentImageIndex + 1) % images.length;
  images[currentImageIndex].classList.add('active');
}

images[currentImageIndex].classList.add('active');
setInterval(nextImage, intervalTime);
