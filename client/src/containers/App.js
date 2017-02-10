import React, {Component, PropTypes} from 'react'
import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import {initNavigator} from '../actions/NavigatorActions';
import Header from '../components/Header/MainHeader'
import SearchSection from './SearchSection'
import FooterSection from '../components/Footer/FooterSection'
import ImgBox from '../components/Others/ImgBox'
import ProfilHead from '../components/Profil/ProfilHead'
import Overlap from '../components/Profil/Overlap'
import TabContentsV2 from '../components/Others/TabContentsV2'
import TabContents from '../components/Others/TabContents'
import Accordion from '../components/Others/Accordion'
import ContactMainPage from '../components/Others/ContactMainPage'
import '../css/bootstrap.css'
import '../css/socicon.css'
import '../css/iconsmind.css'
import '../css/interface-icons.css'
import '../css/owl.carousel.css'
import '../css/lightbox.min.css'
import '../css/theme.css'
import '../css/custom.css'

import '../css/tabs.min.css'
import '../css/App.css'

import mr from '../../public/js/scripts.js'

class App extends Component {

  constructor(props) {
    super(props);
    this.renderView = this
      .renderView
      .bind(this);
  }
// la page principale
  renderMainPage() {

    return (
      <div >
        <SearchSection/>
        <ImgBox/>
        <ContactMainPage/>
      </div>
    );
  }
// la page de profil, pas daction pour y accéder
  renderProfil() {

    return (
      <div >
        <ProfilHead/>
        <Overlap/>
        <Accordion/>

      </div>
    );
  }
// la page pour le résultat de la recherche.. rien pour le moment
  renderResultView() {
    return (null);
  }
  renderView(route) {

    this.urlHistory = this.props.currentPage
    switch (route) {
      case "/":
        return this.renderMainPage()
        break;
      case "/search":
       return this.renderResultView()
        break;
      case "/profil":
        return this.renderProfil()
        break;


      default:
        return this.renderMainPage()
    }

  }
  render() {

    return (

      <div className="main-container transition--fade">
        <Header/>
         {this.renderView(this.props.location.pathname)}
        <FooterSection/>
      </div>

    )

  }
}

/*
function mapStateToProps(state) {
debugger

  return {
 currentPage: state.routing.locationBeforeTransitions.pathname
  };
}

const mapDispatchToProps = dispatch => ({
    actions: bindActionCreators(actions, dispatch)
})
*/
export default connect()(App)