import React from 'react';
import './../App123.css';


const styleJumbotron = {
    padding: '20px', 
    margin:'5px'
}

const styleText = {
    'text-align': 'left'
}

class ChallengeView extends React.Component{

    styleProgressBar = {}
     constructor(){
        super();
        this.styleProgressBar = {width:'10%'};
    }

    render(){
    return(
            <div class="container jumbotron">
                <div class="row">
                    <div class="challenger-img thumbnail col-sm-5">
                        <img class ="img-thumbnail" src="https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg"></img>
                    </div>
                    <div class="challenge-desc col-sm-7" style = {styleText}>			
                        <div class="page-title col-sm-12">
                            <h1>Going to the gym for 20 weeks straight</h1>
                            <p>auirfharihaiuer iuaghaiuerghaeiug  uauhga  auigaiuegh iurghaiperg iuuiuag  aipurgh  apuehga   a89g ae r aiupr a  pao gih </p>
                        </div>				
                    </div>
                </div>
                <div class="row">
                    <div class="progress-view col-sm-12 jumbotron-smol">
                        <h2>12 out of 20 weeks completed</h2>
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" style={this.styleProgressBar} aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <br/>
                    </div>
                </div>
                <div class="row">
                    <div class="penalty-view col-sm-4">
                        <div class="alert alert-danger info-box">
                        <strong>Current Penalty: $ 50</strong>
                        </div>
                    </div>
                    <div class="subscriber-amt-view col-sm-4">
                        <div  class="alert alert-primary info-box">
                        <strong>Subscription Amount: $ 5</strong> 
                        </div>
                    </div>
                    <div class="subscriibe-view col-sm-4">
                        <input type="button" onClick="subscribe('${id}');" class="btn btn-primary info-box bg-custom" value="Subscribe" />
                    </div>
                </div>
            </div>
        );
    }
}

export default ChallengeView;