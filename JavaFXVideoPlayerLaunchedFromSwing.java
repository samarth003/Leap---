
package com.leapmotion.codeGist;

import java.io.*;
import java.util.*;
import javafx.application.Platform;
import javafx.beans.value.*;
import javafx.embed.swing.JFXPanel;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.util.Duration;
import javax.swing.*;
import com.leapmotion.leap.*;

/** Example of playing all mp3 audio files in a given directory 
 * using a JavaFX MediaView launched from Swing 
 */

public class JavaFXVideoPlayerLaunchedFromSwing extends JFrame{
  
	public static final int MusicPaneWidth = 800;
	public static final int MusicPaneHeight = 600;
	private MusicPaneListener MusicPanel;
	private Controller controller;
	private SceneGenerator geneScene;
	public JavaFXVideoPlayerLaunchedFromSwing(LeapFrame leapFrame/*, SceneGenerator scenePlay*/){
		
		super("Beats");
		final JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		geneScene = new SceneGenerator(this, leapFrame);
		
		MusicPanel = new MusicPaneListener(this, leapFrame, geneScene);
		controller = new Controller();
		controller.addListener(MusicPanel);
		//MusicPanel.GestureRecog(gesture, controller);
		//JFrame frame = new JFrame("Beats");
	    
	    //frame.add(fxPanel);
	    this.setSize(MusicPaneWidth, MusicPaneHeight);//TODO
	    this.setLocationRelativeTo(null);//TODO
	    //frame.setBounds(200, 100, 800, 250);
	    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    //this.setVisible(true);
	    
	  
	    final LeapFrame lf = leapFrame;
	    Platform.runLater(new Runnable() {
	    //SwingUtilities.invokeLater(new Runnable(){
	      @Override public void run() {
	        initFX(fxPanel, lf, geneScene);        
	      }
	    });

		
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override public void run() {
//				initAndShowGUI();
//			}
//		});
	}

  public void initFX(JFXPanel fxPanel, LeapFrame leapFrame, SceneGenerator scene) {
    // This method is invoked on JavaFX thread
//    SceneGenerator scene = new SceneGenerator(this, leapFrame);
    Scene s = scene.createScene(MusicPanel); //TODO: check on the argument
    fxPanel.setScene(s);
  }  
}
