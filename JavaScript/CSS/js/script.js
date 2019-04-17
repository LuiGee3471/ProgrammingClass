const homepage = document.querySelector(".homepage");
const navbar = document.querySelector(".navbar");
const homeBtnList = document.querySelectorAll(".home");
const loginBtn = document.querySelector(".login");
const signupBtn = document.querySelector(".signup");
const invBtn = document.querySelector(".inv");
const visBtn = document.querySelector(".vis");
const loginPage = document.querySelector(".login-page");
const signUpPage = document.querySelector(".signup-page");

const INVISIBLE = "invisible";
const CURRENT = "current";

function makeInvisible() {
  const current = document.querySelector(".current");
  current.classList.add(INVISIBLE);
  current.classList.remove(CURRENT);
}

function makeVisible(page) {
  setTimeout(function() {
    page.classList.remove(INVISIBLE);
    page.classList.add(CURRENT);
  }, 300);
}

homeBtnList.forEach(homeBtn => {
  homeBtn.addEventListener("click", function() {
    makeInvisible();
    makeVisible(homepage);
  });
});

loginBtn.addEventListener("click", function() {
  makeInvisible();
  makeVisible(loginPage);
});

signupBtn.addEventListener("click", function() {
  makeInvisible();
  makeVisible(signUpPage);
});
