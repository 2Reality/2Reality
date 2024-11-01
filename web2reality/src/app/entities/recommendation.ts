import {Image} from "./image";

export interface Recommendation {
  id?: number,
  title?: string,
  description?: string,
  start?: any,
  finish?: any
  score?: any

  geo?: string,
  longitude?: any
  latitude?: any
  distance?: any

  fullname?: string
  nickname?: string
  sex?: any,
  birthDate?: any,
  age?: any
  image?: Image
}
