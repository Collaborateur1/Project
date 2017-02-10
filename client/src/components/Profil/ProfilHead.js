import React, { PropTypes, Component } from 'react'

export default class ProfilHead extends Component {

  render() {
    return (

 <section className="slider slider--animate imagebg height-50" data-arrows="true" data-paging="true" data-timing="5000">
                <ul className="slides">
                    <li className="imagebg" data-overlay="4">
                        <div className="background-image-holder">
                            <img alt="image" src="img/hero3.jpg" />
                        </div>

                    </li>
                    <li className="imagebg" data-overlay="4">
                        <div className="background-image-holder">
                            <img alt="image" src="img/hero4.jpg" />
                        </div>
                        
                    </li>
                </ul>

            </section>



    )
  }
}


