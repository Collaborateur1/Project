import React, { PropTypes, Component } from 'react'

export default class RightPanel extends Component {
  
  render() {
    return (

       <div className="notification pos-right pos-top cart-overview" data-notification-link="cart-overview" data-animation="from-right">
            <div className="cart-overview__title">
                <h5>Your Cart</h5>
            </div>
            <ul className="cart-overview__items">
                <li>
                    <div className="item__image">
                        <a href="#">
                            <img alt="product" src="img/product-small-1.png" />
                        </a>
                    </div>
                    <div className="item__detail">
                        <span>Dave Wool Beanie</span>
                        <span className="h6">1 x $39.00</span>
                    </div>
                    <div className="item__remove" title="Remove From Cart"></div>
                </li>
                <li>
                    <div className="item__image">
                        <a href="#">
                            <img alt="product" src="img/product-small-2.png" />
                        </a>
                    </div>
                    <div className="item__detail">
                        <span>Rose Tinted Glasses</span>
                        <span className="h6">1 x $89.00</span>
                    </div>
                    <div className="item__remove" title="Remove From Cart"></div>
                </li>
            </ul>
            <div className="cart-overview__subtotal">
                <h5>Subtotal:</h5>
                <span>$128.00</span>
            </div>
            <div className="cart-overview__action">
                <a href="#" className="btn btn--square btn--primary">
                    <span className="btn__text">
                        Checkout Now
                    </span>
                </a>
            </div>
        </div>
            
        
    )
  }
}


