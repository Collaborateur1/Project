import React from 'react'
import ReactDOM from 'react-dom'
import { Provider } from 'react-redux'
import reducer from './reducers'
import App from './containers/App'
import './index.css'
import configureStore from './utils/ConfigureStore';
import { Router, Route, IndexRoute, browserHistory } from 'react-router'
import { syncHistoryWithStore } from 'react-router-redux'

const store = configureStore()
const history = syncHistoryWithStore(browserHistory, store)
ReactDOM.render(
    <Provider store={store}>
 <Router history={history}>
 <Route path="/*" component={App}>
  <App />
  </Route>
  </Router>
   </Provider>,
  document.getElementById(`root`)
)
