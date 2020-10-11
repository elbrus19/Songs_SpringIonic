import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Song } from '../models/song';
import { SongService } from '../services/song.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.page.html',
  styleUrls: ['./list.page.scss'],
})
export class ListPage implements OnInit {

  songs: Song[];
  
  constructor(private songService: SongService, private router: Router) {}

  ngOnInit() {
    this.getAllSongs();
  }

  ionViewDidEnter() {
    this.getAllSongs();
  }

  getAllSongs() {
    this.songService.getSongs().subscribe(songs => {
      this.songs = songs;
    });
  }

  deleteSong(id: number) {
    this.songService.deleteSong(id).subscribe(() => {
      this.getAllSongs();
    });
  }

  insertSong() {
    this.router.navigateByUrl("/add-song");
  }
}
