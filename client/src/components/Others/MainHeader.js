import React, { PropTypes, Component } from 'react'
import MenuClient from "./MenuClient.js"
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
               <MenuClient/>

                <div className="nav-module right">
                    <a href="#" className="nav-function" data-notification-link="cart-overview">
                        <i className="interface-bag icon icon--sm"></i>
                        <span>Cart</span>
                    </a>
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