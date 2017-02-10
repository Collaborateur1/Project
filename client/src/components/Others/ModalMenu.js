import React, { PropTypes, Component } from 'react'

export default class ModalMenu extends Component {
  
  render() {
    return (

       <div className="modal-container search-modal" data-modal-id="search-form">
            <div className="modal-content bg-white imagebg" data-width="100%" data-height="100%">
                <div className="pos-vertical-center clearfix">
                    <div className="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 text-center">
                        <form className="clearfix">
                            <div className="input-with-icon">
                                <i className="icon-Magnifi-Glass2 icon icon--sm"></i>
                                <input type="search" name="query" placeholder="Type your search and hit enter" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
          
        </div>
            
        
    )
  }
}


