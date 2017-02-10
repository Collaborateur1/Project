import React, { PropTypes, Component } from 'react'
import '../../css/sky-tabs.css'

export default class TabContents extends Component {

  render() {
    return (



        <div className="sky-tabs sky-tabs-pos-top-left sky-tabs-anim-scale sky-tabs-response-to-stack visible-xs">
				<input type="radio" name="sky-tabs" defaultChecked id="sky-tab1" className="sky-tab-content-1"/>
				<label htmlFor="sky-tab1"><span><span><i className="fa fa-bolt"></i>Tesla</span></span></label>
         <ul>
				 	<li className="sky-tab-content-1">
						<div className="typography">
							<h1>Nikola Tesla</h1>

							<p>Tesla's achievements and his abilities as a showman demonstrating his seemingly miraculous inventions made him world-famous. Although he made a great deal of money from his patents, he spent a lot on numerous experiments. He lived for most of his life in a series of New York hotels  7 January 1943.</p>
							<p className="text-right"><em>Find out more about Nikola Tesla from <a href="http://en.wikipedia.org/wiki/Nikola_Tesla" target="_blank">Wikipedia</a>.</em></p>
						</div>
					</li>
				 </ul>
				<input type="radio" name="sky-tabs" id="sky-tab2" className="sky-tab-content-2"/>
				<label htmlFor="sky-tab2"><span><span><i className="fa fa-picture-o"></i>da Vinci</span></span></label>
           <ul>
					 	<li className="sky-tab-content-2">
						<div className="typography">
							<h1>Leonardo da Vinci</h1>

							<p>Bord Florentine painter, Verrocchio. Much of his earlier working life w, and he spent his last years in France at the home awarded him by Francis I.</p>
							<p className="text-right"><em>Find out more about Leonardo da Vinci from <a href="http://en.wikipedia.org/wiki/Leonardo_da_Vinci" target="_blank">Wikipedia</a>.</em></p>
						</div>
					</li>
				 </ul>
				<input type="radio" name="sky-tabs" id="sky-tab3" className="sky-tab-content-3"/>
				<label htmlFor="sky-tab3"><span><span><i className="fa fa-cogs"></i>Einstein</span></span></label>
          <ul>
					<li className="sky-tab-content-3">
						<div className="typography">
							<h1>Albert Einstein</h1>

							<p>He theory and theoperties of light which laid the foundation of t theory of relativity to model the large-scale structure of the universe.</p>
							<p className="text-right"><em>Find out more about Albert Einstein from <a href="http://en.wikipedia.org/wiki/Albert_Einstein" target="_blank">Wikipedia</a>.</em></p>
						</div>
					</li>
				 </ul>
				<input type="radio" name="sky-tabs" id="sky-tab4" className="sky-tab-content-4"/>
				<label htmlFor="sky-tab4"><span><span><i className="fa fa-globe"></i>Newton</span></span></label>
				<ul>
					<li className="sky-tab-content-4">
						<div className="typography">
							<h1>Isaac Newton</h1>

							<p>Newtoe principles. By deriving Kepler's laws of p the validity of the heliocentric model of the cosmos.</p>
							<p className="text-right"><em>Find out more about Isaac Newton from <a href="http://en.wikipedia.org/wiki/Isaac_Newton" target="_blank">Wikipedia</a>.</em></p>
						</div>
					</li>
				</ul>
			</div>




    )
  }
}