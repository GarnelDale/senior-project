// Courtesy of GeeksForGeeks
function randomNumber(min, max) {
    return Math.round(Math.random() * (max - min) + min);
}

const getData = document.getElementById("galaxy");
const scroll = document.getElementById("scroll");

getData.addEventListener("click", () => {
    $.ajax({
      type: "GET",
      url: "http://localhost:5000/third-party",
    }).then((data) => {
      scroll.innerText = data.results[randomNumber(0,5)].opening_crawl;
    });
  });

const starships = document.getElementById("shipSearch");
const details = document.getElementById("details");

ship.addEventListener("click", ()=> {
    console.log(starships.value);
    $.ajax({
        type: "GET",
        url: "http://localhost:5000/third-party/{ship}",
        data: starships.value,
    }).then((data) => {
        details.innerText = data;
    })
})