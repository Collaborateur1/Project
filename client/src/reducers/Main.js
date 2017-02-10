import { SET_MAIN_SECTION,SET_SEARCH_SECTION } from '../constants/ActionTypes'

const initialState = {
    currentPage: 1


}

export default function main (state = initialState, action) {
  switch (action.type) {
    case SET_MAIN_SECTION:
      return {
          ...state,
          currentPage: 1

      }


    case SET_SEARCH_SECTION:
      return {
          ...state,
          currentPage: 2
      }

    default:
      return state
  }
}
