
import java.awt.Color;

/**
 * This is the starter files for the DistortedImage assignment.
 * On a given input image, decode the image and save it as a new one.
 * The secret image you need to decode is in img folder: secret.png.
 * 
 * How-to:
 * The Green and Blue components of the input image are random noise.
 * To decode the input image, get rid of the Green and Blue components.
 * Then, multiply the Red component of pixels by 10 and save the image.
 * 
 * Helpful notes:
 * SimpleImage class encapsulates the complexity of working with
 * individual pixels in the image. It supports only jpg and png.
 * 
 * To work with the SimpleImage, look into its code.
 * 1. To load an image using the following command:
 *    SimpleImage si = new SimpleImage("path_to_your_input_file.png");
 * 2. To access the height and width:
 *    si.height() and si.width(), where si is a SimpleImage object
 * 3. To get the color of a pixel:
 *    Color c = si.get(x, y); // where x and y are the coordinates
 *                            // of the pixel on the image
 *    Read about the Color class in Java documentation if needed.
 * 4. To get Red, Green, or Blue components from the Color object:
 *    int red   = c.getRed(); // where c is a Color object
 *    int green = c.getGreen();
 *    int blue  = c.getBlue();
 * 5. To change the color of a pixel on the SimpleImage:
 *    si.set(x, y, newColor); // where x and y are the coordinates;
 *                            // newColor is a Color object
 * 6. To save a SimpleImage object si:
 *    si.save("path_to_the_new_image.png");
 * 
 * @author Rowan Flynn
 *
 */
public class ImageBuster {

    public static void main(String[] args) {
       
        SimpleImage secret = new SimpleImage("/workspaces/inception-rowflynn/img/secret.png");
        int height = secret.height();
        int width = secret.width();
        SimpleImage decoded = new SimpleImage(width,height);
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Color c = secret.get(i,j);
                int red = c.getRed() * 10;
                Color newColor = new Color(red, 0, 0);
                decoded.set(i,j,newColor);
            }
        }
        decoded.save("/workspaces/inception-rowflynn/img/decoded.png");
    }

}
