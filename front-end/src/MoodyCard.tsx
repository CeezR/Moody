import React from 'react'


type MoodyCardProps = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
}

const MoodyCard = ({weatherDescription, genre_message, genreName} : MoodyCardProps) => {
  return (
    <div>
      <p>Weather : {weatherDescription}</p>
      <p>Genere: {genreName}</p>
      <p>Message: {genre_message}</p>
    </div>
  )
}

export default MoodyCard