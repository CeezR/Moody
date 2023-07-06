import React, { useEffect, useState } from 'react'
import SearchForm from './SearchForm'
import MoodyCard from './MoodyCard'

type moodyData = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
}

const Bord = () => {
  const [moody, setMoody] = useState<moodyData>();

  return (
    <main className='m-4'>
      <SearchForm setMoody={setMoody}/>
      <article className='my-3'>
      <MoodyCard 
                weatherDescription={moody?.weatherDescription} 
                genreName={moody?.genreName} 
                genre_message={moody?.genre_message}
                genre_upvotes={moody?.genre_upvotes}
                id={moody?.id}/>
      </article>
    </main>
  )
}

export default Bord