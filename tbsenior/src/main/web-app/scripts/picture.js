const getBounce = document.getElementById("getBounce");
const bounce = document.getElementById("bounce");

getBounce.addEventListener('click', () => {
        bounce.src = 'http://localhost:5000/picture';
      });

const upload = document.getElementById("upload")
upload.addEventListener('click', () => {

});

const deleteBounce = document.querySelector("#deleteBounce");

deleteBounce.addEventListener("click", () => {
  $.ajax({
    type: "DELETE",
    url: "http://localhost:5000/picture",
  })
});