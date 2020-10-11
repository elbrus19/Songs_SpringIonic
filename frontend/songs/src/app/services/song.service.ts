import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Song } from '../models/song';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'})
};
const apiUrl = 'http://localhost:8080/api/songs';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private http: HttpClient) { }
  
  getSongs(): Observable<Song[]> {
    return this.http.get<Song[]>(apiUrl)
  }

  deleteSong(id: number): Observable<any>{
    return this.http.delete(apiUrl + "/" + id);
  }

  addSong(song: Song): Observable<any>{

    let bodyEncoded = new URLSearchParams();
    bodyEncoded.append("name", song.name);
    bodyEncoded.append("artist", song.artist);
    bodyEncoded.append("lenght", song.lenght);
    bodyEncoded.append("year", song.year);
    let body = bodyEncoded.toString();

    return this.http.post(apiUrl, body, httpOptions);
  }
}