<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Subscriber View</title>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>    
	   
		<link rel="stylesheet" type="text/css" href="/css/cosmo.css" />
		 <link rel="stylesheet" type="text/css" href="/css/challengeviewsubscriver.css" />
</head>
<body style="background-color: white;">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary" style="width:100%">
			<h1 class="nav-title" style="color:white">Keep-Accountable</h1>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<div class ="center">
					<ul class="navbar-nav mr-auto">
					<li class="nav-item active space-apart">
						<a class="nav-link" href="#"><h2>Home</h2> <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item space-apart">
						<a class="nav-link" href="#"><h2>Challenges</h2></a>
					</li>
					<li class="nav-item space-apart">
						<a class="nav-link" href="#"><h2>Profile</h2></a>
					</li>
					<li class="nav-item space-apart">
						<a class="nav-link" href="#"><h2>About Us</h2></a>
					</li>
					</ul>
				</div>
				<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2 round-obj" type="text" placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0 round-obj" type="submit">Search</button>
				</form>
			</div>
		</nav>

	
	<div class="container jumbotron">
		<div class="row">
			<div class="challenger-img col-sm-5">
				<img src="https://img1.looper.com/img/gallery/was-jim-halpert-from-the-office-secretly-a-sociopath/intro-1565015060.jpg"
					 style="width:100%">
			</div>
			<div class="challenge-desc col-sm-7">			
				<div class="page-title col-sm-12"><h1>Jim needs to go to the Gym</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus commodo venenatis nibh eu facilisis. Cras ut mi eu ipsum congue suscipit id sit amet eros. Proin et rutrum turpis, non facilisis orci. Pellentesque est mi, semper blandit molestie sit amet, rhoncus in lacus. Ut et elit condimentum tortor mollis congue at ut metus. Maecenas semper justo velit, non tristique lectus aliquet non. Suspendisse placerat convallis dictum. Cras eget lorem sed lectus dictum lacinia eget nec ante. Morbi ultrices lacinia vulputate. Cras commodo a turpis a placerat. Pellentesque rhoncus consectetur aliquam. Suspendisse potenti. Duis et purus ante. Nullam sed ipsum congue, eleifend odio non, mollis ligula.</p>
				</div>				
			</div>
		</div>
		<div class="row">
			<div class="progress-view col-sm-12 jumbotron-smol">
				<h2>5 out of 12 weeks completed</h2>
				<div class="progress">
					<div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
				</div>
				<br/>
			</div>
		</div>
		<div class="row">
			<div class="penalty-view col-sm-4">
				<div style = "width:100%;height:100%;border-radius: 25px;" class="alert alert-danger info-box">
				  <strong>Current Penalty: $45</strong> 
				</div>
			</div>
			<div class="subscriber-amt-view col-sm-4">
				<div style = "width:100%;height:100%;border-radius: 25px;" class="alert alert-primary info-box">
				  <strong>Subscription Amount: $5</strong> 
				</div>
			</div>
			<div class="subscriibe-view col-sm-4">
				<button type="submit" style="width:100%;height:100%;border-radius: 25px;" class="btn btn-primary info-box">Subscribe</button>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<footer class="page-footer font-small blue">
	
	  <!-- Copyright -->
	  <div class="footer-copyright text-center py-3">© 2019 Copyright: keep-accountable.com</a>
	  </div>
	  <!-- Copyright -->
	
	</footer>
	<!-- Footer -->
	
</body>
</html>