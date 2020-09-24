package com.example.my_music;

public class Song
{

        private String title;
        private  int File;

        public Song(String title, int file)
        {
            this.title = title;
            File = file;
        }
        public void setFile(int file)
        {
            File = file;
        }
        public int getFile()
        {
            return File;
        }
        public void setTitle(String title)
        {
            this.title = title;
        }
        public String getTitle()
        {
            return title;
        }
}
