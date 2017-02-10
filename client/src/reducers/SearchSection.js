import { SET_OR_UNSET_ADVANCE_SEARCH } from '../constants/ActionTypes';

const initialState = { advanceSearch: false };

export default function searchSection(state = initialState, action) {

  switch (action.type) {
    case SET_OR_UNSET_ADVANCE_SEARCH:
      return {
          ...state,
          advanceSearch: !this.state.advanceSearch

      }
    default:
      return state;
  }
}