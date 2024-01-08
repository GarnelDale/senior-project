const getBounce = document.getElementById("getBounce");
const bounce = document.getElementById("bounce");

getBounce.addEventListener('click', () => {
        bounce.src = "http://localhost:5000/picture";
      });

const upload = document.getElementById("uploadForm");
const uploadGIF = document.getElementById("uploadGIF");
addEventListener('submit', (event) => {
  console.log(upload);
  const formData = new FormData(upload);
  console.log(...formData);
  $.ajax({
    type: "POST",
    url: "http://localhost:5000/picture",
    contentType: false,
    data: formData,
    processData: false,
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