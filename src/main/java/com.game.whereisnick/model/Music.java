package com.game.whereisnick.model;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music {

  public void playMusic(String musicLocation) {

    try {
      File musicPath = new File(musicLocation);

      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        JOptionPane.showMessageDialog(null, "Press OK to pause");
        long clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();

        JOptionPane.showMessageDialog(null, "Hit OK to resume");
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
        //clip.stop();

        JOptionPane.showMessageDialog(null, "Press OK to stop playing");
        clip.stop();

        JOptionPane.showMessageDialog(null, "Press OK to start playing");
        clip.start();
        //clip.stop();

      } else{
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }


}