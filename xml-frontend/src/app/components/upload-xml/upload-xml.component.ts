import { Component } from '@angular/core';
import { UploadXmlService } from 'src/app/services/upload-xml/upload-xml.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-upload-xml',
  templateUrl: './upload-xml.component.html',
  styleUrls: ['./upload-xml.component.css']
})
export class UploadXmlComponent {

  selectedFilesList: File[];
  sending: boolean = false;
  data: any;
  columns = ["Nome"];

  constructor(private uploadXmlService: UploadXmlService) {
    this.selectedFilesList = [];
  }

  selectedXml(event: any) {
    this.selectedFilesList = [].slice.call(event.target.files);
    this.data = new MatTableDataSource(this.selectedFilesList);
  }

  uploadXml() {
    if (this.selectedFilesList.length > 0) {
      this.sending = true;
      let sent = false;
      let qtSent = 0;
      let qtFiles = this.selectedFilesList.length;

      let success = "Upload realizado: ";
      let error = "Erro ao realizar Upload: ";

      this.selectedFilesList.forEach((file) => {
        this.uploadXmlService.register(file).subscribe({
          next: () => {
            qtSent++;
            sent = qtSent === qtFiles;
            this.data = new MatTableDataSource([]);
            success = success + "-" + file.name;
            if (sent) {
              this.sending = false;
              alert(success);
            }
          },
          error: () => {
            qtSent++;
            sent = qtSent === qtFiles;
            this.data = new MatTableDataSource([]);
            error = error + "-" + file.name;
            if (sent) {
              this.sending = false;
              alert(error);
            }
          },
          complete: () => {
            console.log("Upload completo");
          },
        });
      });
    } else {
      console.log(
        "Nenhum arquivo selecionado"
      );
    }
  }

}
