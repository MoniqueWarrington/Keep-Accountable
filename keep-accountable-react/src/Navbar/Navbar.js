import React from 'react';

class Navbar extends React.Component{
    render(){
        return(
            <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
                <h1 class="nav-title" >Keep-Accountable</h1>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarColor01">
                    <div class ="center">
                        <ul class="navbar-nav mr-auto">
                        <li class="nav-item active space-apart">
                            <a class="nav-link" href=""><h2>Home</h2> <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item space-apart">
                            <a class="nav-link" href="#"><h2>Goals</h2></a>
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
                    <input class="form-control mr-sm-2 round-obj" type="text" placeholder="Search"></input>
                    <button class="btn btn-secondary my-2 my-sm-0 round-obj" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        );
    }
}

export default Navbar;