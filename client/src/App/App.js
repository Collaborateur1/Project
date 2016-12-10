import React, { Component } from 'react'
import logo from './logo.svg'
import './App.css'

import Checkbox from '../Checkbox/Checkbox'

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        <div className="page-actions">test</div>
        <form className="search-form search-form-expanded">
            <div className="input-group">
              <input type="text" className="form-control" placeholder="Search..." name="query" />
              <span className="input-group-btn">
                <a href="#!" className="btn submit">
                  <i className="icon-magnifier"></i>
                </a>
              </span>
            </div>
        </form>
        <Checkbox />
        <Checkbox />
        <Checkbox />
      </div>
    )
  }
}

export default App
