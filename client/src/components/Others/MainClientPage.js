import React, { PropTypes, Component } from 'react'
import MainHeader from './MainHeader.js'
import RightPanel from './RightPanel.js'
import SearchSection from './SearchSection.js'
import MiddleSection from './MiddleSection.js'
import FooterSection from './FooterSection.js'

export default class MainClientPage extends Component {
   constructor(props){
     super(props);
     this.renderView = this.renderView.bind(this);
   }
  //  static propTypes = {
  //   view:  PropTypes.number.isRequired,
  //   actions: PropTypes.object.isRequired

  // }
renderSearchView(){
return (
  <div >
  <SearchSection/>
  <MiddleSection/>
  </div>	 
    );
}

renderResultView(){
return (
    null
    );
}

renderView(view){
  debugger;
  switch(view) {
    case 1:
       return this.renderSearchView()
        break;
    case 2:
      return this.renderResultView()
        break;
    default:
      return  this.renderSearchView()
}

}

  render() {
    return (

	<div className="main-container transition--fade">
            <MainHeader/>
            <RightPanel/>
              {this.renderView(1)}
           <FooterSection/>
        </div>

    )
  }
}