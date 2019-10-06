import React from 'react';
import CardDisplay from './ChallengeCard/ChallengeCard'
import HomeStatement from './HomeStatement';

class HomePage extends React.Component{
    render(){
        return (
            <div class ="container">
                <HomeStatement></HomeStatement>
                <CardDisplay></CardDisplay>
            </div>
        );

    }
}
export default HomePage;