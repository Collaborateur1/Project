import React, { PropTypes, Component } from 'react'
import AutocompleteLocation from 'react-google-autocomplete'
import SearchResult from './SearchResult'
export default class SearchSection extends Component {
   constructor (props) {
    super(props)
    this.submitHandler = this.submitHandler.bind(this)
    this.changeHandler = this.changeHandler.bind(this)
    this.placeSelectHandler = this.placeSelectHandler.bind(this)
    this.state = {
      searchActive: false,
      result: [],
      salonOrStylist: ``,
      location: ``,
      service: ``
    }
  }

  static propTypes = {
    SearchSectionActions: PropTypes.object.isRequired,
     advanceSearch: PropTypes.bool.isRequired
  }

  submitHandler (e) {
       e.preventDefault()
      let data={salonOrStylist:this.state.salonOrStylist,lat:this.state.lat,lng:this.state.lng,service:this.state.service}
this.props.SearchSectionActions.fetchSearchResult(data,this.props.SearchSectionActions)

  }
componentDidMount() {
  var event = document.createEvent('Event');
event.initEvent('documentReady', true, true); //can bubble, and is cancellable
document.dispatchEvent(event);

var event2 = document.createEvent('Event');
event2.initEvent('windowLoad', true, true); //can bubble, and is cancellable
document.dispatchEvent(event2);


  }
  changeHandler (e) {
    const newState = {}
    newState[e.target.name] = e.target.value
    this.setState(newState)
  }

  placeSelectHandler (place) {
    this.setState({
      location: place.formatted_address || place.name,
      lat:place.geometry.location.lat(),
      lng:place.geometry.location.lng()
    })
  }
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
                        <div className="col-sm-9 col-sm-offset-2 col-xs-12 text-center-xs">
                            <form className="form--merge" method="post" onSubmit={this.submitHandler}>
                                <input className="col-md-3 col-sm-3 search" type="search" name="search" placeholder="Search keywords" onChange={this.changeHandler}/>
								<input className="col-md-3 col-sm-3 search2" type="search" name="search2" placeholder="Search keywords2" onChange={this.changeHandler}/>
                                <AutocompleteLocation onChange={this.changeHandler} onPlaceSelected={this.placeSelectHandler} types={[`geocode`]}  type="search" name="search3" componentRestrictions={{country: `fr`}} className="col-md-3 col-sm-3 search3" name="location" placeholder="Où ?" />
                                <button id="Mainsubmit" className="col-md-3 col-sm-5 btn btn--primary" type="submit">Start</button>
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
                <SearchResult hairdressers={this.state.result} searchActive={this.state.searchActive} />
            </section>
            
        
    )
  }
}