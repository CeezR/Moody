import React from 'react'
import './MoodyCard.css'

type MoodyCardProps = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
}

const MoodyCard = ({weatherDescription, genre_message, genreName} : MoodyCardProps) => {


  const handleUpvote = () => {

  }

  const handleDownvote = () => {
    
  }

  const handleDelete = () => {
    
  }


  return (
    <>
      <div className="flip-card">
        <div className="flip-card-inner">
          <div className="flip-card-front">
            {/* <img src="img_avatar.png" alt="Avatar"/> */}
            <h2>{weatherDescription}</h2>
          </div>
          <div className="flip-card-back d-flex flex-column p-3 gap-1">
            <h2>Pop</h2>
            <p>Suns out! Time for some pop to brighten your day even more.</p>
            <div className="d-flex mt-auto gap-1">
              <button  className='btn btn-secondary flex-grow-1'>UpVote</button>
              <p className='flex-grow-1 fs-2 m-0'>0</p>
              <button className='btn btn-secondary flex-grow-1'>DownVote</button>
              </div>
              <button className='btn btn-danger'>Delete</button>
          </div>
        </div>
      </div>
    </>
  )
}

export default MoodyCard