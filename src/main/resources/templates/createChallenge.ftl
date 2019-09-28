<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Hello</title>
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	    
	    <link rel="stylesheet" type="text/css" href="/css/cosmo.css" />
      <link rel="stylesheet" type="text/css" href="/css/createChallenge.css" />
	</head>
	<body>
		<div class="container">
			<h1>Create Challenge<h1>	
			<div class="row">
				<div class="form-group">
					<label for="title">Title:</label>
					<input type="text" class="form-control" id="title" />
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="description">Description:</label>
					<input type="text" class="form-control" id="description" />
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
			<button>Submit</button>
		</div>
	</body>
</html>