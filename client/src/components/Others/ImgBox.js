import React, { PropTypes, Component } from 'react'

export default class ImgBox extends Component {
  
  render() {
    return (
  <section className="wide-grid masonry">
                <div className="container">
                    <div className="row">
                        <div className="col-sm-12">
                            <div className="masonry__filters masonry__filters text-center" data-filter-all-text="All Highlights"></div>
                        </div>
                    </div>
                </div>
                <div className="masonry__container masonry--animate">
                    <div className="col-md-3 col-sm-6 masonry__item" data-masonry-filter="Museum">
                        <a href="#">
                            <div className="hover-element hover-element-1 hover--active" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/tour-2.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-scrim-top="6">
                                    <div className="boxed">
                                        <h5>Neue Museum</h5>
                                        <span>
                                            <em>Berlin, Germany</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-3 col-sm-6 masonry__item" data-masonry-filter="Experience">
                        <a href="#">
                            <div className="hover-element hover-element-1 hover--active" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/tour-1.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-scrim-top="6">
                                    <div className="boxed">
                                        <h5>Antelope Canyon</h5>
                                        <span>
                                            <em>Page, Arizona</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-3 col-sm-6 masonry__item" data-masonry-filter="Tour">
                        <a href="#">
                            <div className="hover-element hover-element-1 hover--active" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/tour-3.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-scrim-top="6">
                                    <div className="boxed">
                                        <h5>City Sightseeing</h5>
                                        <span>
                                            <em>London, England</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-3 col-sm-6 masonry__item" data-masonry-filter="Experience">
                        <a href="#">
                            <div className="hover-element hover-element-1 hover--active" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/tour-7.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-scrim-top="5">
                                    <div className="boxed">
                                        <h5>Highway One</h5>
                                        <span>
                                            <em>United States</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>

                </div>

            </section>
/*
 <section className="wide-grid masonry">
                <div className="masonry__filters text-center" data-filter-all-text="Show All"></div>
                <div className="masonry__container" style={{ backgroundColor: `transparent`}}>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="digital">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/OneF.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Freehance</h5>
                                        <span>
                                            <em>iOS Application</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="branding">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/oneH.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Michael Andrews</h5>
                                        <span>
                                            <em>Branding & Identity</em>
                                        </span>
                                    </div>
                                </div>
                            </div>
                           
                        </a>
                    </div>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="branding">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/DosM.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Pillar Stationary</h5>
                                        <span>
                                            <em>Branding Collateral</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="packaging">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/QuatF.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Authentic Apparel</h5>
                                        <span>
                                            <em>Packaging Design</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="branding">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/SixF.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Wave Poster</h5>
                                        <span>
                                            <em>Logo Design</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                    <div className="col-md-4 col-sm-6 masonry__item" data-masonry-filter="digital">
                        <a href="#">
                            <div className="hover-element hover-element-1" data-title-position="top,right">
                                <div className="hover-element__initial">
                                    <img alt="Pic" src="img/CinqF.jpg" />
                                </div>
                                <div className="hover-element__reveal" data-overlay="9">
                                    <div className="boxed">
                                        <h5>Tesla Controller</h5>
                                        <span>
                                            <em>Apple Watch Application</em>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </a>
                    </div>
                </div>

            </section>
            */

    )
  }
}