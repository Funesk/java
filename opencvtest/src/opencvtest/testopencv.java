package opencvtest;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class testopencv {
    public static void main(String[] args) {


        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("OpenCV chargé avec succès !");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Erreur : impossible de charger OpenCV.");
            System.err.println("Assure-toi que le chemin vers les DLL / .so est correctement configuré.");
            return;
        }


        System.out.println("Version OpenCV : " + Core.VERSION);

        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("Matrice de test :\n" + mat.dump());
    }
}