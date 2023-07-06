import React from 'react'
import './MoodyCard.css'

type MoodyCardProps = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
}

const MoodyCard = ({weatherDescription, genre_message, genreName} : MoodyCardProps) => {
  return (
    <>
      <div className="flip-card">
        <div className="flip-card-inner">
          <div className="flip-card-front">
            {/* <img src="img_avatar.png" alt="Avatar"/> */}
            <h2>{weatherDescription}</h2>
          </div>
          <div className="flip-card-back">
            <h2>{genreName}</h2>
            <p>{genre_message}</p>
          </div>
        </div>
      </div>
    </>
  )
}

export default MoodyCard