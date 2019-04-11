const toDoForm = document.querySelector(".js-toDoForm");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.querySelector(".js-toDoList");

const TODOS_LS = "toDos";

let toDos = [];

function saveToDos() {
  localStorage.setItem(TODOS_LS, JSON.stringify(toDos));
}
function deleteToDo(event) {
  const btn = event.target;
  const liToRemove = btn.parentNode;
  toDoList.removeChild(liToRemove);
  const cleanToDos = toDos.filter(toDo => toDo.id !== Number(liToRemove.id));
  toDos = cleanToDos;
  saveToDos();
}

function toggleBorder(event) {
  const btn = event.target;
  btn.classList.toggle("borderhidden");
}

function paintToDo(text) {
  const li = document.createElement("li");
  const delBtn = document.createElement("button");
  const h2 = document.createElement("h2");
  const newId = toDos.length + 1;
  const x = document.createElement("img");
  x.setAttribute("src", "images/X.png");
  delBtn.appendChild(x);
  delBtn.classList.add("borderhidden");
  delBtn.addEventListener("click", deleteToDo);
  delBtn.addEventListener("mouseenter", toggleBorder);
  delBtn.addEventListener("mouseleave", toggleBorder);
  h2.innerText = text;
  li.appendChild(h2);
  li.appendChild(delBtn);
  li.id = newId;
  toDoList.appendChild(li);
  const toDoObj = {
    text,
    id: newId,
  };
  toDos.push(toDoObj);
  saveToDos();
}

function handleSubmit(event) {
  event.preventDefault();
  const currentValue = toDoInput.value;
  paintToDo(currentValue);
  toDoInput.value = "";
}

function loadToDos() {
  const loadedToDos = localStorage.getItem(TODOS_LS);
  if (loadedToDos !== null) {
    const parsedToDos = JSON.parse(loadedToDos);
    parsedToDos.forEach((toDo) => {
      paintToDo(toDo.text);
    });
  }
}

function init() {
  loadToDos();
  toDoForm.addEventListener("submit", handleSubmit);
}

init();
