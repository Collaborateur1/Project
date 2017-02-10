import React, { PropTypes, Component } from 'react'

export default class SearchSection extends Component {
  
  render() {
    return (

       <section className="imagebg videobg height-70 cover cover-7" data-overlay="4">
                <video autoPlay loop muted>
                    <source src="video/video3.mp4" type="video/webm"/>
                    <source src="video/video.mp4" type="video/mp4"/>
                    <source src="video/video.ogv" type="video/ogg"/>
                </video>
                <div className="background-image-holder">
                    <img alt="image" src="img/video.jpg" />
                </div>
                <div className="container pos-vertical-center">
                    <div className="row">
                        <div className="col-sm-12 text-center">
                            <h2>Start a conversation.</h2>
                            <p className="lead">
                                Browse and connect with employers from all over the world.
                            </p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-sm-8 col-sm-offset-2 col-xs-12 text-center-xs">
                            <form className="form--merge" method="post">
                                <input className="col-md-3 col-sm-3 search" type="search" name="search" placeholder="Search keywords" />
								<input className="col-md-3 col-sm-3 search2" type="search" name="search2" placeholder="Search keywords2" />
								<input className="col-md-3 col-sm-3 search3" type="search" name="search3" placeholder="Search keywords3" />
                                <button className="col-md-3 col-sm-5 btn btn--primary" type="submit">Start</button>
                            </form>
                        </div>
                    </div>
                    
                    <div className="row">
                        <div className="col-sm-12 text-center">
                            <span className="h6">How Does Pillar Work?</span>
                            <div className="modal-instance modal-video-1">
                                <a className="btn modal-trigger" href="#">
                                    <span className="btn__text">
                                        &#9658; &nbsp; Watch The Overview
                                    </span>
                                </a>
                                <div className="modal-container">
                                    <div className="modal-content bg-dark" data-width="70%" data-height="60%">
                                        <iframe src="https://www.youtube.com/embed/4QUVRm4UZA4?autoplay=1" allowFullScreen="allowFullScreen"></iframe>
                                    </div>
                                   
                                </div>
                             
                            </div>
                            
                        </div>
                    </div>
                    
                </div>
            </section>
            
        
    )
  }
}