let input = document.querySelector(".search_input");
let btn = document.querySelector(".search_button");
let parent = document.querySelector(".search_container");
let list = document.querySelector(".list"); 

btn.addEventListener("click", () => {
  parent.classList.toggle("active");
  input.focus();
  list.classList.toggle("active");
});
