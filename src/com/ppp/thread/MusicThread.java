package com.ppp.thread;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicThread extends Thread {
	
	private String fileName;

	private AudioFormat format;

	private byte[] samples; //audio

	public  MusicThread(String fileName){

		this.fileName = fileName;

		reverseMusic();
	}

	public void reverseMusic(){

		try {
			// open the audio input stream
			AudioInputStream stream =AudioSystem.getAudioInputStream(new File(fileName));
			format = stream.getFormat();
			// get the audio samples
			samples = getSamples(stream);
		}
		catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public byte[] getSamples(AudioInputStream audioStream) {

		int length = (int)(audioStream.getFrameLength() * format.getFrameSize());

		byte[] samples = new byte[length];

		DataInputStream is = new DataInputStream(audioStream);

		try {

			is.readFully(samples);

		}catch (IOException ex) {
			ex.printStackTrace();
		}
		return samples;
	}

	public void play(InputStream source) {
	
		int bufferSize = format.getFrameSize() *
				Math.round(format.getSampleRate());
		byte[] buffer = new byte[bufferSize];
		
		SourceDataLine line;
		try {
			DataLine.Info info =
					new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(format, bufferSize);
		}
		catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		
		line.start();
		
		try {
			int numBytesRead = 0;
			while (numBytesRead != -1) {
				
				numBytesRead =
						source.read(buffer, 0, buffer.length);
				if (numBytesRead != -1) {
					line.write(buffer, 0, numBytesRead);
				}
			}
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		line.drain();
		line.close();
	}

	public void run(){
			
		InputStream stream =new ByteArrayInputStream(samples);
				
		play(stream);
		


}

}
