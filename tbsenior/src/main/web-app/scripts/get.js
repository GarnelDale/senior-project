$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:5000/story",
        dataType: "JSON"
    }).then(function(data) {
       document.querySelector('#lore').innerText = data.story;
    });
});