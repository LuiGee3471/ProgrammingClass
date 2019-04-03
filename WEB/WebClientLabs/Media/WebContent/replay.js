const replayBtn = document.querySelector("#replay");

function replaySound() {
  const audio = document.querySelector("audio");
  if (audio === null) {
    return;
  }
  audio.play();
}

function init() {
  replayBtn.addEventListener("click", replaySound);
}

init();
