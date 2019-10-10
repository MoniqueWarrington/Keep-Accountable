import React from 'react';

const styleJumbotron = {
    padding: '20px', 
    margin:'5px'
}

const textAlignLeft = {
    'text-align': 'left'
}

class CardDisplay extends React.Component{
    cardArray = [];

    cardData1 = {title: "Ryan: Eat less junk food",
        desc: "I want to eat less junk food in order to lose weight!",
        penalty: 65};    
    cardData2 = {title: "Aidan: Going to the gym more",
        desc: "I want to go to the gym more so I can start being healthier",
        penalty: 40};
    cardData3 = {title: "Monique: Spend more time studying",
        desc: "I want to spend more time studying to improve my grades!",
        penalty: 85};
    
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
        <div class="jumbotron" style={styleJumbotron}>
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
        <a href="/challenge">
        <div class="card border-primary mb-3" style={textAlignLeft} >
            <div class="card-header">{this.props.card.title}</div>
            <div class="card-body">
                <p class="card-text">{this.props.card.desc}</p>
            
                <p>Current Penalty: $ {this.props.card.penalty}</p>
            </div>
        </div>
        </a>
        );
    }
}

export default CardDisplay;
