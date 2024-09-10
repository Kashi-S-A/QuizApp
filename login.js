let form = document.querySelector("form");
let userName = document.querySelectorAll("input")[0];
let password = document.querySelectorAll("input")[1];
let euser = document.querySelectorAll("span")[0];
let epass = document.querySelectorAll("span")[1];
let eform = document.querySelectorAll("span")[2];



form.addEventListener("submit", async (e) => {
e.preventDefault()
  euser.innerHTML = "";
  epass.innerHTML = "";
  eform.innerHTML = "";
  


if (userName.value == "" && password.value == "") {
  euser.innerHTML = "*enter the email or mobile number";
  epass.innerHTML = "*Enter the password";
  e.preventDefault();
} else if (userName.value == "") {
  euser.innerHTML = "*enter the email or mobile number";
  e.preventDefault();
} else if (password.value == "") {
  epass.innerHTML = "*Enter the password";
  e.preventDefault();
} 

  let dataFromServer=await fetch('http://localhost:8080/quiz/users/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      email: userName.value,
      password: password.value,
    }),
  })
let data=await dataFromServer.json()
console.log(data);

if (data.user) {
  alert("welcome to the page");
  window.location.href="./quiz.html"

} else {
  eform.innerHTML = "Match not found";
  e.preventDefault();
}







  
  // let dataFromStorage = JSON.parse(localStorage.getItem("details"));
  
  // console.log(dataFromStorage);


  //matching login details


});

let h3 = document.querySelector("h3");

h3.addEventListener("click", () => {
  if (h3.innerHTML == "show") {
    password.type = "text";
    h3.innerHTML = "hide";
  } else {
    h3.innerHTML = "show";
    password.type = "password";
  }
});
