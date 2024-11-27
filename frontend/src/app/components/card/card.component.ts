import { Component, Input } from '@angular/core';
import { bootstrapStarFill } from '@ng-icons/bootstrap-icons';
import { NgIcon, provideIcons } from '@ng-icons/core';
import { MovieCard } from '../../interface/IMovie';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [NgIcon],
  viewProviders: [provideIcons({bootstrapStarFill})],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {

  @Input() public moviesData: MovieCard = {
    title: '',
    genre: '',
    img: '',
    rating: 0
  }

}
