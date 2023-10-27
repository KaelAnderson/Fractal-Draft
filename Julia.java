package com.example.newfractaldraft;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

//c1 is the unchanging complex number the julia
// set is based on, c0 is the changing one that we are checking if it fits in the parameters
public class Julia {
    public static int width = 800;
    public static int height = 600;

    //my complex number im basing this julia set off of
    ComplexNum c1 = new ComplexNum(-0.79, 0.15);

    // 2d array of booleans to decide if the values go inside the fractal or not
    public boolean[][] pixels = null;

    //complex number bounds
    public double minX = -1.5;
    public double minY = -1.5;
    public double maxX = 1.5;
    public double maxY = 1.5;

    //i dont think i need to make a new scene for it if i can just the same one for all of them

    public double comNumThreshold = 2.0000;
    public int numIterations = 50;
    //THIS IS GOING TO BE CUSTOMIZABLE
    WritableImage juliaImage;

    //main constructor for the set; needs to make the image and if the boolean array
    //for i j is true make it black if not make it white
    public Julia() {
        juliaImage = new WritableImage(800,600);
        PixelWriter juliaWriter = juliaImage.getPixelWriter();
        getValues();

        //maybe i need a set colors method

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (pixels[i][j]) {
                    juliaWriter.setColor(i,j,Color.WHITE);
                    //gc.setFill(Color.BLACK);
                    //gc.fillRect(i,i,j,j);
                }
                if (!pixels[i][j]) {
                    juliaWriter.setColor(i,j,Color.BLACK);
                }

            }
        }

    }


    public WritableImage getJuliaImage()
    {
        return juliaImage;
    }

    public boolean inSet(ComplexNum c0)
    {
        for (int i = 0; i < numIterations; i++) {
            c0 = c0.square().add(c1);
            //z = z^2+c
        }
        return c0.zMagnitude() < comNumThreshold;
    }
    //get values method
    public void getValues() {
        pixels = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //the complex number plane has 0,0 in the middle so i have to shift everything
                //i will probably explain how this works on my power point
                double a = (((double) i * (maxX-minX))/(double)width) - maxX;
                //i have to explicitly state to treate i and j like doubles
                double b = (((double) -j * (maxY-minY))/(double)height) + maxY;
                //fill the array so ones that are true will be set to while and false will be black
                pixels[i][j] = inSet(new ComplexNum(a, b));
            }
        }
    }



}

