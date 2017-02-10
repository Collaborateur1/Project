import React from 'react'

export default class SearchItem extends React.Component {

  constructor (props) {
    super(props)
    this.enterHandler = this.enterHandler.bind(this)
    this.leaveHandler = this.leaveHandler.bind(this)
    this.state = {
      style: {
        borderStyle: `solid`,
        borderColor: `white`
      }
    }
  }

  enterHandler () {
    this.setState({
      style: {
        borderStyle: `solid`,
        borderColor: `black`
      }
    })
  }

  leaveHandler () {
    this.setState({
      style: {
        borderStyle: `solid`,
        borderColor: `white`
      }
    })
  }

  render () {
    return (
      <li className="list-group-item" style={ {borderColor: `white`} }>
        <div className="card" style={this.state.style} onMouseLeave={this.leaveHandler} onMouseEnter={this.enterHandler}>
          <p>
            {this.props.hairdresser.hairid}<br/>
            {this.props.hairdresser.hairlastname}<br/>
            {this.props.hairdresser.buiszipcode}
          </p>
        </div>
      </li>
    )
  }
}

SearchItem.propTypes = {
  hairdresser: React.PropTypes.object
}
