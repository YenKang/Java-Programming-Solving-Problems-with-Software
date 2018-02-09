
/**
 * Write a description of ImageSaver here.
 * 
 * @author (Yen Kang) 
 * @version (2017-08-12 v1)
 */
import edu.duke.*;
import java.io.File;

public class  BatchInversions{


    public ImageResource makeInversion(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//compute inPixel's red + inPixel's blue + inPixel's green
			//divide that sum by 3 (call it average)
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			//set pixel's red to average
			pixel.setRed(255-inPixel.getRed());
			//set pixel's green to average
			pixel.setGreen(255-inPixel.getGreen());
			//set pixel's blue to average
			pixel.setBlue(255-inPixel.getBlue());
		}
		//outImage is your answer
		return outImage;
	}


	public void  selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();

        for(File f: dr.selectedFiles()){

            ImageResource image = new ImageResource(f);

            ImageResource invertedImage = makeInversion(image);
            
            String fname = image.getFileName();
            String newName = "inverted-"+ fname;

            invertedImage.setFileName(newName);
           	invertedImage.draw();
           	invertedImage.save();
        }
    }




}