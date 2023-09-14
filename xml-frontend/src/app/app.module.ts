import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MenuHeaderComponent } from './shared/menu-header/menu-header.component';
import { UploadXmlComponent } from './components/upload-xml/upload-xml.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    AppComponent,
    MenuHeaderComponent,
    UploadXmlComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

    MatToolbarModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
