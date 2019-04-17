const homepage = document.querySelector(".homepage");
const navbar = document.querySelector(".navbar");
const home = document.querySelector(".home");
const login = document.querySelector(".login");
const signup = document.querySelector(".signup");
const invBtn = document.querySelector(".inv");
const visBtn = document.querySelector(".vis");

function makeInvisible() {
  const current = document.querySelector(".current");
  current.classList.remove("visible");
  current.classList.add("invisible");
}

function makeVisible(element) {
  const current = document.querySelector(".current");
  current.classList.remove("invisible");
  current.classList.remove("none");
  current.classList.add("visible");
}

invBtn.addEventListener("click", makeInvisible);
visBtn.addEventListener("click", makeVisible);
