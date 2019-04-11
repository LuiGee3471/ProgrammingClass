import React, { Component } from "react";
import "./App.css";
import Movie from "./Movie";

class App extends Component {
  // Render : componentWillMount() -> render() -> componentDidMount()
  // Update : componentWillReceiveProps() -> shouldComponentUpdate() -> componentWillUpdate() -> render() -> componentDidUpdate()

  state = {};

  componentDidMount() {
    setTimeout(() => {
      this.setState({
        movies: [
          {
            title: "Matrix",
            poster:
              "https://assets.www.warnerbros.com/sites/default/files/movies/media/browser/Matrix_2000x3000.JPEG",
          },
          {
            title: "Full Metal Jacket",
            poster:
              "https://i-h2.pinimg.com/474x/36/1e/cd/361ecdb85a3767f70810cbe2cdaaf1a4.jpg",
          },
          {
            title: "Oldboy",
            poster:
              "https://upload.wikimedia.org/wikipedia/en/6/67/Oldboykoreanposter.jpg",
          },
          {
            title: "Star Wars",
            poster:
              "https://m.media-amazon.com/images/M/MV5BNzVlY2MwMjktM2E4OS00Y2Y3LWE3ZjctYzhkZGM3YzA1ZWM2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,643,1000_AL_.jpg",
          },
          {
            title: "Trainspotting",
            poster:
              "https://resizing.flixster.com/Lg4koS6QEoyoSzhIQ9mFbO-c3OE=/206x305/v1.bTsxMTE3NjEwNztqOzE4MDg0OzEyMDA7ODAwOzEyMDA",
          },
        ],
      });
    }, 2000);
  }

  _renderMovies = () => {
    const movies = this.state.movies.map((movie, index) => {
      return <Movie title={movie.title} poster={movie.poster} key={index} />;
    });
    return movies;
  };

  render() {
    return (
      <div className="App">
        {this.state.movies ? this._renderMovies() : "Loading"}
      </div>
    );
  }
}

export default App;
