const getBounce = document.getElementById("getBounce");
const bounce = document.getElementById("bounce");

getBounce.addEventListener('click', () => {
        bounce.src = "http://localhost:5000/picture";
      });

const upload = document.getElementById("uploadForm");
const uploadGIF = document.getElementById("uploadGIF");
upload.addEventListener('submit', (event) => {
  const formData = new FormData(uploadGIF);
  $.ajax({
    type: "POST",
    url: "http://localhost:5000/picture",
    contentType: 'multipart/form-data',
    data: formData,
  })
  event.preventDefault();
});

const deleteBounce = document.querySelector("#deleteBounce");

deleteBounce.addEventListener("click", () => {
  $.ajax({
    type: "DELETE",
    url: "http://localhost:5000/picture",
  })
});