import React from 'react';
import PropTypes from 'prop-types';
import LinesEllipsis from '../node_modules/react-lines-ellipsis';
import './Movie.css';

function Movie({ title, poster, genres, synopsis }) {
  return (
    <div className="movie">
      <div className="movie-columns">
        <MoviePoster poster={poster} alt={title} />
      </div>
      <div className="movie-columns">
        <h1>{title}</h1>
        <div className="movie-genres">
          {genres.map((genre, index) => (
            <MovieGenre genre={genre} key={index} />
          ))}
        </div>
        <LinesEllipsis
          text={synopsis}
          maxLine="4"
          ellipsis="..."
          trimRight
          basedOn="letters"
        />
      </div>
    </div>
  );
}

Movie.propTypes = {
  title: PropTypes.string.isRequired,
  poster: PropTypes.string.isRequired,
  genres: PropTypes.array.isRequired,
  synopsis: PropTypes.string.isRequired,
};

function MoviePoster({ poster, alt }) {
  return (
    <img
      src={poster}
      width="200px"
      alt={alt}
      title={alt}
      className="movie-poster"
    />
  );
}

function MovieGenre({ genre }) {
  return <span className="movie-genre">{genre}</span>;
}

MoviePoster.propTypes = {
  poster: PropTypes.string.isRequired,
  alt: PropTypes.string.isRequired,
};

MovieGenre.propTypes = {
  genre: PropTypes.string.isRequired,
};
export default Movie;
