import React, {Component} from 'react'

class Checkbox extends Component {

  constructor (props) {
    super(props)
    this.checkHandler = this.checkHandler.bind(this)
    this.state = { checked: false, textColor: `text-muted` }
  }

  checkHandler () {
    this.setState(function (prevState) {
      return { checked: !prevState.checked, textColor: prevState.checked ? `text-danger` : `text-success` }
    })
  }

  render () {
    return (
      <div className="input-group">
        <span className={`input-group-addon ${this.state.textColor}`} id="checkLabel">{this.state.checked ? `Checked` : `Unchecked`}</span>
        <input className="form-control" aria-describedby="checkLabel" type="checkbox" defaultChecked={this.state.checked} onChange={this.checkHandler}/>
      </div>
    )
  }
}

export default Checkbox
