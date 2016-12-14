import React from 'react'
import SearchResult from './SearchResult'
import AutocompleteLocation from 'react-google-autocomplete'

export default class ClientSearch extends React.Component {

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

  submitHandler (e) {
    e.preventDefault()
    fetch(`/puls/cli/search?salonOrStylist=${this.state.salonOrStylist}&location=${this.state.location}&service=${this.state.service}`)
    .then((response) => {
      if (response.ok) {
        response.json()
        .then(result => {
          this.setState({
            searchActive: true,
            result: result
          })
        })
      }
    })
  }

  changeHandler (e) {
    const newState = {}
    newState[e.target.name] = e.target.value
    this.setState(newState)
  }

  placeSelectHandler (place) {
    this.setState({
      location: place.formatted_address || place.name
    })
  }

  render () {
    return (
      <div className="row">
        <form onSubmit={this.submitHandler} className="form-inline">
          <div className="form-group">
            <label className="sr-only" htmlFor="location">Location</label>
            <AutocompleteLocation onChange={this.changeHandler} onPlaceSelected={this.placeSelectHandler} types={[`geocode`]} componentRestrictions={{country: `fr`}} className="form-control" name="location" placeholder="Où ?" />
          </div>
          <div className="form-group">
            <label className="sr-only" htmlFor="salon-or-stylist">Salon or Stylist</label>
            <input onChange={this.changeHandler} value={this.state.salonOrStylist} type="text" className="form-control" name="salonOrStylist" placeholder="Salon ou Coiffeur"/>
          </div>
          <div className="form-group">
            <label className="sr-only" htmlFor="service">Prestation</label>
            <input onChange={this.changeHandler} value={this.state.service} type="text" className="form-control" name="service" placeholder="Quelle Prestation ?"/>
          </div>
          <button type="submit" className="btn btn-primary"><i className="material-icons">search</i></button>
        </form>
        <SearchResult hairdressers={this.state.result} searchActive={this.state.searchActive} />
      </div>
    )
  }
}
