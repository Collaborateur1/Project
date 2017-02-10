import React, { PropTypes, Component } from 'react'
import Header from '../Header/MainHeader'
import SearchSection from '../../containers/SearchSection'
import FooterSection from '../Footer/FooterSection'
import ImgBox from '../Others/ImgBox'
import '../../css/bootstrap.css'
import '../../css/socicon.css'
import '../../css/interface-icons.css'
import '../../css/owl.carousel.css'
import '../../css/lightbox.min.css'
import '../../css/theme.css'
import '../../css/custom.css'
import '../../css/style.min.css'
import '../../css/tabs.min.css'
import '../../css/App.css'


export default class App extends Component {

static propTypes = {
    currentPage: PropTypes.string.isRequired
  }
   constructor(props){

     super(props);
     this.renderView = this.renderView.bind(this);
   }


  //  static propTypes = {
  //   view:  PropTypes.number.isRequired,
  //   actions: PropTypes.object.isRequired

  // }
renderSearchView(){

return (
  <div >
  <SearchSection/>
<ImgBox/>
  </div>
    );
}

renderResultView(){
return (
    null
    );
}

renderView(view){

  switch(view) {
    case 1:
       return this.renderSearchView()
        break;
    case 2:
      return this.renderResultView()
        break;
    default:
      return  this.renderSearchView()
}

}

  render() {
    return (

	<div className="main-container transition--fade">
            <Header/>

              {this.renderView(this.props.currentPage)}
           <FooterSection/>
        </div>

    )
  }
}
