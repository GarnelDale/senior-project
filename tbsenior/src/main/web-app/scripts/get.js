const getButton = document.querySelector('#get');

getButton.addEventListener('click', ()=> {
    $.ajax({
        type: "GET",
        url: "http://localhost:5000/story",
        dataType: "JSON"
    }).then((data)=> {
       document.querySelector('#lore').innerText = data.story;
    });
});

const putButton = document.querySelector('#put');

putButton.addEventListener('click', ()=> {
    $.ajax({
        type: "PUT",
        url: "http://localhost:5000/story",
    }).then(()=> {
       document.querySelector('#lore').innerText = "Story File Created";
    });
});

// const postButton = document.querySelector('#post');

// postButton.addEventListener('click', ()=> {
//     $.ajax({
//         type: "POST",
//         url: "http://localhost:5000/story",
//         dataType: "JSON"
//     }).then((data)=> {
//        document.querySelector('#lore').innerText = data.story;
//     });
// });

const deleteButton = document.querySelector('#delete');

deleteButton.addEventListener('click', ()=> {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:5000/story",
    }).then(()=> {
       document.querySelector('#lore').innerText = "Story Deleted";
    });
});