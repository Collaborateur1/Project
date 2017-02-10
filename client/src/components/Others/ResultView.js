import React, { PropTypes, Component } from 'react'
import Calendar from './Calendar.js'
export default class ResultView extends Component {
  
  render() {
    return (

       <div className="tabs" style={{height:`280px`,marginBottom:'15px'}}>
  
          <div id="tab-2" className="tabs__content "><img src="./img/hero18.jpg" alt="" className="tabs__img"  style={{marginBottom:`0em`, maxHeight:`100%`}}/>
        
            <div className="tabs__description calendar-container" style={{margin:`0px`}}>
            <h2 className="tabs__title">Our Mission</h2>
            <p className="tabs__text">You think water moves fast</p>
              <Calendar />
            </div>
          </div>
      
        </div>
            
        
    )
  }
}