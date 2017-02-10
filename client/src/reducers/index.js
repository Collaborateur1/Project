import { combineReducers } from 'redux'
import main from './Main'
import navigator from './Navigator'
import searchSection from './SearchSection'
import { routerReducer } from 'react-router-redux'

const rootReducer = combineReducers({
  main,
  navigator,
  searchSection,
  routing : routerReducer
})

export default rootReducer