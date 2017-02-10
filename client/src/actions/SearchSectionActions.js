import { SET_OR_UNSET_ADVANCE_SEARCH,SET_SEARCH_SECTION,SET_SEARCH_RESULT } from '../constants/ActionTypes';
export const setOrUnsetAdvanceSearch = data => ({ type: SET_OR_UNSET_ADVANCE_SEARCH, data })
export const setSearchSection= data => ({ type: SET_SEARCH_SECTION, data })
export const setSearchResult= data => ({ type: SET_SEARCH_RESULT, data })
import { navigateTo } from '../actions/NavigatorActions';
import { browserHistory } from 'react-router'
export function fetchSearchResult(data,actions) {
  debugger
  return (dispatch) =>{
      fetch(`/puls/search?salonOrStylist=${data.salonOrStylist}&latitude=${data.lat}&longitude=${data.lng}&service=${data.service}`)
      .then(response => response.json())
      .then(json => {
       actions.setSearchResult(json)
       browserHistory.push('/search')


      })
      .catch(err => { throw err; });
}
}
