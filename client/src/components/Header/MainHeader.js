import React, { PropTypes, Component } from 'react'
import MenuClient from "../Menu/MenuClient.js"
export default class MainHeader extends Component {
  
  render() {
    return (

        <nav className="transition--fade">
            <div className="nav-bar nav--absolute nav--transparent" data-fixed-at="200">
                <div className="nav-module logo-module left">
                    <a href="index.html">
                        <img className="logo logo-dark" alt="logo" src="img/logo-dark.png" />
                        <img className="logo logo-light" alt="logo" src="img/logo-light.png" />
                    </a>
                </div>




               <div className="nav-module right modal-instance">
                <a className=" btn btn--sm btn--primary modal-trigger" href="#">
                                <span className="btn__text">
                                   Connexion
                                </span>
                            </a>
               <div className="modal-container">
                                    <div className="modal-content bg--white height--natural">
                                        <div className="form-subscribe-1 boxed boxed--lg bg--white box-shadow-wide">
                                            <div className="subscribe__title text-center">
                                                <h4>Connexion</h4>
                                                <p className="lead">
                                                    à transformer en composant..
                                                </p>
                                            </div>
                                            <form className=" form--center-submit-button" action="http://mrareco.createsend.com/t/d/s/kieth/" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                                <div className="input-with-icon">
                                                    <label htmlFor="fieldName">Your Name</label>
                                                    <i className="icon icon-Male-2"></i>
                                                    <input id="fieldName" name="cm-name" type="text" />
                                                </div>
                                                <div className="input-with-icon">
                                                    <label htmlFor="fieldEmail">Email Address</label>
                                                    <i className="icon icon-Mail-2"></i>
                                                    <input className="validate-required validate-email" id="fieldEmail" name="cm-kieth-kieth" type="email" required />
                                                </div>
                                                <button type="submit">Subscribe Now</button>
                                            </form>
                                        </div>
                                    </div>

                                </div>

               </div>
                <div className="nav-module right">
                    <a href="#" className="nav-function modal-trigger" data-modal-id="search-form">
                        <i className="interface-search icon icon--sm"></i>
                        <span>Search</span>
                    </a>
                </div>
            </div>

            <div className="nav-mobile-toggle visible-sm visible-xs">
                <i className="icon-Align-Right icon icon--sm"></i>
            </div>
        </nav>
            
        
    )
  }
}