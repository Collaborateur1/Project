import React, { PropTypes, Component } from 'react'

export default class ContactMainPage extends Component {

  render() {
    return (
<section className="features features-10">
		                <div className="feature bg--white col-md-4 text-center">
		                    <i className="icon icon--lg icon-Map-Marker2"></i>
		                    <h4>Drop on in</h4>
		                    <p>
		                        Suite 203, Level 4
		                        <br/> 124 Koornang Road
		                        <br/> Carnegie, Victoria 3183
		                    </p>
		                </div>
		                <div className="feature bg--secondary col-md-4 text-center">
		                    <i className="icon icon--lg icon-Phone-2"></i>
		                    <h4>Give us a call</h4>
		                    <p>
		                        Office: (03) 9283 2617
		                        <br/> Fax: +61 3827 3590
		                    </p>
		                </div>
		                <div className="feature bg--dark col-md-4 text-center">
		                    <i className="icon icon--lg icon-Computer"></i>
		                    <h4>Connect online</h4>
		                    <p>
		                        Email:
		                        <a href="#">hello@pillarstudio.net</a>
		                        <br/> Twitter:
		                        <a href="#">@pillarstudio</a>
		                    </p>
		                </div>
		            </section>

                



    )
  }
}