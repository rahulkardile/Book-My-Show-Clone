export interface MovieCard {
    title: string;
    genre: string;
    rating: number;
    img: string;
  }
  
  export interface CardMovieApiResponse {
    message: string;
    token: string | null;
    statusCode: number;
    success: boolean;
    data: MovieCard[];
  }
  
