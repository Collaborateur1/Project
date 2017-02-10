import React, { PropTypes, Component } from 'react'
import TabContentsV2 from './TabContentsV2'
import TabContents from './TabContents'
export default class Accordions extends Component {

  render() {
    return (

<section>
		                <div className="container">
		                    <div className="row">
		                        <div className="col-md-9 col-md-offset-3 col-sm-8 col-sm-offset-2">
		                            <div className="elements--title text-center">
		                                <h4>Nos service</h4>
		                            </div>
		                            <ul className="accordion">
		                                <li className="active">
		                                    <div className="accordion__title">
		                                        <span className="h5">Coupe Homme</span>
		                                    </div>
		                                    <div className="accordion__content">
                                            <TabContents/>
                                            <TabContentsV2 />

		                                    </div>
		                                </li>
		                                <li>
		                                    <div className="accordion__title">
		                                        <span className="h5">Coupe femme</span>
		                                    </div>
		                                    <div className="accordion__content">

		                                    </div>
		                                </li>
		                                <li>
		                                    <div className="accordion__title">
		                                        <span className="h5">Coupe Enfant</span>
		                                    </div>
		                                    <div className="accordion__content">

		                                    </div>
		                                </li>
		                            </ul>

		                        </div>
		                    </div>

		                </div>

		            </section>



    )
  }
}
