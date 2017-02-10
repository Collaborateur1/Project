import { CHANGE_PATH } from '../constants/ActionTypes'
const initialRoute = { path: [''] };
const initialState = { route: initialRoute };

export default function navigator(state = initialState, action) {

  switch (action.type) {
    case CHANGE_PATH:
      return Object.assign({}, state, {
        route: action.route,
      });
    default:
      return state;
  }
}