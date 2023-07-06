import React, { useEffect, useState } from 'react'
import './MoodyCard.css'

type MoodyCardProps = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
}

const MoodyCard = ({weatherDescription, genre_message, genreName, genre_upvotes, id} : MoodyCardProps) => {
  const [upVotes, setUpVotes] = useState(genre_upvotes);

  const handleUpvote = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/genre/${id}/upVote`, {
        method: 'PUT'
      })
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      if(upVotes !== undefined) {
        setUpVotes(upVotes + 1)
      }
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  const handleDownvote = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/genre/${id}/downVote`, {
        method: 'PUT'
      })
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      if(upVotes !== undefined) {
        setUpVotes(upVotes - 1)
      }
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  const handleDelete = () => {
    
  }

  useEffect(() => {
    setUpVotes(genre_upvotes);
  }, [genre_upvotes]);


  return (
    <>
      <div className="flip-card">
        <div className="flip-card-inner">
          <div className="flip-card-front">
            {/* <img src="img_avatar.png" alt="Avatar"/> */}
            <h2>{weatherDescription}</h2>
          </div>
          <div className="flip-card-back d-flex flex-column p-3 gap-1">
            <h2>{genreName}</h2>
            <p>{genre_message}</p>
            <div className="d-flex mt-auto gap-1">
              <button onClick={handleUpvote} className='btn btn-secondary flex-grow-1'>UpVote</button>
              <p className='flex-grow-1 fs-2 m-0'>{upVotes}</p>
              <button onClick={handleDownvote} className='btn btn-secondary flex-grow-1'>DownVote</button>
              </div>
              <button className='btn btn-danger'>Delete</button>
          </div>
        </div>
      </div>
    </>
  )
}

export default MoodyCard