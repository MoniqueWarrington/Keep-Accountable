import React from 'react';


class CardDisplay extends React.Component{
    cardArray = [];

    cardData1 = {title: 1,
        desc: 1,
        penalty: 1};    
    cardData2 = {title: 2,
        desc: 2,
        penalty: 2};
    cardData3 = {title: 3,
        desc: 3,
        penalty: 3};
    
    constructor(){
        super();
        this.cardArray = [this.cardData1,this.cardData2,this.cardData3];
    }

    
        
    render(){
        return(  
        <CardBody cards={this.cardArray} />);
    }

}


class CardBody extends React.Component{
    
    render(){
        return(
        <div class="container jumbotron">
            <div class="row">
                <div class="col-sm-4"><ChallengeCard card={this.props.cards[0]}/></div>
                <div class="col-sm-4"><ChallengeCard card={this.props.cards[1]}/></div>
                <div class="col-sm-4"><ChallengeCard card={this.props.cards[2]}/></div>
            </div>
        </div>
        );
    }
}


class ChallengeCard extends React.Component{
    render(){
        return(
        <div class="card border-primary mb-3" >
            <div class="card-header">{this.props.card.title}</div>
            <div class="card-body">
                <p class="card-text">{this.props.card.desc}</p>
            
                <p>Current Penalty: $ {this.props.card.penalty}</p>
            </div>
        </div>
        );
    }
}

export default CardDisplay;
