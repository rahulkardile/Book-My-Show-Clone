export interface UserRegistration {
  userId?: number;
  name?: string;
  email: string;
  username: string;
  phone: string;
  location?: string;
  password?: string;
  type?: UserType;
  createdAt?: Date;
}

export interface UserLogin {
  username: string;
  password: string;
}

export enum UserType {
  ADMIN = "ADMIN",
  USER = "USER",
  GUEST = "GUEST",
}

export interface LoginResponse {
  message: string;
  token: string | null;
  statusCode: number;
  success: boolean;
}