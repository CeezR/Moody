import React, { useEffect, useState } from 'react'
import './MoodyCard.css'
import { createApi } from "unsplash-js";
import { ApiResponse } from 'unsplash-js/dist/helpers/response';
import { Photos } from 'unsplash-js/dist/methods/search/types/response';

type MoodyCardProps = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
  weatherImgUrl : string | undefined;
  genreImgUrl : string | undefined;
}

const MoodyCard = ({weatherDescription, genre_message, genreName, genre_upvotes, id, weatherImgUrl, genreImgUrl} : MoodyCardProps) => {
  const [upVotes, setUpVotes] = useState(0);

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

  const handleDelete = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/genre/${id}`, {
        method: 'DELETE'
      })
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      
    } catch (error) {
      console.error('Error:', error);
    }
  }

  useEffect(() => {
    if(genre_upvotes !== undefined) {
      setUpVotes(genre_upvotes);
    } else {
      setUpVotes(0);
    }
  }, [genre_upvotes, id]);


  return (
    <>
      <div className="flip-card m-auto">
        <div className="flip-card-inner">
          <div className="flip-card-front" style={{ backgroundImage: `url('${weatherImgUrl}')` }}>
            {/* {weatherImgUrl && <img className="flip-card-front-img" src={weatherImgUrl} alt="Avatar"/>} */}
            <h2 className="flip-card-front-title p-3 fs-1">{weatherDescription}</h2>
          </div>
          <div className="flip-card-back d-flex flex-column p-3 gap-1" style={{ backgroundImage: `url('${genreImgUrl}')` }}>
            <div className='flip-card-back-text'>
              <h2 className='fs-1'>{genreName}</h2>
              <p className='fs-5'>{genre_message}</p>
            </div>
            <div className="d-flex mt-auto gap-1">
              <button onClick={handleDownvote} className='btn btn-secondary flex-grow-1'>DownVote</button>
              <p className='flex-grow-1 fs-2 m-0'>{upVotes}</p>
              <button onClick={handleUpvote} className='btn btn-secondary flex-grow-1'>UpVote</button>
              </div>
              <button onClick={handleDelete} className='btn btn-danger'>Delete</button>
          </div>
        </div>
      </div>
    </>
  )
}

export default MoodyCard