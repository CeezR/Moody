-- Insert into weather
INSERT INTO public.weather (weather_code, weather_description)
VALUES
    (1, 'Sunny'),
    (2, 'Rainy'),
    (3, 'Partly Cloudy'),
    (4, 'Overcast'),
    (5, 'Clear Night'),
    (0, 'Sunny');

-- Insert into genre
INSERT INTO public.genre (weather_id, genre_name, genre_message, genre_upvotes)
VALUES
    (1, 'Pop', 'Suns out! Time for some pop to brighten your day even more.', 0),
    (2, 'Blues', 'Rain tapping on your window, and Blues to soothe your soul.', 0),
    (2, 'Acoustic', 'Let the acoustic tunes mingle with the sound of the rain.', 0),
    (3, 'Indie Rock', 'A little sun, a little shade. A bit of Indie rock to make your day.', 0),
    (4, 'Alternative Rock', 'Under the gray skies, rock out with some Alternative tunes.', 0),
    (5, 'Jazz', 'Stars and Jazz, the perfect late-night blend.', 0),
    (6, 'Rock', 'Rock and Roll', 0);

