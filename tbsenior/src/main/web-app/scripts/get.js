$(document).ready(function() {
    $.ajax({
        url: "localhost:5000/greeting"
    }).then(function(data) {
       $('#lore').innerText = data.content;
    });
});