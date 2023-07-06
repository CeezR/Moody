-- Insert into weather
INSERT INTO public.weather (weather_code, weather_description)
VALUES
    (1, 'Sunny'),
    (2, 'Rainy'),
    (3, 'Partly Cloudy'),
    (4, 'Overcast'),
    (5, 'Clear Night');

-- Insert into genre
INSERT INTO public.genre (weather_id, genre_name, genre_message)
VALUES
    (1, 'Pop', 'Suns out! Time for some pop to brighten your day even more.'),
    (2, 'Blues', 'Rain tapping on your window, and Blues to soothe your soul.'),
    (2, 'Acoustic', 'Let the acoustic tunes mingle with the sound of the rain.'),
    (3, 'Indie Rock', 'A little sun, a little shade. A bit of Indie rock to make your day.'),
    (4, 'Alternative Rock', 'Under the gray skies, rock out with some Alternative tunes.'),
    (5, 'Jazz', 'Stars and Jazz, the perfect late-night blend.');

