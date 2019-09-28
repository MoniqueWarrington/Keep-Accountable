
function postFormData() {
  postData({
    title: document.getElementById('title').value,
    description: document.getElementById('description').value,
    subscriptionAmount: document.getElementById('subscriptionAmount').value,
    subscriptionCap: document.getElementById('subscriptionCap').value,
    imageUrl: document.getElementById('imageUrl').value,
    challengePercentage: 0,
    challengeProgress: 0,
    challengeCap: 100,
    challengeUnits: "Weeks",
    penaltyAmount: 50,
  });

}

function postData(formData) {
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if(this.readyState == 4) {
      var response = JSON.parse(this.response);
      alert("Challenge successfully created");
      window.location.replace('/'+response.id);
    }
  }

  xhr.open('POST', '/challenge', true);
  xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
  xhr.send(JSON.stringify(formData));
}


