import React, { Component } from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Homepage from './HomePage/HomePage';
import Navbar from './Navbar/Navbar';
import Footer from './Footer/Footer';
import ChallengeView from './ChallengeView/ChallengeView';

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Navbar></Navbar>     
          <Switch>
            <Route exact path='/'component={Homepage}/>
            <Route path='/challenge' component={ChallengeView} />
          </Switch>         
          <Footer></Footer>
        </div>
      </Router>
      
    );
  }
}

export default App;
