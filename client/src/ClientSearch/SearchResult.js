import React from 'react'
import SearchItem from './SearchItem'
import SearchMap from './SearchMap'

export default class SearchResult extends React.Component {

  render () {
    return (
      <div>
        <ul className="list-group col-sm-6">
          {
            this.props.hairdressers.map((h) => {
              return (<SearchItem key={h.hairid} hairdresser={h}/>)
            })
          }
        </ul>
        <div className="col-sm-6">
          {this.props.searchActive ? <SearchMap /> : <div></div> }
        </div>
      </div>
    )
  }
}

SearchResult.propTypes = {
  hairdressers: React.PropTypes.array
}
