import React from 'react'
import logo from './logo.svg'

import '../../css/App.css'

export default class Header extends React.Component {

  render () {
    return (
      <nav className="navbar navbar-toggleable-sm navbar-dark bg-inverse">
        <h1 className="navbar-brand">
          <img src={logo} className="App-logo" alt="logo" />
        </h1>
      </nav>
    )
  }
}
