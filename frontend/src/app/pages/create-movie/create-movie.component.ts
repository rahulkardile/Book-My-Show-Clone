import { Component } from '@angular/core';
import { Movie } from '../../interface/types';
import { FormsModule } from '@angular/forms';
import { MoviesServiceService } from '../../core/movieService/movies-service.service';

@Component({
  selector: 'app-create-movie',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css'],
})
export class CreateMovieComponent {

  // MovieData: Movie = {
  //   title: '',
  //   genre: '',
  //   duration: '',
  //   endDate: '',
  //   rating: 0,
  //   poster_data: null,
  //   poster_name: null,
  //   poster_type: null,
  //   releaseDate: '',
  //   description: '',
  //   language: '',
  //   img: ''
  // };

  hours: number = 1;
  minutes: number = 0;
  seconds: number = 0;

  MovieData: Movie = {
    title: 'The Dark Knight',
    genre: 'Action, Crime, Drama',
    duration: 'PT2H32M',
    endDate: '2024-12-31',
    rating: 9.0,
    poster_data: null,
    poster_name: null,
    poster_type: null,
    releaseDate: '2008-07-18',
    description: 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.',
    language: 'English',
    img: 'https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg' // URL to the movie poster
  };
  
  constructor(private moviesService: MoviesServiceService) {

    const data = moviesService.getAllMovie().subscribe({
      next: (res) => {
        console.log(res);

      }
    })

  }

  onSubmit() {

    this.MovieData.duration = `${this.hours}h ${this.minutes}m ${this.seconds}s`;
    console.log(this.MovieData);
    
    this.moviesService.createMovie(this.MovieData).subscribe(
      (response) => {
        console.log('Movie created successfully:', response);
        alert('Movie created successfully!');
        this.resetForm();
      }
    );
  }

  resetForm() {
    this.MovieData = {
      title: '',
      genre: '',
      duration: '',
      endDate: '',
      rating: 0,
      releaseDate: '',
      description: '',
      language: '',
      img: '',
      poster_data: null,
      poster_name: null,
      poster_type: null
    };
  }

}
