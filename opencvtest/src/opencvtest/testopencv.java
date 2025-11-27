package opencvtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
// 
public class testopencv {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

       
        String path = "C:/Romain/chat.jpg";
        Mat img = Imgcodecs.imread(path);

        if (img.empty()) {
            System.out.println(" Impossible de charger l'image !");
            return;
        }

        
        BufferedImage buff = matToBufferedImage(img);

        JFrame frame = new JFrame("Image OpenCV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(new ImageIcon(buff)));
        frame.pack();
        frame.setVisible(true);
    }

    public static BufferedImage matToBufferedImage(Mat matrix) {
        int type = BufferedImage.TYPE_3BYTE_BGR;
        if (matrix.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        }
        BufferedImage image = new BufferedImage(matrix.width(), matrix.height(), type);
        byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        matrix.get(0, 0, data);
        return image;
    }
}