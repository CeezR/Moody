import React, { useEffect, useState } from 'react'
import SearchForm from './SearchForm'
import MoodyCard from './MoodyCard'
import { createApi } from 'unsplash-js';
import { Photos } from 'unsplash-js/dist/methods/search/types/response';

type moodyData = {
  weatherDescription: string | undefined;
  genreName: string | undefined;
  genre_message: string | undefined;
  genre_upvotes : number | undefined;
  id : string | undefined;
}

const Bord = () => {
  const [moody, setMoody] = useState<moodyData>();
  const [weatherImage, setWeatherImage] = useState<string | undefined>(undefined);
  const [genreImage, setGenreImage] = useState<string | undefined>(undefined);

  const api = createApi({
    accessKey: import.meta.env.VITE_APP_UNSPLASH_ACCESS_KEY
  });

  const fetchResult = async (query : string) : Promise<string | undefined> => {
    // if(query == undefined) return;
    try {
      const data = await api.search.getPhotos({ query: query, page: 1, orientation: "landscape" });
      if(data.response == undefined) {
        return undefined;
      }

      var randomIndex = Math.floor(Math.random() * data.response?.results.length);
      return data.response?.results[randomIndex].urls.small;
    } catch(error)  {
      console.log("something went wrong!");
      }
    }

    useEffect(() => {
      if(moody?.weatherDescription != undefined) {
        fetchResult(moody?.weatherDescription).then((url) => setWeatherImage(url));
      }

      if(moody?.genreName != undefined) {
        fetchResult(moody?.genreName).then((url) => setGenreImage(url));
      }
    }, [moody]);

  return (
    <main className='m-4'>
      <SearchForm setMoody={setMoody}/>
      <article className='my-3'>
        {moody && <MoodyCard 
                weatherDescription={moody?.weatherDescription} 
                genreName={moody?.genreName} 
                genre_message={moody?.genre_message}
                genre_upvotes={moody?.genre_upvotes}
                id={moody?.id}
                weatherImgUrl={weatherImage}
                genreImgUrl={genreImage}
                />}
      </article>
    </main>
  )
}

export default Bord