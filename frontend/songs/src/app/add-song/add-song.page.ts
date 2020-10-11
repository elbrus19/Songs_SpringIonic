import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SongService } from '../services/song.service';

@Component({
  selector: 'app-add-song',
  templateUrl: './add-song.page.html',
  styleUrls: ['./add-song.page.scss'],
})
export class AddSongPage implements OnInit {

  songForm: FormGroup;

  constructor(public fb: FormBuilder, private songService: SongService, private router: Router) {
    this.songForm = this.fb.group({
      name: [''],
      artist: [''],
      lenght: [''],
      year: ['']
    })
   }

  ngOnInit() {
  }

  onFormSubmit() {
    if (!this.songForm.valid) {
      return false;
    } else {
      let song = {
        id: null,
        name: this.songForm.value.name,
        artist: this.songForm.value.artist,
        lenght: this.songForm.value.lenght,
        year: this.songForm.value.year,
      }
      this.songService.addSong(song)
        .subscribe((res) => {
          this.router.navigateByUrl("/list");
          })
        };
    }
}
