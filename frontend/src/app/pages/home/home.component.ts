import { AfterViewInit, Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'], // Fixed plural for styles
})
export class HomeComponent implements AfterViewInit {
  slides: HTMLElement[] = [];
  count = 0;

  constructor() {}

  ngAfterViewInit(): void {
    this.slides = Array.from(document.querySelectorAll('#slide'));

    this.slides.forEach((slide, index) => {
      slide.style.left = `${index * 100}%`;
    });

    this.startCarousel();
  }

  startCarousel(): void {
    setInterval(() => {
      this.count = (this.count + 1) % this.slides.length; // Loop back to the first slide
      this.slides.forEach((slide, index) => {
        slide.style.transform = `translateX(-${this.count * 100}%)`;
        slide.style.transition = 'transform 0.5s ease-in-out';
      });
    }, 3000); // Change slide every 3 seconds
  }
}
