<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Hello</title>
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script src="javascript/createChallenge.js"></script>
	    <link rel="stylesheet" type="text/css" href="/css/cosmo.css" />
      <link rel="stylesheet" type="text/css" href="/css/createChallenge.css" />
	</head>
	<body>
		<div class="container">
			<h1>Challenge Yourself!</h1>
			<p>What do you need to get motivated to do? You'll be much more likely to accomplish your goals if they have consequences...</p>
			<br/>
			<form method="POST" name="challengeFormSubmission" id="createForm">
				<div class="row">
					<div class="form-group">
						<label for="title">Title:</label>
						<input type="text" class="form-control" name="title" id="title"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="description">Description:</label>
						<textarea class="md-textarea form-control" id="description" rows="3"> </textarea>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="amount">Subscription amount:</label>
						<input type="text" class="form-control" id="amount" />
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="cap">Subscription cap:</label>
						<input type="text" class="form-control" id="cap" />
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="image">Image URL:</label>
						<input type="text" class="form-control" id="image" />
					</div>
				</div>
				<div class="row">
					<input type="button" onClick="postFormData()" class="btn btn-lg btn-primary" value="Submit"/>
				</div>
			</form>
		</div>
	</body>
</html>