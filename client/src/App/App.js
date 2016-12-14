import React from 'react'
import Header from '../Header/Header'
import ClientSearch from '../ClientSearch/ClientSearch'

import './App.css'


export default class App extends React.Component {
  render() {
    return (
      <div className="container-fluid">
        <Header />
        <br /><br /><br />
        <div className="container">
          <ClientSearch />
        </div>
      </div>
    )
  }
}
