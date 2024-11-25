import { Component } from '@angular/core';
import { Movie } from '../../interface/types';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-movie',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css'],
})
export class CreateMovieComponent {
  MovieData: Movie = {
    title: '',
    genre: '',
    duration: '',
    endDate: '',
    rating: 0,
    releaseDate: '',
    description: '',
    language: '',
  };

  onSubmit() {
    console.log(this.MovieData);
  }
}
