import React from 'react'
import GoogleMap from 'react-google-map'
import GoogleMapLoader from "react-google-maps-loader"

const MY_API_KEY = `AIzaSyArvwVVC_Tj9MKzDO-dOcwPIts_Bf7bYx4`

const SearchMap = ({googleMaps}) => (
  <div style={{ height: `300px` }}>
    <GoogleMap
      googleMaps={googleMaps}
      // You can add and remove coordinates on the fly.
      // The map will rerender new markers and remove the old ones.
      coordinates={[
        {
          title: `Toulouse`,
          position: {
            lat: 43.604363,
            lng: 1.443363,
          },
          onLoaded: (googleMaps, map, marker) => {
            // Set Marker animation
            marker.setAnimation(googleMaps.Animation.BOUNCE)

            // Define Marker InfoWindow
            const infoWindow = new googleMaps.InfoWindow({
              content: `
                <div>
                  <h3>Toulouse<h3>
                  <div>
                    Toulouse is the capital city of the southwestern
                    French department of Haute-Garonne,
                    as well as of the Occitanie region.
                  </div>
                </div>
              `,
            })

            // Open InfoWindow when Marker will be clicked
            googleMaps.event.addListener(marker, `click`, () => {
              infoWindow.open(map, marker)
            })

            // Open InfoWindow directly
            infoWindow.open(map, marker)
          },
        },
        {
          title: `haha`,
          position: {
            lat: 44.604363,
            lng: 1.443363,
          },
          onLoaded: (googleMaps, map, marker) => {
            // Set Marker animation
            marker.setAnimation(googleMaps.Animation.BOUNCE)

            // Define Marker InfoWindow
            const infoWindow = new googleMaps.InfoWindow({
              content: `
                <div>
                  <h3>Toulouse<h3>
                  <div>
                  haha
                  </div>
                </div>
              `,
            })

            // Open InfoWindow when Marker will be clicked
            googleMaps.event.addListener(marker, `click`, () => {
              infoWindow.open(map, marker)
            })

            // Open InfoWindow directly
            infoWindow.open(map, marker)
          },
        }
      ]}
      center={{lat: 43.604363, lng: 1.443363}}
      zoom={8}
    />
  </div>
)

SearchMap.propTypes = {
  googleMaps: React.PropTypes.object.isRequired
}

export default GoogleMapLoader(SearchMap, {
  libraries: [`places`],
  key: MY_API_KEY,
})
