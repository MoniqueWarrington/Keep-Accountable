import React from 'react';
import './../App.css';

const styleButton = {
    width:'100%',
    height:'100%',
    'border-radius':'25px'
}

const styleImg = {
    width:'100%'
}

const styleJumbotron = {
    padding: '20px', 
    margin:'5px'
}

class HomeStatement extends React.Component{
    render(){
        return(
            <div className="jumbotron" style={styleJumbotron}>
                <div className="row">
                    <div className="col-sm-7">
                        <h1>Keep-Accountable</h1>
                        <h2>
                            Keep track of your goals and invite your friends to keep you motivated and most of all: Accountable!
                        </h2>
                        <br/>
                        <div>				
                            <a href="https://auth.bankengine.nz/banks?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fresponse_type%3Dcode%26client_id%3Dkeep-accountable%26redirect_uri%3Dhttp%253A%252F%252Flocalhost%253A8080%252Fcallback%26scope%3Duserinfo%2520offline_access%2520accounts%2520balance%2520transactions%2520payments%26nonce%3Dnonce%26state%3Dstate%2527">
                                    <button type="submit" 
                                    style={styleButton} className="btn btn-primary info-box bg-custom">Get Started Now!</button>
                            </a>
                        </div>
                    </div>
                    <div className="col-sm-5">
                        <img src="https://assets.entrepreneur.com/content/3x2/2000/20190211153655-GettyImages-1024882748.jpeg?width=1000"
                            style={styleImg}>
                        </img>
                    </div>
                </div>
            </div>
        );
    }
}

export default HomeStatement;