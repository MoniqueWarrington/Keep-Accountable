import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Homepage from './HomePage/HomePage';
import Navbar from './Navbar/Navbar';
import Footer from './Footer/Footer';

class App extends Component {
  render() {
    return (
      <div className="App">
          <Navbar></Navbar>     
          <Homepage></Homepage>
          <Footer></Footer>
      </div>
    );
  }
}

export default App;
