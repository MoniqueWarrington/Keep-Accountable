
function postFormData() {
  postData({
    title: document.getElementById('title').value,
    description: document.getElementById('description').value,
    subscriptionAmount: document.getElementById('amount').value,
    subscriptionCap: document.getElementById('cap').value,
    imageUrl: document.getElementById('image').value,
    challengePercentage: 0,
    challengeProgress: 0,
    challengeCap: 100,
    challengeUnits: "Weeks"
  });

}

function postData(formData) {
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
      console.log(this);
  }

  xhr.open('POST', '/createChallenge', true);
  xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
  xhr.send(JSON.stringify(formData));
}


