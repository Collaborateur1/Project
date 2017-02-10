import React, { PropTypes, Component } from 'react'

export default class Overlap extends Component {
componentDidMount() {
  var event = document.createEvent('Event');
event.initEvent('documentReady', true, true); //can bubble, and is cancellable
document.dispatchEvent(event);

var event2 = document.createEvent('Event');
event2.initEvent('windowLoad', true, true); //can bubble, and is cancellable
document.dispatchEvent(event2);


  }
  render() {
    return (

 <section className="section--overlap">
                <div className="container">
                    <div className="row">
                        <div className="col-sm-3">
                            <div className="boxed imagebg height-20 box-shadow-wide" data-overlay="0">
                                <div className="background-image-holder">
                                    <img alt="pic" src="img/hero18.jpg" />
                                </div>
                                <div className="pos-vertical-center text-top">
                                    <h4>walpix</h4>

                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </section>



    )
  }
}

