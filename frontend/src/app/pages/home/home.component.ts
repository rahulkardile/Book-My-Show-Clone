import { Component } from '@angular/core';
import { bootstrapArrowLeftCircleFill, bootstrapArrowRightCircleFill, bootstrapStarFill } from '@ng-icons/bootstrap-icons';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { CardComponent } from '../../components/card/card.component';
import { MoviesServiceService } from '../../core/movieService/movies-service.service';
import { CardMovieApiResponse, MovieCard } from '../../interface/IMovie';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgIcon, CardComponent, CommonModule],
  viewProviders: [provideIcons({ bootstrapArrowLeftCircleFill, bootstrapArrowRightCircleFill })],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  public current: number = 0;
  
  public moviesData: MovieCard[] = [{
    title: '',
    genre: '',
    img: '',
    rating: 0
  }]

  constructor(private getMovies: MoviesServiceService) {

    const movieDate = getMovies.getAllMovieForCard().subscribe({
      next: (res: CardMovieApiResponse )=>{
        if(res.success === true){
          this.moviesData = res.data
        }
        console.log(this.moviesData);
      }
    })

   }

  previousSlide() {
    if (this.current === 0) {
      this.current = this.images.length - 1; 
    } else {
      this.current -= 1;
    }
  }

  nextSlide() {
    if (this.current === this.images.length - 1) {
      this.current = 0;
    } else {
      this.current += 1;
    }
  }

  images: string[] = [
    "https://assets-in.bmscdn.com/promotions/cms/creatives/1730301672680_rahulduawebn.jpg",
    "https://assets-in.bmscdn.com/promotions/cms/creatives/1732278881289_sojbmsbanner1240x300.jpg",
    "https://assets-in.bmscdn.com/promotions/cms/creatives/1726036566435_playcardnewweb.jpg",
    "https://assets-in.bmscdn.com/promotions/cms/creatives/1732022746355_1worldofchristmasatjioworlddrivewebshowcase1240x300.jpg"
  ]


}
