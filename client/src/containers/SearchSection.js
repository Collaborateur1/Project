import React, { Component,PropTypes } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import * as SearchSectionActions  from '../actions/SearchSectionActions.js'
import SearchSectionComponents from '../components/ClientSearch/SearchSection'



class SearchSection extends Component {
componentDidMount() {









  }
  render() {

 return   <SearchSectionComponents
 SearchSectionActions={this.props.SearchSectionActions}
    advanceSearch={this.props.advanceSearch}

  />;

  }
}



const mapStateToProps = state => ({
  advanceSearch: state.searchSection.advanceSearch
})

const mapDispatchToProps = dispatch => ({
    SearchSectionActions : bindActionCreators(SearchSectionActions, dispatch)
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SearchSection)