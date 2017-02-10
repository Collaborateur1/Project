import React, { PropTypes, Component } from 'react'

export default class FooterSection extends Component {
  
  render() {
    return (

  <footer className="bg--dark footer-1 text-center-xs">
                <div className="container">
                    <div className="row">
                        <div className="col-md-3 col-sm-4">
                            <a href="#">
                                <img className="logo" alt="Pillar" src="img/logo-light.png" />
                            </a>
                            <p>
                                <em>Full-service</em> design and
                                <br /> development in Melbourne
                            </p>
                        </div>
                        <div className="col-md-5 col-sm-8">
                            <h6>Navigate</h6>
                            <ul className="footer__navigation">
                                <li>
                                    <a href="#">
                                        <span>About Us</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Services</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Selected Work</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Get In Touch</span>
                                    </a>
                                </li>
                            </ul>
                            <ul className="footer__navigation">
                                <li>
                                    <a href="#">
                                        <span>Planner</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Careers</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span>Terms of Service</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div className="col-md-4 col-sm-12">
                            <h6>Subscribe</h6>
                            <p>
                                Get monthly updates and free resources.
                            </p>
                            <form className="form--merge form--no-labels" action="http://mrareco.createsend.com/t/d/s/kieth/" method="post" id="subForm" data-error="Please fill all fields correctly." data-success="Thanks for signing up! Please check your inbox for confirmation email.">
                                <p>
                                    <label htmlFor="fieldEmail">Email Address</label>
                                    <br />
                                    <input className="col-md-8 col-sm-6 validate-required validate-email" id="fieldEmail" name="cm-kieth-kieth" type="email" required />
                                </p>
                                <p>
                                    <button type="submit">Go</button>
                                </p>
                            </form>
                        </div>
                    </div>
                    <div className="row footer__lower text-center-xs">
                        <div className="col-sm-12">
                            <hr/>
                        </div>
                        <div className="col-sm-6">
                            <span className="type--fine-print">&copy; Copyright
                                <span className="update-year">2016</span> Medium Rare - All Rights Reserved</span>
                        </div>
                        <div className="col-sm-6 text-right text-center-xs">
                            <ul className="social-list">
                                <li>
                                    <a href="#">
                                        <i className="socicon-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i className="socicon-dribbble"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i className="socicon-vimeo"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i className="socicon-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
            
        
    )
  }
}
