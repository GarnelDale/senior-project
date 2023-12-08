const getButton = document.querySelector("#get");
const lore = document.querySelector("#lore");

getButton.addEventListener("click", () => {
  $.ajax({
    type: "GET",
    url: "http://localhost:5000/story",
    dataType: "JSON",
  }).then((data) => {
    lore.innerText = data.story;
  });
});

const putButton = document.querySelector("#put");

putButton.addEventListener("click", () => {
  $.ajax({
    type: "PUT",
    url: "http://localhost:5000/story",
  }).then(() => {
    lore.innerText = "Story File Created";
  });
});

const postButton = document.querySelector("#post");

postButton.addEventListener("click", () => {
  let content = new Object();
  content.story = $("#write").val();

  $.ajax({
    type: "POST",
    url: "http://localhost:5000/story",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(content),
    statusCode: {
      201: () => {
        lore.innerText = "Story Updated";
      },
    },
  });
});

const deleteButton = document.querySelector("#delete");

deleteButton.addEventListener("click", () => {
  $.ajax({
    type: "DELETE",
    url: "http://localhost:5000/story",
  }).then(() => {
    lore.innerText = "Story Deleted";
  });
});
