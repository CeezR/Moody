import React from 'react'

const SearchForm = () => {
  const handleSubmit = async () => {
    // event.preventDefault();
    // try {
    //   const response = await handleFetch();
      
    //   if (!response.ok) {
    //     setShowErrorAlert(true);
    //     setTimeout(() => setShowErrorAlert(false), 3000);
    //   } else {
    //     setShowSuccessAlert(fullName);
    //     setTimeout(() => setShowSuccessAlert(null), 3000);
    //     setFullName("");
    //     setBootcamp(Object.keys(Bootcamps)[0]);
    //     setRefetch(true);
    //   }
    // } catch (error) {
    //   console.error('Fetch failed:', error);
    // } 
  };

  return (
    <form onSubmit={handleSubmit} id='addDeveloperForm'>
    <div className='row g-3 align-items-center'>
      <div className='col-6'>
        <label htmlFor="latitude">Latitude</label>
        <input
                type="text" 
                id="latitude" 
                name="latitude" 
                className="form-control form__input-name" 
                placeholder="59.3294"/>
      </div>
      <div className='col-6'>
        <label htmlFor="longitude">Longitude</label>
        <input
                type="text" 
                id="longitude" 
                name="longitude" 
                className="form-control form__input-name" 
                placeholder="18.0687"/>
      </div>
    </div>
    <button className='form__button-addDev btn btn-primary mx-auto d-block mt-3' type="submit" value="Submit">Submit</button>
  </form>
  )
}

export default SearchForm